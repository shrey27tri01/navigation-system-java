import java.util.Scanner;
import java.util.ArrayList;
import java.text.DecimalFormat;

import geometry.Point;
import geometry.Line;

import map.Location;
import map.Road;
import map.Route;

public class Test {

    private static DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int numberOfLocations = s.nextInt();
        ArrayList<Location> locations= new ArrayList<Location>();
        for (int i = 0; i < numberOfLocations; i++) {
            double startingPoint = s.nextInt();
            double endPoint = s.nextInt();
            String locationName = s.next();

            Point locationPoint = new Point(startingPoint, endPoint);
            Location newLocation = new Location (locationPoint, locationName);
            locations.add(newLocation);
        }
        // System.out.println(locations);

        int numberOfRoads = s.nextInt();
        ArrayList<Road> roads = new ArrayList<Road>();
        ArrayList<Location> startLocations = new ArrayList<Location>();
        ArrayList<Location> endLocations = new ArrayList<Location>();
        for (int j = 0; j < numberOfRoads; j++) {
            int roadStartIndex = s.nextInt();
            int roadEndIndex = s.nextInt();
            String roadName = s.next();
            float widthOfRoad = s.nextInt();

            Location startLocation = locations.get(roadStartIndex);
            startLocations.add(startLocation);
            Location endLocation = locations.get(roadEndIndex);
            endLocations.add(endLocation);
            Line lineOfRoad = new Line (startLocation.getPoint(), endLocation.getPoint());

            Road road = new Road (lineOfRoad, roadName, widthOfRoad);
            roads.add(road);

            // System.out.println("From " + startLocation.getName() + " to " + endLocation.getName());
        }
        // System.out.println(roads);
        // System.out.println(startLocations);
        // System.out.println(endLocations);

        int numberOfRoutes = s.nextInt();

        int routeNumber = 1;

        for (int k = 0; k < numberOfRoutes; k++) {
            ArrayList<Road> roadsInRoute = new ArrayList<Road>();
            ArrayList<Integer> indicesOfRoadsInRoute = new ArrayList<Integer>();

            int numberOfRoadsInRoute = s.nextInt();

            for (int x = 0; x < numberOfRoadsInRoute; x++) {
                int roadIndex = s.nextInt();
                indicesOfRoadsInRoute.add(roadIndex);
                roadsInRoute.add(roads.get(roadIndex));
            }

            // System.out.println(indicesOfRoadsInRoute);

            // for (Integer i : indicesOfRoadsInRoute) {
            //     System.out.println("At index: " + i + " is road " + roads.get(i).getName());
            // }
            Route route = new Route (roadsInRoute);
            System.out.println("");

            System.out.println("Route " + routeNumber + ": ");
            routeNumber += 1;

            if (Route.isConnected(roadsInRoute) == true) {
                double lengthOfRoute = route.getLengthOfRoute();
                System.out.println("  Length of the route is " + df.format(lengthOfRoute));

                double carWidth = route.getMaxWidth();
                System.out.println("  Maximum width of car on this route is " + df.format(carWidth)); 

                System.out.println("  Start at " + startLocations.get(roads.indexOf(roadsInRoute.get(0))).getName());
                // System.out.println("Follow road " + roads.get(indicesOfRoadsInRoute.get(0)).getName());

                for (int i = 1 ; i < indicesOfRoadsInRoute.size() + 1; i++) {
                    System.out.println("  Follow " + roads.get(indicesOfRoadsInRoute.get(i - 1)).getName() + " to " + endLocations.get(roads.indexOf(roadsInRoute.get(i - 1))).getName() );
                }         
            } else {
                System.out.println("  Invalid route");
            }
            
        }

        s.close();
    }
}
