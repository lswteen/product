package kr.co.renzo.web.request;

import kr.co.renzo.domain.goods.entity.GoodsItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class GoodsItemRequest {
    private long sellerGoodsItemId;
    private String itemName;
    private int originalPrice;
    private int salePrice;
    private int maximumBuyForPerson;
    private String adultOnly;
    private String taxType;
    private String modelNo;

//    public GoodsItem toEntity(){
//        return GoodsItem.builder()
//                .itemName(itemName)
//                .originalPrice(originalPrice)
//                .salePrice(salePrice)
//                .maximumBuyForPerson(maximumBuyForPerson)
//                .adultOnly(adultOnly)
//                .taxType(taxType)
//                .modelNo(modelNo)
//                .build();
//    }
}
