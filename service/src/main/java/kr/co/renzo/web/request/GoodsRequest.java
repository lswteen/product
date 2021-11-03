package kr.co.renzo.web.request;

import kr.co.renzo.domain.goods.entity.Goods;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class GoodsRequest {

    private Long goodsNo;

    private String goodsNm;

    private String goodsCont;

    private String comId;

    public Goods toEntity(){
        return Goods.builder()
                .goodsNm(goodsNm)
                .goodsCont(goodsCont)
                .comId(comId)
                .build();
    }


}
