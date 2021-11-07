package kr.co.renzo.domain.goods.repository;

import kr.co.renzo.domain.goods.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long> {
    Optional<Goods> findByGoodsId(Long goodsId);

    List<Goods> findAllByGoodsIdIn(List<Long> goodsIds);

    List<Goods> getAllByVendorIdIn(List<String> vendorIds);

}
