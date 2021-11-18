package kr.co.renzo.web;

import kr.co.renzo.domain.goods.entity.Goods;
import kr.co.renzo.domain.goods.entity.GoodsItem;
import kr.co.renzo.domain.goods.repository.GoodsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
class GoodsControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private WebApplicationContext ctx;

    @BeforeEach
    void setUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx)
                .addFilter(new CharacterEncodingFilter("UTF-8",true))
                .alwaysDo(print())
                .build();

        List<GoodsItem> goodsItemList = new ArrayList<>();

        Goods goods = Goods.builder()
                .goodsItemList(goodsItemList)
                .statusName("A")
                .displayCategoryId(1L)
                .sellerGoodsName("AMI 화이트 빅하트 로그 가디건")
                .goodsDetails("아미 화이트 빅하트 로그 가디건 상품 상세 정보 입니다.")
                .vendorId(100L)
                .saleStartedAt("2021-11-11 23:00:00")
                .saleEndedAt("2022-11-11 23:00:00")
                .displayGoodsName("남성 21FW 체인스티치 빅하트 로고 가디건 - 화이트")
                .brand("AMI")
                .deliveryMethod("SEQUENCIAL")
                .deliveryCompanyCode("FREE")
                .deliveryCharge(2500)
                .returnCenterId(1000L)
                .build();

        goodsItemList.add(GoodsItem.builder()
                .itemName("블랙 가디건")
                .goods(goods)
                .originalPrice(695000)
                .salePrice(395000)
                .maximumBuyForPerson(10)
                .adultOnly("EVERYONE")
                .taxType("TAX")
                .modelNo("A21HK303016101")
                .build());

        goodsRepository.save(goods);
    }

    @Test
    void getAllByGood() throws Exception {
        mockMvc.perform(get("/api/v1/goods")
                        .param("goodsNos","1")
                )
                .andDo(print());
    }
}