package kr.co.renzo.domain.goods.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Goods, Product
 * 저는 둘다 상품에 해당한다고 생각하며
 * 해당 서비스 플랫폼에서 사용중인 것으로 맞춰서 하면된다고 생각합니다.
 *
 * 되도록이면 full name 으로 하는것을 선호하는 편입니다.
 * 시간과 여러가지 이유로 리펙토링이 필요하고
 * 코드리뷰와 여러부분 피드백 요청으로 수정이 되어야합니다.
 *
 * 상품 구성 테이블
 * 확장성 차원에서 고려하였으며 쿠팡API 참고 하였습니다.
 * 실제로 네이버 상품등록, 쿠팡상품은 대략적으로 어떻게 구성되어있는지 인지되어있는상태입니다.
 * 티몬에서 상품 대량등록 엑셀파일기능 구현이 필요하여 네이버와 쿠팡은 분석도하고 직접 토이 프로젝트로 구현 진행 하였습니다.
 *
 * 상품(goods)
 * 상품옵션(goodsItem) 상품 one to 상품옵션 many
 * 상품이미지(goodsItemImage) 상푸옵션 one to 상품이미지 many
 * 상품정보
 * 카테고리
 * 배송방법
 * 상품재고
 *
 * 무신사 상품상세 에 노출되는것정
 * 구매후기,스타일후기,상품사진후기,일반후기
 * 좋아요수, 누적판매, 상품 조회수 등등등...
 *
 */
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="goods")
public class Goods extends BaseEntity{

    @Id
    @Column(name="goods_no")
    @Comment("상품 ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long goodsId;

    @JsonIgnore
    @OneToMany(mappedBy = "goods", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Builder.Default
    private List<GoodsItem> goodsItemList= new ArrayList<>();

    @Comment("등록 상품 상태")
    @Column(name="status_name")
    private String statusName;

    @Comment("노출 카테고리 코드")
    @Column(name="display_category_id")
    private Long displayCategoryId;

    @Comment("발주서에 사용되는 등록상품명")
    @Column(name="seller_goods_name", length = 200)
    private String sellerGoodsName;

    @Lob
    @Comment("상품설명")
    @Column(name="goods_cont")
    private String goodsDetails;

    @Comment("업체 아이디")
    @Column(name="com_id")
    private Long vendorId;

    @Comment("판매시작일시")
    @Column(name="sale_started_at", length = 20)
    private String saleStartedAt;

    @Comment("판매종료일시")
    @Column(name="sale_ended_at", length = 20)
    private String saleEndedAt;

    @Comment("상품 서비스에 노출될 상품명이며 브랜드, 제품명, 상품군 변경의해 자동변경될수 있습니다.")
    @Column(name="display_goods_name")
    private String displayGoodsName;

    @Comment("브랜드명은 한글/영문 표준이름")
    @Column(name="brand")
    private String brand;

    @Comment("배송방법 : SEQUENCIAL 일반(순차)배송, COLD_FRESH 신선냉동, MAKE_ORDER 주문제작, AGENT_BUY 구매대행, VENDOR_DIRECT 설치배송 또는 판매자 직접전달")
    @Column(name="delivery_method")
    private String deliveryMethod;

    @Comment("배송비종류: FREE 무료배송, NOT_FREE : 유료배송, CHARGE_RECEIVED: 착불배송, CONDITIONAL_FREE: 조건부 무료배송")
    @Column(name="delivery_company_code")
    private String deliveryCompanyCode;

    @Comment("기본배송비 : 유료배송 또는 조건부 무료배송시 편도 배송비 금액 입력")
    @Column(name="delivery_charge")
    private int deliveryCharge;

    @Comment("반품지 센터 ID")
    @Column(name="return_center_id")
    private Long returnCenterId;


}
