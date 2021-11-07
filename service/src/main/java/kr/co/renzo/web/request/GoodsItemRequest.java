package kr.co.renzo.web.request;

import kr.co.renzo.domain.goods.entity.GoodsItem;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoodsItemRequest {
    private long sellerGoodsItemId;
    private String itemName;                //업체 상품 옵션명
    private int originalPrice;              //할인율 기준가 정가
    private int salePrice;                  //판매가격
    private int maximumBuyForPerson;        //인당 최대 구매 수량
    private String adultOnly;               //19세 이상 ADULT_ONLY ,EVERYONE
    private String taxType;                 //TAX, FREE
    private String modelNo;                 //모델 번호

    @Builder
    public GoodsItemRequest(String itemName, int originalPrice, int salePrice, int maximumBuyForPerson, String adultOnly, String taxType, String modelNo) {
        this.itemName = itemName;
        this.originalPrice = originalPrice;
        this.salePrice = salePrice;
        this.maximumBuyForPerson = maximumBuyForPerson;
        this.adultOnly = adultOnly;
        this.taxType = taxType;
        this.modelNo = modelNo;
    }

    public GoodsItem toEntity(){
        return GoodsItem.builder()
                .sellerGoodsItemId(sellerGoodsItemId)
                .itemName(itemName)
                .originalPrice(originalPrice)
                .salePrice(salePrice)
                .maximumBuyForPerson(maximumBuyForPerson)
                .adultOnly(adultOnly)
                .taxType(taxType)
                .modelNo(modelNo)
                .build();
    }
}
