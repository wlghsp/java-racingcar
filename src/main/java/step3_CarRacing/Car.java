package step3_CarRacing;

public class Car {
    private int distance = 1;
    public void move(int randomValue) {
        if (randomValue >= 4) distance++;
    }
    public int getDistance() {
        return distance;
    }
}
