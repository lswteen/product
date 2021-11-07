package kr.co.renzo.domain.goods.repository;

import kr.co.renzo.domain.goods.entity.GoodsItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsItemRepository extends JpaRepository<GoodsItem, Long> {
    List<GoodsItem> findAllByGoodsId(Long goodsId);
}
