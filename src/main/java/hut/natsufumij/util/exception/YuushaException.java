package hut.natsufumij.util.exception;

import lombok.Getter;

@Getter
public class YuushaException extends RuntimeException{
    private final Integer code;
    private final String msg;
    public YuushaException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}
