package kr.co.renzo.web.Service;

import kr.co.renzo.domain.goods.entity.Goods;
import kr.co.renzo.domain.goods.service.GoodsService;
import kr.co.renzo.web.request.GoodsRequest;
import kr.co.renzo.web.response.GoodsItemResponse;
import kr.co.renzo.web.response.GoodsResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class GoodsAppService {

    private final GoodsService goodsService;

    private GoodsResponse newInstanceGoodsResponse() {
        return new GoodsResponse();
    }


    @Transactional
    public List<GoodsResponse> getAllByGoods(List<Long> goodsNos ){

        List<GoodsResponse> goodsResponseList= new ArrayList<>();
        List<Goods> resultGoods = goodsService.getAllByGoodsId(goodsNos);

        resultGoods.forEach(goods->{
            GoodsResponse goodsResponse = newInstanceGoodsResponse();
            goodsResponseList.add(
                GoodsResponse.builder()
                    .goodsId(goods.getGoodsId())
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
                    .build()
            );
        });

        return goodsResponseList;
    }



    /**
     * 상품 등록시 valied 정책을 기반으로 체크 하면서 등록이 되어야합니다.
     * 필요한 선행조건은 만족하는지에 대한 부분들도 추가되어야 하고
     *
     * 전달받은 Request 에 대해서 검증되고 요청한 수만큼
     * 반환 되어 확인이 필요한 것들이 들어가야합니다.
     *
     * 과제 시간상 이부분 보다는
     * 구조적인 multi module와 서비스 구조
     * DDD 구조로 용도에 맞는 역활분담에 초점을 맞추는 형태로 고려하였습니다.
     *
     * 유연한 확장성과 약한 결합도를 유지하기 위한 부분도 고민하였습니다.
     *
     * 리펙토링 하자면
     * queue 추가 해서 topic 방식으로 전파 가능하게 작업필요함.
     * 후처리 해야되는 이미지들은 별도 비동기 처리
     * DW 관점에서 Nosql 로 전달추가
     * 상품 상태에 따라서 전시영역에 cache 추가
     * 검색엔진에 상품 증분색인 추가
     *
     * @param goodsRequestList
     * @return
     */
    @Transactional
    public List<GoodsResponse> createGoods(List<GoodsRequest> goodsRequestList){
        List<GoodsResponse> goodsResponseList= new ArrayList<>();
        goodsRequestList.forEach(goodsRequest->{
            Goods goods = goodsRequest.toEntity();
            goodsRequest.getGoodsItemList().stream().map(goodsItem -> {
                goodsItem.setGoods(goods);
                return goodsItem;
            }).collect(Collectors.toList());
            Goods resultGoods = goodsService.save(goods);

            GoodsResponse response = newInstanceGoodsResponse();
            goodsResponseList.add(
                GoodsResponse.builder()
                    .goodsId(resultGoods.getGoodsId())
                    .goodsItems(resultGoods.getGoodsItemList())
                    .statusName(resultGoods.getStatusName())
                    .displayCategoryId(resultGoods.getDisplayCategoryId())
                    .sellerGoodsName(resultGoods.getSellerGoodsName())
                    .goodsDetails(resultGoods.getGoodsDetails())
                    .vendorId(resultGoods.getVendorId())
                    .saleStartedAt(resultGoods.getSaleStartedAt())
                    .saleEndedAt(resultGoods.getSaleEndedAt())
                    .displayGoodsName(resultGoods.getDisplayGoodsName())
                    .brand(resultGoods.getBrand())
                    .deliveryMethod(resultGoods.getDeliveryMethod())
                    .deliveryCompanyCode(resultGoods.getDeliveryCompanyCode())
                    .deliveryCharge(resultGoods.getDeliveryCharge())
                    .returnCenterId(resultGoods.getReturnCenterId())
                    .build()
            );
        });
        return goodsResponseList;
    }
}
