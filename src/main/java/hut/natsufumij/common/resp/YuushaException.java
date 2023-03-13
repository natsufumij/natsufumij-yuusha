package hut.natsufumij.common.resp;

import lombok.Getter;

@Getter
public class YuushaException extends RuntimeException{
    private final int hCode;
    private final int code;
    private final String msg;

    public YuushaException(int hCode, int code, String msg) {
        super(msg);
        this.hCode = hCode;
        this.code = code;
        this.msg = msg;
    }
}
