package kr.co.renzo.domain.goods.service;

import kr.co.renzo.domain.goods.entity.GoodsItem;
import kr.co.renzo.domain.goods.repository.GoodsItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GoodsItemService {
    private final GoodsItemRepository goodsItemRepository;

    public List<GoodsItem> getAllByGoodsId(Long goodsId){
        return goodsItemRepository.findAllByGoodsId(goodsId);
    }

    @Transactional(rollbackOn = RuntimeException.class)
    public List<GoodsItem> saveAll(List<GoodsItem> goodsItems){
        return goodsItemRepository.saveAll(goodsItems);
    }
}
