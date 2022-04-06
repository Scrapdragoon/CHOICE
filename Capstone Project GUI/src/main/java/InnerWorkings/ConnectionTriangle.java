/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InnerWorkings;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.Line2D;


/**
 *
 * @author Victor Malone (vm19171)
 * Code referenced from https://stackoverflow.com/questions/12175086/draw-perpendicular-line-to-given-line-on-canvas-android
 * and https://dzone.com/articles/how-find-point-coordinates
 */
public class ConnectionTriangle extends Polygon {
    
    Point origin, destination;
    
    // the distance in pixels between origin and its nearby points
    int distance = 15;
    
    
    public ConnectionTriangle(Point start, Point finish)
    {
        super();
        this.origin = start.getLocation();
        this.destination = finish.getLocation();
        
        this.npoints = 3;
        
        setPoints();
        
    }
    
    public void update(Point start, Point finish)
    {
        origin = start;
        destination = finish;
    }
    
    // calculates the points of the polygon.
    private void setPoints()
    {
        int vectorX, vectorY;
        vectorX = destination.x - origin.x;
        vectorY = destination.y - origin.y;
        
        int pVX, pVY;
        pVX = -(destination.y - origin.y);
        pVY = destination.x - origin.x;
        
        // the three points of the triangle between the two nodes
        Point p1 = new Point(origin.x + pVX, origin.y + pVY);
        Point p2 = destination.getLocation();
        Point p3 = new Point(origin.x - pVX, origin.y - pVY);
       
        
        p1 = calculateNewPoint(p1);
        p3 = calculateNewPoint(p3);
        
       
        
        xpoints = new int[] {p1.x, p2.x, p3.x};
        ypoints = new int[] {p1.y, p2.y, p3.y};
    }
    
    // to shorten the length of the perpendicular lines.
    private Point calculateNewPoint(Point p1)
    {
        // distance from p1 to origin
        double p1OriginDist = Math.sqrt(Math.pow(p1.x - origin.x, 2) + Math.pow(p1.y - origin.y, 2));
        
        // calculate new points along perpendicular line, at a fixed distance
        int newP1X, newP1Y;
        double d;
        d = distance/p1OriginDist;
        newP1X = (int)((1 - d) * origin.x + d * p1.x);
        newP1Y = (int)((1 - d) * origin.y + d * p1.y);
        
        return new Point(newP1X, newP1Y);
    }
    
    
    public void paintComponent(Graphics2D g)
    {
        setPoints();
        g.setColor(Color.CYAN);
        g.fillPolygon(this);
    }
}
