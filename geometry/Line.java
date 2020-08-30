package geometry;

import java.util.ArrayList;

public class Line {
   private Point p1;
   private Point p2;

   public Line (Point point1, Point point2) {
       p1 = point1;
       p2 = point2;
   }

   public Point getFirstPoint() {
       return p1;
   }
   public Point getSecondPoint() {
       return p2;
   }

   void setFirstPoint(Point firstPoint) {
       p1 = firstPoint;
   }
   void setSecondPoint(Point secondPoint) {
       p2 = secondPoint;
   }

   public double getlengthOfLine () {
        double length = p1.getDistance(p2);
        return length;
   }

   static double totalLength(ArrayList<Line> lines) {
        double sum = 0;
        for (Line line : lines) {
            sum += line.getlengthOfLine();
        }
        return sum;
   }
}