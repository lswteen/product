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

    public Goods getByGoodsNo(Long goodsId){
        return goodsRepository.findByGoodsId(goodsId)
                .orElseThrow(()-> new ApiException(ServiceErrorType.NOT_FOUND));
    }

    public List<Goods> getAllByGoodsId(List<Long> goodsIds){
        return goodsRepository.findAllByGoodsIdIn(goodsIds);
    }

    public List<Goods> getAllByVendorId(List<String> vendorIds){
        return goodsRepository.getAllByVendorIdIn(vendorIds);
    }

    @Transactional(rollbackOn = RuntimeException.class)
    public Goods save(Goods goods){
        return goodsRepository.save(goods);
    }
}
