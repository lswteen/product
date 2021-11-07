package kr.co.renzo.core.type;

import org.springframework.http.HttpStatus;

public enum ServiceErrorType {
    CREATED(HttpStatus.CREATED, 1, "등록 되었습니다."),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, 1, "비 인가 사용자입니다."),
    FORBIDDEN(HttpStatus.FORBIDDEN, 1, "권한이 없습니다."),
    NOT_FOUND(HttpStatus.NOT_FOUND, 1, "해당 리소스를 찾을 수 없습니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 1, "시스템에 문제가 발생하였습니다."),
    INVALID_PARAMETER(HttpStatus.CONFLICT, 1, "유효하지 않은 전달값입니다."),

    GOODS_FAILES(HttpStatus.NOT_FOUND,1,"상품등록이 정상적이지 않습니다.")
    ;

    HttpStatus httpStatus;
    int code;
    String message;

    ServiceErrorType(HttpStatus httpStatus, int code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }
    public String getMessage() {
        return this.message;
    }
    public Integer getCode() {
        return code;
    }
}
