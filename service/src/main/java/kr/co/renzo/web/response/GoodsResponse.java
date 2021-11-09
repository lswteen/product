package kr.co.renzo.web.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import kr.co.renzo.domain.goods.entity.Goods;
import kr.co.renzo.domain.goods.entity.GoodsItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GoodsResponse {
    private Long goodsId;

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

    private List<GoodsItem> goodsItems;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate regDm;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate modDm;



}
