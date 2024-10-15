package se331.lab.util;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import se331.lab.entity.AuctionItem;
import se331.lab.entity.AuctionItemDTO;
import se331.lab.entity.Bid;
import se331.lab.entity.BidDTO;

import java.util.List;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);
    AuctionItemDTO getAuctionItemDto(AuctionItem auctionItem);
    List<AuctionItemDTO> getAuctionItemDto(List<AuctionItem> auctionItems);

    BidDTO getBidDTO(Bid bid);
    List<BidDTO> getBidDTO(List<Bid> bids);
}
