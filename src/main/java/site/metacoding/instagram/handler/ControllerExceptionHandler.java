package site.metacoding.instagram.handler;

import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import site.metacoding.instagram.handler.ex.CustomValidationException;
import site.metacoding.instagram.web.dto.auth.CMRespDto;

@RestController
@ControllerAdvice
public class ControllerExceptionHandler {

    // 모든 runtimeException가로챔
    @ExceptionHandler(CustomValidationException.class)
    public CMRespDto<?> validationException(CustomValidationException e) {
        return new CMRespDto<Map<String, String>>(-1, e.getMessage(), e.getErrorMap());
    }
}
