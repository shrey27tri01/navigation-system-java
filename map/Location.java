package map;

import geometry.Point;

public class Location {
    private Point pointOfLocation;
    private String locationName;

    public Location(Point p, String name) {
        pointOfLocation = p;
        locationName = name;
    }

    public String getName() {
        return locationName;
    }

    public Point getPoint() {
        return pointOfLocation;
    }

    // public static String getLocationNameByPoint(Point p) {
    //     if (p == pointOfLocation) {
    //         return locationName;
    //     }
    //     return null;
    // }
}