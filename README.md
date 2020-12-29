# navigation-system-java

A navigation system in Java, modelling roads, intersections, and routes. 

Intersections are basically locations where roads join, and routes are basically a series of roads that connect a start location to an end location.

The program consists of two pakages:
- The first package consists of the following:
    - **Class Point:** Defined by two double values – the x,y coordinates of the point. It provides methods to set and get the coordinate values, and get the distance to another point.
    - **Class Line:** Defined by two Point objects. It provides a method to return the length (double) of the Line object. It also has a static method that returns the total length of a list of Line objects.
- The second package consists of the following:
    - **Class Location:** Has a String name and an instance of Point that contains the coordinates.
    - **Class Road:** Builds on Line, is constructed with Locations as its end points, and also contains name (string), width (double). No vehicle wider than “width” can use this road.
    - **Class Route:** Modelled as a list of Roads. Assuming that the roads of a Route connect up end-to-end, it has a method that will return the length of the Route. The class also has a static method that checks if the roads form a connected path, where the end location of a road is the same as the start location of the next road in the list.

The main program reads in a set of Location, Road and Route data in a format specified below, and for each Route, prints out the series of Locations it connects, the Roads traversed and the total length and the max width of a vehicle traversing this route (in a format specified below). If the data for a route does not form a connected path, it prints out that the input data is invalid.

#### Input format:
```
Line 1: number_of_Locations (int) (say n1) 
Next n1 lines: x(int) y(int) name(string – single word)  
Next line: number_of_Roads (int) (say n2)  
Next n2 lines: index_of_start_location_in_list_of_Locations(int) index_of_end_location(int) name(string – single word) width(float)
Next line: number_of_Routes(int) (say n3)
Next n3 lines: Number_of_Roads(int) (say ni) {series of ni integers – indices of the roads of the route in list of Roads above}
```

#### Output format:
```
Route i: Length xxx, Max Width bbb: Directions_from_start_location_to_end_location
```

#### How to run the program:

- `javac Test.java`
- `java Test`

##### Sample input:
```
4
0 0 Home
1 0 Theatre
1 1 FoodyCircle
2 2 BlackHole
4
0 1 FirstAve 20
2 0 DiagonAlley 8
1 2 SecondCross 10
2 3 RoadToNowhere 5
3
3 0 2 3
2 1 0
3 0 3 2
```

##### Sample output:
```
Route 1: Length 3.41, max width 5.00: Start at Home. Follow FirstAve to Theatre. Follow SecondCross to FoodyCircle. Follow RoadToNowhere to BlackHole. 
Route 2: Length 2.41, max width 8.00: Start at FoodyCircle. Follow DiagonAlley to Home. Follow FirstAve to Theatre. 
Route 3: Invalid route
```
