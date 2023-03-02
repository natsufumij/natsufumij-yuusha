package old;

public class RVException extends RuntimeException {

    private final int code;
    private final String msg;

    public RVException(String message, int code) {
        super(message);
        this.msg = message;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
