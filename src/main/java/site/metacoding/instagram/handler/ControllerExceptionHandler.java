package site.metacoding.instagram.handler;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import site.metacoding.instagram.handler.ex.CustomApiException;
import site.metacoding.instagram.handler.ex.CustomValidationApiException;
import site.metacoding.instagram.handler.ex.CustomValidationException;
import site.metacoding.instagram.util.Script;
import site.metacoding.instagram.web.dto.auth.CMRespDto;

@RestController
@ControllerAdvice
public class ControllerExceptionHandler {

    // 모든 runtimeException가로챔
    @ExceptionHandler(CustomValidationException.class)
    public String validationException(CustomValidationException e) {

        // CMRespDto, Script 비교
        // 1. 클라이언트에게 응답 할때는 script좋음. (클라이언트가 응답 받음)
        // 2. Ajax통신 - CMRespDto (개발자가 응답받음 - 코드로 받아서 처리)
        // 3. Android 통신 - CMRespDto (개발자가 응답받음)
        return Script.back(e.getErrorMap().toString());
    }

    @ExceptionHandler(CustomValidationApiException.class)
    public ResponseEntity<?> validationApiException(CustomValidationApiException e) {
        return new ResponseEntity<>(new CMRespDto<>(-1, e.getMessage(), e.getErrorMap()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomApiException.class)
    public ResponseEntity<?> apiException(CustomApiException e) {
        return new ResponseEntity<>(new CMRespDto<>(-1, e.getMessage(), null), HttpStatus.BAD_REQUEST);
    }
}
