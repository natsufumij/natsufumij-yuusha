package hut.natsufumij.yuusha.util.advice;

import hut.natsufumij.yuusha.util.exception.YuushaException;
import hut.natsufumij.yuusha.util.resp.RV;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class GlobalAdvice {

    @ExceptionHandler(YuushaException.class)
    public ResponseEntity<RV<Boolean>> exceptionHandler(YuushaException ex) {
        log.error("发生业务异常: " + ex.getMessage());
        HttpStatus status = HttpStatus.valueOf(ex.getCode());
        return new ResponseEntity<>(RV.buildError(status.value(), ex.getMessage()), status);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RV<Boolean>> exceptionHandler(Exception ex) {
        log.error("程序发生未知异常: " + ex.getMessage());
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(RV.buildError(status.value(), "未知异常"), status);
    }

    /**
     * 方法参数校验
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RV<Void>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<ObjectError> list = e.getAllErrors();
        StringBuilder builder = new StringBuilder();
        list.forEach(a -> {
            Object[] args = a.getArguments();
            DefaultMessageSourceResolvable r = (DefaultMessageSourceResolvable)args[0];
            builder.append("["+r.getDefaultMessage()+"]"+a.getDefaultMessage()+",");
        });
        return new ResponseEntity<>(
                RV.buildError(705, builder.toString()), HttpStatus.BAD_REQUEST);
    }

    /**
     * ValidationException
     */
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<RV<Void>> handleValidationException(ValidationException e) {
        return new ResponseEntity<>(RV.buildError(705, e.getCause().getMessage()), HttpStatus.BAD_REQUEST);
    }

    /**
     * ConstraintViolationException
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public RV<Void> handleConstraintViolationException(ConstraintViolationException e) {
        return RV.buildError(706, e.getCause().getMessage());
    }
}
