package kr.co.renzo.web.request;

import kr.co.renzo.domain.goods.entity.Goods;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class GoodsRequest {

    private Long goodsId;

    private String sellerGoodsName;

    private String goodsDetails;

    private Long vendorId;

    public Goods toEntity(){
        return Goods.builder()
                .sellerGoodsName(sellerGoodsName)
                .goodsDetails(goodsDetails)
                .vendorId(vendorId)
                .build();
    }


}
