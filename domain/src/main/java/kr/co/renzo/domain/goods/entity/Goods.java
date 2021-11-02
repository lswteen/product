package kr.co.renzo.domain.goods.entity;

import lombok.*;

import javax.persistence.*;

/**
 * CREATE TABLE `goods` (
 *   `goods_no` int(11) NOT NULL DEFAULT '0' COMMENT '상품번호',
 *   `goods_nm` varchar(100) DEFAULT NULL COMMENT '상품명',
 *   `goods_cont` text COMMENT '상품설명',
 *   `com_id` varchar(20) DEFAULT NULL COMMENT '업체 아이디',
 *   `reg_dm` datetime DEFAULT NULL COMMENT '상품정보 최초등록일시',
 *   `upd_dm` datetime DEFAULT NULL COMMENT '상품정보 수정일시',
 *   PRIMARY KEY (`goods_no`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='상품마스터'
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
    @Comment("상품번호")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long goodsNo;

    @Comment("상품명")
    @Column(name="goods_nm")
    private String goodsNm;

    @Comment("상품설명")
    @Column(name="goods_cont")
    private String goodsCont;

    @Comment("업체 아이디")
    @Column(name="com_id")
    private String comId;


}
