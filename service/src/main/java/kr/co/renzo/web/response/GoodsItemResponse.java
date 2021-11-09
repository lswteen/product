package kr.co.renzo.web.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GoodsItemResponse {
    private Long sellerGoodsItemId;
    private String itemName;
    private int originalPrice;
    private int salePrice;
    private int maximumBuyForPerson;
    private String adultOnly;
    private String taxType;
    private String modelNo;

}
