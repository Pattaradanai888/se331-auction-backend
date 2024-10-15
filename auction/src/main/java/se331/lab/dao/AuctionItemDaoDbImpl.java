package se331.lab.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.lab.entity.AuctionItem;
import se331.lab.repository.AuctionItemRepository;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class AuctionItemDaoDbImpl implements AuctionItemDao {
    final AuctionItemRepository auctionItemRepository;

    @Override
    public Integer getAuctionItemSize() {
        return Math.toIntExact(auctionItemRepository.count());
    }

    @Override
    public Page<AuctionItem> getAuctionItems(Integer pageSize, Integer page) {
        return auctionItemRepository.findAll(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public AuctionItem getAuctionItem(Long id) {
        return auctionItemRepository.findById(id).orElse(null);
    }

    @Override
    public Page<AuctionItem> getAuctionItems(String description, Pageable page) {
        return auctionItemRepository.findByDescriptionContainingIgnoreCaseOrTypeContainingIgnoreCase(description,description, page);
    }


    @Override
    public Page<AuctionItem> getAuctionItems(String description, Long maxBid, Pageable pageable) {
        return auctionItemRepository.findByDescriptionIgnoreCaseContainingAndSuccessfulBid_AmountLessThan(description, maxBid, pageable);
    }
}
