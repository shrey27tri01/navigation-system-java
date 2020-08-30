package map;

import geometry.Line;

public class Road {
    private Line lineOfRoad;
    private String roadName;
    private double width;

    public Road (Line l, String name, double w) {
        lineOfRoad = l;
        roadName = name;
        width = w;
    }

    public double getLengthOfRoad() {
        return lineOfRoad.getlengthOfLine();
    }

    public double getWidth() {
        return width;
    }

    public String getName() {
        return roadName;
    }

    public Line getLine() {
        return lineOfRoad;
    }

}