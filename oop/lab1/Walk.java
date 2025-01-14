package laba_1_ver2;

public class Walk implements MovementStrategy {
    @Override
    public void move(double distance) {
        System.out.println("Герой идет пешком " + distance + " км.");
    }
}
