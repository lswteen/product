package kr.co.renzo.domain.goods.repository;

import kr.co.renzo.domain.goods.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



import java.util.List;
import java.util.Optional;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long> {
    Optional<Goods> findByGoodsNo(Long goodsNo);

    List<Goods> findAllByGoodsNoIn(List<Long> goodsNos);

    List<Goods> getAllByComIdIn(List<String> comIds);

}
