package natsufumij.common.resp;

import hut.natsufumij.common.resp.V;
import hut.natsufumij.common.resp.YuushaException;
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
public class GlobalExceptionAdvice {

    @ExceptionHandler(YuushaException.class)
    public ResponseEntity<V<Void>> exceptionHandler(YuushaException ex) {
        log.error("发生业务异常: " + ex.getMsg());
        HttpStatus status = HttpStatus.valueOf(ex.getCode());
        return new ResponseEntity<>(V.buildError(status.value(), ex.getCode(), ex.getMsg()), status);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<V<Void>> exceptionHandler(Exception ex) {
        log.error("程序发生未知异常: " + ex.getMessage());
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(V.buildError(status.value(), 999, "未知异常"), status);
    }

    /**
     * 方法参数校验
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<V<Void>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<ObjectError> list = e.getAllErrors();
        StringBuilder builder = new StringBuilder();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        list.forEach(a -> {
            Object[] args = a.getArguments();
            DefaultMessageSourceResolvable r = (DefaultMessageSourceResolvable) args[0];
            builder.append("[").append(r.getDefaultMessage()).append("]").append(a.getDefaultMessage()).append(",");
        });
        return new ResponseEntity<>(
                V.buildError(status.value(), 705, builder.toString()), HttpStatus.BAD_REQUEST);
    }

    /**
     * ValidationException
     */
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<V<Void>> handleValidationException(ValidationException e) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(V.buildError(HttpStatus.BAD_REQUEST.value(), 705, e.getCause().getMessage()), HttpStatus.BAD_REQUEST);
    }

    /**
     * ConstraintViolationException
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public V<Void> handleConstraintViolationException(ConstraintViolationException e) {
        return V.buildError(HttpStatus.BAD_REQUEST.value(),705, e.getCause().getMessage());
    }
}
