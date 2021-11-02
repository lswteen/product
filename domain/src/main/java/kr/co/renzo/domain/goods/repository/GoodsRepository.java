package kr.co.renzo.domain.goods.repository;

import kr.co.renzo.domain.goods.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long> {
    Optional<Goods> findByGoodsNo(Long goodsNo);

    List<Goods> findAllByGoodsNo(Iterable<Long> goodsNos);

    @Query(value="SELECT g FROM Goods g WHERE g.comId IN :comIds")
    List<Goods> getAllByComId(Iterable<String> comIds);
}
