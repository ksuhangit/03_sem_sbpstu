package laba_1_ver2;

public class Hero {
    private MovementStrategy movementStrategy;

    public void setMovementStrategy(MovementStrategy movementStrategy) {
        this.movementStrategy = movementStrategy;
    }

    public void move(double distance) {
        if (distance == 0) {
            System.out.println("Герой стоит на месте.");
        } else {
            movementStrategy.move(distance);
        }
    }
}
