/*
 * Copyright 2022 Victor Malone.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package InnerWorkings;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;


/**
 * A shape that represents the link from one page to another. 
 * 
 * Code referenced from: 
 * 
 * @see <a href = https://stackoverflow.com/questions/12175086/draw-perpendicular-line-to-given-line-on-canvas-android>Source 1</a>
 * @see <a href = https://dzone.com/articles/how-find-point-coordinates>Source 2</a>
 * @author Victor Malone
 */
public class ConnectionTriangle extends Polygon {
    
    /**
     * origin = center of start NodeRectangle, destination = center of end NodeRectangle
     */
    Point origin, destination;
    
    /**
     * The distance in pixels between the origin and its nearby points.
     */
    private final int distance = 10;
    
    /**
     * Constructor that assigns the origin and destination points.
     * 
     * @param start middle point of origin
     * @param finish middle point of destination
     */
    public ConnectionTriangle(Point start, Point finish)
    {
        super();
        this.origin = start.getLocation();
        this.destination = finish.getLocation();
        
        this.npoints = 3;
        
        setPoints();
    }
    
    /**
     * Updates the location of the origin and destination. <p>
     * Used when their NodeRectangles are dragged to new locations.
     * 
     * @param start middle point of origin
     * @param finish middle point of destination
     */
    public void update(Point start, Point finish)
    {
        origin = start;
        destination = finish;
    }
    
    /**
     * Calculates the points of the polygon.<p>
     * It is a triangle whose base rotates so it is always perpendicular to the line formed between the origin and destination.
     */
    private void setPoints()
    {        
        int pVX, pVY;
        pVX = -(destination.y - origin.y);
        pVY = destination.x - origin.x;
        
        // the three points of the triangle between the two nodes
        Point p1 = new Point(origin.x + pVX, origin.y + pVY);
        Point p2 = destination.getLocation();
        Point p3 = new Point(origin.x - pVX, origin.y - pVY);
       
        // shorten the perpendicular lines to a fixed length
        p1 = calculateNewPoint(p1);
        p3 = calculateNewPoint(p3);
        
        // assign points
        xpoints = new int[] {p1.x, p2.x, p3.x};
        ypoints = new int[] {p1.y, p2.y, p3.y};
    }
    
    /**
     * Shortens the base of the triangle to the length specified by the distance variable.
     * 
     * @param p1 the point to be moved
     * @return The new location of the point.
     */
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
    }
}
