package exercism;

public class Darts {
    int score(double xOfDart, double yOfDart) {
        double radius = Math.hypot(xOfDart,yOfDart);
        return radius <= 1 ? 10
                : radius <= 5 ? 5
                : radius <= 10 ? 1
                : 0;
    }
}
