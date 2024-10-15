package se331.lab.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.lab.entity.Bid;

import java.util.Optional;

public interface BidDao {
    Page<Bid> getBids(Pageable pageable);
    Optional<Bid> findById(Long id);
}
