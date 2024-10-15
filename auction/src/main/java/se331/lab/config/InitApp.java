package se331.lab.config;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab.entity.AuctionItem;
import se331.lab.entity.Bid;
import se331.lab.repository.AuctionItemRepository;
import se331.lab.repository.BidRepository;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    AuctionItemRepository auctionItemRepository;
    final BidRepository bidRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        // Creating bids
        Bid b1 = bidRepository.save(Bid.builder().amount(100L).datetime("9/10/2024").build());
        Bid b2 = bidRepository.save(Bid.builder().amount(150L).datetime("9/11/2024").build());
        Bid b3 = bidRepository.save(Bid.builder().amount(200L).datetime("9/12/2024").build());

        Bid b4 = bidRepository.save(Bid.builder().amount(300L).datetime("9/13/2024").build());
        Bid b5 = bidRepository.save(Bid.builder().amount(350L).datetime("9/14/2024").build());
        Bid b6 = bidRepository.save(Bid.builder().amount(400L).datetime("9/15/2024").build());

        Bid b7 = bidRepository.save(Bid.builder().amount(500L).datetime("9/16/2024").build());
        Bid b8 = bidRepository.save(Bid.builder().amount(550L).datetime("9/17/2024").build());
        Bid b9 = bidRepository.save(Bid.builder().amount(600L).datetime("9/18/2024").build());

        Bid b10 = bidRepository.save(Bid.builder().amount(700L).datetime("9/19/2024").build());
        Bid b11 = bidRepository.save(Bid.builder().amount(750L).datetime("9/20/2024").build());
        Bid b12 = bidRepository.save(Bid.builder().amount(800L).datetime("9/21/2024").build());

        Bid b13 = bidRepository.save(Bid.builder().amount(900L).datetime("9/22/2024").build());
        Bid b14 = bidRepository.save(Bid.builder().amount(950L).datetime("9/23/2024").build());
        Bid b15 = bidRepository.save(Bid.builder().amount(1000L).datetime("9/24/2024").build());

        AuctionItem auctionItem1 = auctionItemRepository.save(AuctionItem.builder()
                .description("Mercedes-AMG S53")
                .type("Success")
                .build());
        auctionItem1.setBids(Arrays.asList(b1, b2, b3));
        b1.setItem(auctionItem1);
        b2.setItem(auctionItem1);
        b3.setItem(auctionItem1);  // Link bids to item
        auctionItem1.setSuccessfulBid(b3);  // Successful bid

        AuctionItem auctionItem2 = auctionItemRepository.save(AuctionItem.builder()
                .description("BMW X5")
                .type("Success")
                .build());
        auctionItem2.setBids(Arrays.asList(b4, b5, b6));
        b4.setItem(auctionItem2);
        b5.setItem(auctionItem2);
        b6.setItem(auctionItem2);
        auctionItem2.setSuccessfulBid(b6);  // Successful bid

        AuctionItem auctionItem3 = auctionItemRepository.save(AuctionItem.builder()
                .description("Audi Q7")
                .type("Success")
                .build());
        auctionItem3.setBids(Arrays.asList(b7, b8, b9));
        b7.setItem(auctionItem3);
        b8.setItem(auctionItem3);
        b9.setItem(auctionItem3);
        auctionItem3.setSuccessfulBid(b9);  // Successful bid

        AuctionItem auctionItem4 = auctionItemRepository.save(AuctionItem.builder()
                .description("Tesla Model S")
                .type("Open")
                .build());
        auctionItem4.setBids(Arrays.asList(b10, b11, b12));
        b10.setItem(auctionItem4);
        b11.setItem(auctionItem4);
        b12.setItem(auctionItem4);

        AuctionItem auctionItem5 = auctionItemRepository.save(AuctionItem.builder()
                .description("Ford Mustang")
                .type("Open")
                .build());
        auctionItem5.setBids(Arrays.asList(b13, b14, b15));
        b13.setItem(auctionItem5);
        b14.setItem(auctionItem5);
        b15.setItem(auctionItem5);
    }
}
