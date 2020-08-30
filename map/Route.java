package map;

import java.util.ArrayList;

public class Route {
    private ArrayList<Road> roads;

    public Route (ArrayList<Road> roadsInRoute) {
        roads = roadsInRoute;
    }

    public double getLengthOfRoute() {
        double length = 0;
        for (Road road : roads) {
            length += road.getLengthOfRoad();
        }
        return length;
    }

    public double getMaxWidth() {
        double maxWidth = Integer.MAX_VALUE;
        for (Road road : roads) {
            if (road.getWidth() < maxWidth) {
                maxWidth = road.getWidth();
            }
        }
        return maxWidth;
    }

    public static boolean isConnected(ArrayList<Road> listOfRoads) {

        for (int i = 0; i < listOfRoads.size() - 1; i++) {
            double roadLastPointXCoordinate = listOfRoads.get(i).getLine().getSecondPoint().getX();
            double roadLastPointYCoordinate = listOfRoads.get(i).getLine().getSecondPoint().getY();
            double nextRoadFirstPointXCoordinate = listOfRoads.get(i + 1).getLine().getFirstPoint().getX();
            double nextRoadFirstPointYCoordinate = listOfRoads.get(i + 1).getLine().getFirstPoint().getY();

            if (roadLastPointXCoordinate != nextRoadFirstPointXCoordinate || roadLastPointYCoordinate != nextRoadFirstPointYCoordinate) {
                return false;
            }
        }
        return true;
    }
    
}