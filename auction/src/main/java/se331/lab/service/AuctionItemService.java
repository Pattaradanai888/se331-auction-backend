package se331.lab.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.lab.entity.AuctionItem;

public interface AuctionItemService {
    Integer getAuctionItemSize();
    Page<AuctionItem> getAuctionItems(Integer pageSize, Integer page);
    AuctionItem getAuctionItem(Long id);
    Page<AuctionItem> getAuctionItems(String title, Pageable pageable);
    Page<AuctionItem> getAuctionItems(String description, Long maxBid, Pageable pageable);
}
