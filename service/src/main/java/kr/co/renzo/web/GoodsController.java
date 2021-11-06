package kr.co.renzo.web;

import io.swagger.annotations.Api;
import kr.co.renzo.web.Service.GoodsAppService;
import kr.co.renzo.web.response.GoodsConstants;
import kr.co.renzo.web.response.GoodsResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/api/")
@RestController
@Api(tags = "상품")
@RequiredArgsConstructor
public class GoodsController {
    private final GoodsAppService goodsAppService;

    @GetMapping("/test")
    public String getTest(){
        return "goods api server";
    }

    @GetMapping("/goods")
    public List<GoodsResponse> getGoodsByNo(@RequestParam(required=true) List<Long> goodsNos){
        return goodsAppService.getAllByGoodsNo(goodsNos);
    }

    @PostMapping("/goods")
    public ResponseEntity<Void> save(){
        return GoodsConstants.CREATED;
    }



}
