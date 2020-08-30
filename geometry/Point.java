package geometry;

import java.lang.Math;

public class Point {
    private double x;
    private double y;

    public Point (double xCoordinate, double yCoordinate) {
        x = xCoordinate;
        y = yCoordinate;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    void setX(double newX) {
        x = newX;
    }
    void setY(double newY) {
        y = newY;
    }

    public double getDistance (Point p) {
        double distance = Math.sqrt(Math.pow(x - p.getX(), 2) + Math.pow(y - p.getY(), 2));
        return distance;
    }
}
