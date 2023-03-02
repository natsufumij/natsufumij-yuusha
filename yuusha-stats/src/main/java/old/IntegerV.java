package old;

public class IntegerV {
    private Integer value;

    public static IntegerV of(Integer v){
        return new IntegerV(v);
    }

    public IntegerV(Integer value) {
        this.value = value;
    }

    public IntegerV() {
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
