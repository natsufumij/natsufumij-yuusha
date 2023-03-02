package old;

public class VoidV {

    public static final VoidV NONE = VoidV.of("");

    public static VoidV of(String v) {
        return new VoidV(v);
    }

    private String value = null;

    private VoidV(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
