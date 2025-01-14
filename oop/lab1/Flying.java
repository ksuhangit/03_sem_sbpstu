package laba_1_ver2;

public class Flying implements MovementStrategy {
    @Override
    public void move(double distance) {
        System.out.println("Герой летит " + distance + " км.");
    }
}
