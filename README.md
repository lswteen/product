# With Springboot framework Product


CREATE TABLE `goods` (
`goods_no` int(11) NOT NULL DEFAULT '0' COMMENT '상품번호',
`goods_nm` varchar(100) DEFAULT NULL COMMENT '상품명',
`goods_cont` text COMMENT '상품설명',
`com_id` varchar(20) DEFAULT NULL COMMENT '업체 아이디',
`reg_dm` datetime DEFAULT NULL COMMENT '상품정보 최초등록일시',
`upd_dm` datetime DEFAULT NULL COMMENT '상품정보 수정일시',
PRIMARY KEY (`goods_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='상품마스터'

1.상품 등록 / 조회
2.셈플 스키마를 참고하여 스키마를 완성
3.Spring Boot 기반으로 REST API를 개발
4.버저닝에 대한 고려
5.비정상적인 API 호출의 에러처리에 대해 고려
(throttling)
6.상품 API가 저장되는 저장소 혹은 방식은 추후 변경이 될 수 있다는 가정
