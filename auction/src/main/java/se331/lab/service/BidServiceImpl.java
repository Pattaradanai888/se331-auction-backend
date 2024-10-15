package se331.lab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.lab.dao.BidDao;
import se331.lab.entity.Bid;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BidServiceImpl implements BidService {
    final BidDao bidDao;

    @Override
    public List<Bid> getAllBid() {
        return bidDao.getBids(Pageable.unpaged()).getContent();
    }

    @Override
    public Page<Bid> getBid(Integer page, Integer pageSize) {
        return bidDao.getBids(PageRequest.of(page, pageSize));
    }
}
