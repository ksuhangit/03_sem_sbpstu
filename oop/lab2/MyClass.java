package laba2;

public class MyClass {

    @Repeat(value = 2)
    protected void protectedMethod1(String message) {
        System.out.println("Protected Method 1: " + message);
    }

    @Repeat(value = 3)
    private void privateMethod1(int number) {
        System.out.println("Private Method 1, number: " + number);
    }

    @Repeat(value = 1)
    protected void protectedMethod2(String message) {
        System.out.println("Protected Method 2: " + message);
    }

    
    @Repeat(value = 2)
    public void publicMethod(String message) {
        System.out.println("Public Method 1: " + message);
    }
     @Repeat(value = 2)
    protected void protectedMethod3(float value) {
        System.out.println("Protected Method 3, float: " + value);
    }

    @Repeat(value = 3)
    private void privateMethod2(byte value) {
        System.out.println("Private Method 2, byte: " + value);
    }

    @Repeat(value = 1)
    protected void protectedMethod4(short value) {
        System.out.println("Protected Method 4, short: " + value);
    }
}
