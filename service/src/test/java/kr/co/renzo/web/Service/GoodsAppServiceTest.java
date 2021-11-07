package kr.co.renzo.web.Service;

import kr.co.renzo.domain.goods.entity.GoodsItem;
import kr.co.renzo.domain.goods.repository.GoodsRepository;
import kr.co.renzo.domain.goods.service.GoodsService;
import kr.co.renzo.web.request.GoodsItemRequest;
import kr.co.renzo.web.request.GoodsRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class GoodsAppServiceTest {

//    @Mock
//    GoodsRepository goodsRepository;
//
//    @InjectMocks
//    GoodsService goodsService;
//
//    @InjectMocks
//    GoodsAppService goodsAppService;

    @Test
    public void 테스트(){
        System.out.println("test");
    }

//    @Test
//    public void singleCreateItem(){
//        List<GoodsItem> goodsItemList = new ArrayList<>();
//        GoodsItemRequest goodsItemRequest= GoodsItemRequest.builder()
//                .itemName("가디건")
//                .originalPrice(795000)
//                .salePrice(495000)
//                .maximumBuyForPerson(10)
//                .adultOnly("EVERYONE")
//                .taxType("TAX")
//                .modelNo("A21HK303016100")
//                .build();
//        goodsItemList.add(goodsItemRequest.toEntity());
//
//        List<GoodsRequest> goodsRequestList = new ArrayList<>();
//        GoodsRequest goodsRequest = GoodsRequest.builder()
//                .vendorId(1000l)
//                .sellerGoodsName("AMI 화이트 빅하트 로그 가디건")
//                .displayGoodsName("남성 21FW 체인스티치 빅하트 로고 가디건 - 화이트")
//                .brand("AMI")
//                .deliveryMethod("SEQUENCIAL")
//                .deliveryCompanyCode("FREE")
//                .deliveryCharge(2500)
//                .returnCenterId(1000l)
//                .goodsDetails("아미 화이트 빅하트 로그 가디건 상품 상세 정보 입니다.")
//                .saleStartedAt("2021-11-11 23:00:00")
//                .saleEndedAt("2022-11-11 23:00:00")
//                .goodsItemList(goodsItemList)
//                .build();
//        goodsRequestList.add(goodsRequest);
//        goodsAppService.createGoods(goodsRequestList);
//    }
}