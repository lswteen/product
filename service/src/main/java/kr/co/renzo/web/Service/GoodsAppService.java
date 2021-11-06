package kr.co.renzo.web.Service;

import kr.co.renzo.domain.goods.entity.Goods;
import kr.co.renzo.domain.goods.service.GoodsService;
import kr.co.renzo.web.response.GoodsResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class GoodsAppService {

    private final GoodsService goodsService;

    public List<GoodsResponse> getAllByGoodsNo(List<Long> goodsNos ){
        List<Goods> goods = goodsService.getAllByGoodsId(goodsNos);
        return goods.stream().map(item->GoodsResponse.builder()
                    .goodsId(item.getGoodsId())
                    .sellerGoodsName(item.getSellerGoodsName())
                    .goodsDetails(item.getGoodsDetails())
                    .vendorId(item.getVendorId())
                    .build())
                    .collect(Collectors.toList());
    }
}
