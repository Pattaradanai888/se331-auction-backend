package se331.lab.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se331.lab.entity.AuctionItem;
import se331.lab.service.AuctionItemService;
import se331.lab.util.LabMapper;

@Controller
public class AuctionController {

    final AuctionItemService auctionItemService;

    public AuctionController(AuctionItemService auctionItemService) {this.auctionItemService = auctionItemService;}

    @GetMapping("auctions")
    public ResponseEntity<?> getAuctionItemLists(
            @RequestParam(value = "_limit", required = false) Integer perPage
            , @RequestParam(value = "_page", required = false)Integer page
            , @RequestParam(value = "description", required = false) String description
            , @RequestParam(value = "maxBid", required = false) Long maxBid) {

        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;
        Page<AuctionItem> pageOutput;
        if (description != null && maxBid != null) {
            pageOutput = auctionItemService.getAuctionItems(description, maxBid, PageRequest.of(page - 1, perPage));
        }
        // Query by description only if maxBid is not provided
        else if (description != null) {
            pageOutput = auctionItemService.getAuctionItems(description, PageRequest.of(page - 1, perPage));
        }
        // Default to getting all auction items
        else {
            pageOutput = auctionItemService.getAuctionItems(perPage, page);
        }
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getAuctionItemDto(pageOutput.getContent() ) , responseHeaders, HttpStatus.OK);
    }
}
