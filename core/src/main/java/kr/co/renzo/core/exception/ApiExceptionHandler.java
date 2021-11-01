package kr.co.renzo.core.exception;

import kr.co.renzo.core.response.ApiErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


@Slf4j
@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiErrorResponse> handleApiExceptions(ApiException ex) {
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
        apiErrorResponse.setErrorMessage(ex.getServiceErrorType().getMessage());
        apiErrorResponse.setErrorCode(ex.getServiceErrorType().getCode());

        return new ResponseEntity<>(apiErrorResponse, ex.getServiceErrorType().getHttpStatus());
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult().getAllErrors().stream().findFirst()
                .orElse(new ObjectError("validationParam", ex.getMessage()))
                .getDefaultMessage();

        ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
        apiErrorResponse.setErrorMessage(message);

        return new ResponseEntity<>(apiErrorResponse, HttpStatus.CONFLICT);
    }
}
