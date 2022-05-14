import java.util.Random;

public class TestDemo {
     int addPositive(int a, int b) {
        if ((a > 0) && (b > 0)) {
            return a + b;
        }
        throw new IllegalArgumentException("Both parameters must be positive!");
    }
     int randomNumberSquared(){
        return (int) Math.pow(getRandomInt(),2);
    }

    int getRandomInt() {
        Random random = new Random();
        return random.nextInt(10) + 1;
    }

}
