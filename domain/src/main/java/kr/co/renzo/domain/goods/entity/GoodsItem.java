package kr.co.renzo.domain.goods.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="goods_item")
public class GoodsItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("옵션 ID")
    @Column(name="seller_goods_item_id")
    private Long sellerGoodsItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="goods_no", nullable = false)
    private Goods goods;

    @Comment("옵션 명")
    @Column(name="item_name")
    private String itemName;

    @Comment("할인율 기준가")
    @Column(name="original_price")
    private int originalPrice;

    @Comment("판매가격")
    @Column(name="sale_price")
    private int salePrice;

    @Comment("인당 최대 구매수량")
    @Column(name="maximum_buy_for_person")
    private int maximumBuyForPerson;

    @Comment("19세 이상 ADULT_ONLY, EVERYONE")
    @Column(name="adult_only")
    private String adultOnly;

    @Comment("과세여부 TAX, FREE")
    @Column(name="tax_type")
    private String taxType;

    @Comment("모델번호")
    @Column(name="model_no")
    private String modelNo;

//    @OneToMany
//    @JoinColumn(name="seller_goods_item_id")
//    private List<GoodsItemImage> goodsItemImageList;
}
