class IntValue{
    private int intValue;

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }
}

public class ComplexSwitch {
    public static void main(String[] args) {
        IntValue intValue = new IntValue();
        intValue.setIntValue(2);

        switch(intValue.getIntValue()){
            case 1 -> System.out.println(intValue.getIntValue());
            default -> switchSet1(intValue.getIntValue());
        }

        
    }
    private static int switchSet1(int a){
        switch(a){
            case 2 -> System.out.println(a);
            default -> System.out.println("Exception");
        }
        return 3;
    }
}
