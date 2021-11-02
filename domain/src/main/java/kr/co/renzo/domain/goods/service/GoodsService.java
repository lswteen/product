package kr.co.renzo.domain.goods.service;

import kr.co.renzo.core.exception.ApiException;
import kr.co.renzo.core.type.ServiceErrorType;
import kr.co.renzo.domain.goods.entity.Goods;
import kr.co.renzo.domain.goods.repository.GoodsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GoodsService {
    private final GoodsRepository goodsRepository;

    public Goods getByGoodsNo(Long goodsNo){
        return goodsRepository.findByGoodsNo(goodsNo)
                .orElseThrow(()-> new ApiException(ServiceErrorType.NOT_FOUND));
    }

    public List<Goods> getAllByGoodsNo(Iterable<Long> goodsNos){
        return goodsRepository.findAllByGoodsNo(goodsNos);
    }

    public List<Goods> getAllByComId(Iterable<String> comIds){
        return goodsRepository.getAllByComId(comIds);
    }

    @Transactional(rollbackOn = RuntimeException.class)
    public Goods save(Goods goods){
        return goodsRepository.save(goods);
    }
}
