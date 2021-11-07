package kr.co.renzo.web.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import kr.co.renzo.domain.goods.entity.Goods;
import kr.co.renzo.domain.goods.entity.GoodsItem;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;


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

    @Builder
    public GoodsResponse(Long goodsId, List<GoodsItem> goodsItemList, String statusName
            , Long displayCategoryId, String sellerGoodsName, String goodsDetails
            , Long vendorId, String saleStartedAt, String saleEndedAt
            , String displayGoodsName, String brand, String deliveryMethod
            , String deliveryCompanyCode, int deliveryCharge, Long returnCenterId
            , LocalDate regDm, LocalDate modDm) {
        this.goodsId = goodsId;
        this.goodsItemList = goodsItemList;
        this.statusName = statusName;
        this.displayCategoryId = displayCategoryId;
        this.sellerGoodsName = sellerGoodsName;
        this.goodsDetails = goodsDetails;
        this.vendorId = vendorId;
        this.saleStartedAt = saleStartedAt;
        this.saleEndedAt = saleEndedAt;
        this.displayGoodsName = displayGoodsName;
        this.brand = brand;
        this.deliveryMethod = deliveryMethod;
        this.deliveryCompanyCode = deliveryCompanyCode;
        this.deliveryCharge = deliveryCharge;
        this.returnCenterId = returnCenterId;
        this.regDm = regDm;
        this.modDm = modDm;
    }

    public GoodsResponse() {
    }

    public GoodsResponse toObject(Goods goods){
        return GoodsResponse.builder()
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
                .build();
    }

}
