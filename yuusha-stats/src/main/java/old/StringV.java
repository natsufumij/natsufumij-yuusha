package old;

public class StringV {
    private String value;
    public static StringV of(String v){
        return new StringV(v);
    }

    public StringV() {
    }

    public StringV(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
