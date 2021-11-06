package kr.co.renzo.web.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import kr.co.renzo.domain.goods.entity.Goods;
import kr.co.renzo.domain.goods.entity.GoodsItem;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class GoodsResponse {
    private Long goodsId;

    private List<GoodsItem> goodsItemList;

    private String statusName;

    private Long displayCategoryId;

    private String sellerGoodsName;

    private String goodsDetails;

    private Long vendorId;

    private String saleStartedAt;

    private String saleEndedAt;

    private String displayGoodsName;

    private String brand;

    private String deliveryMethod;

    private String deliveryCompanyCode;

    private int deliveryCharge;

    private Long returnCenterId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate regDm;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate modDm;

}
