package kr.co.renzo.web.Service;

import kr.co.renzo.domain.goods.entity.Goods;
import kr.co.renzo.domain.goods.service.GoodsService;
import kr.co.renzo.web.request.GoodsRequest;
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

    public List<GoodsResponse> getAllByGoods(List<Long> goodsNos ){
        List<Goods> goods = goodsService.getAllByGoodsId(goodsNos);
        return goods.stream().map(item->GoodsResponse.builder()
                    .goodsId(item.getGoodsId())
                    .sellerGoodsName(item.getSellerGoodsName())
                    .goodsDetails(item.getGoodsDetails())
                    .vendorId(item.getVendorId())
                    .build())
                    .collect(Collectors.toList());
    }

    public List<GoodsResponse> createGoods(List<GoodsRequest> goodsRequestList){
        List<Goods> goodsList = goodsRequestList.stream()
                .map(item ->
                    goodsService.save(item.toEntity())
                ).collect(Collectors.toList());

        List<GoodsResponse> goodsResponseList= goodsList.stream()
                .map(goods -> GoodsResponse.builder()
                        .goodsId(goods.getGoodsId())
                        .goodsItemList(goods.getGoodsItemList())
                        .statusName(goods.getStatusName())
                        .displayCategoryId(goods.getDisplayCategoryId())
                        .sellerGoodsName(goods.getSellerGoodsName())
                        .goodsDetails(goods.getGoodsDetails())
                        .vendorId(goods.getVendorId())
                        .saleStartedAt(goods.getSaleStartedAt())
                        .saleEndedAt(goods.getSaleEndedAt())
                        .displayGoodsName(goods.getDisplayGoodsName())
                        .brand(goods.getBrand())
                        .deliveryMethod(goods.getDeliveryMethod())
                        .deliveryCompanyCode(goods.getDeliveryCompanyCode())
                        .deliveryCharge(goods.getDeliveryCharge())
                        .returnCenterId(goods.getReturnCenterId())
                        .build()).collect(Collectors.toList());

        return goodsResponseList;
    }
}
