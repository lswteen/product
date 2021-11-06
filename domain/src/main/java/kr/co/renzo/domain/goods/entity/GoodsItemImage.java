package kr.co.renzo.domain.goods.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="goods_item_image")
public class GoodsItemImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Comment("이미지 표시순서")
    @Column(name="item_order")
    private int imageOrder;

    @Comment("이미지 타입, 필수 REPRESENTATION : 정사각형 대표이미지, DETAIL : 기타이미지 (최대 9개까지 등록 가능), USED_PRODUCT : 중고상태 이미지 (최대 4개까지 등록 가능)")
    @Column(name="item_type")
    private int imageType;

    @Comment("cdn 이미지 경로")
    @Column(name="cdn_path")
    private String cdnPath;

    @Comment("업체 이미지 경로")
    @Column(name="vendor_path")
    private String vendorPath;
}
