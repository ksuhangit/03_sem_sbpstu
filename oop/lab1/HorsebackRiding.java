package laba_1_ver2;

public class HorsebackRiding implements MovementStrategy {
    @Override
    public void move(double distance) {
        System.out.println("Герой скачет на лошади " + distance + " км.");
    }
}
