package se331.lab.service;

import org.springframework.data.domain.Page;
import se331.lab.entity.Bid;

import java.util.List;

public interface BidService {
    List<Bid> getAllBid();
    Page<Bid> getBid(Integer page, Integer pageSize);
}
