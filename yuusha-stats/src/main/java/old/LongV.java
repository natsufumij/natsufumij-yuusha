package old;

public class LongV {
    private Long value;
    public static LongV of(Long v){
        return new LongV(v);
    }

    public LongV() {
    }

    public LongV(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }
}
