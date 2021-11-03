package kr.co.renzo.web.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class GoodsResponse {
    private Long goodsNo;

    private String goodsNm;

    private String goodsCont;

    private String comId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate regDm;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate modDm;
}
