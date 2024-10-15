package se331.lab.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.lab.entity.AuctionItem;

public interface AuctionItemDao {
    Integer getAuctionItemSize();
    Page<AuctionItem> getAuctionItems(Integer pageSize, Integer page);
    AuctionItem getAuctionItem(Long id);
    Page<AuctionItem> getAuctionItems(String name, Pageable page);
    Page<AuctionItem> getAuctionItems(String description, Long maxBid, Pageable pageable);
}
