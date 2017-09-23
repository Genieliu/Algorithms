import java.util.*;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class BruteCollinearPoints 
{
    private int size;
    private LineSegment[] ls;
    public BruteCollinearPoints(Point[] points)    // finds all line segments containing 4 points
    {
        if (points == null) throw new IllegalArgumentException();
        size = 0;
        ls = new LineSegment[points.length];
        Arrays.sort(points);
        for(int i = 0; i < points.length; i++)
            for(int j = i+1; j < points.length; j++)
                for(int k = j+1; k < points.length; k++)
                    for(int l = k+1; l < points.length; l++)
                    {
                        if(points[i]==null || points[j]==null || points[k]==null || points[l]==null) throw new IllegalArgumentException();
                        Comparator<Point> cp = points[i].slopeOrder();
                        if((cp.compare(points[j], points[k]) == 0) && (cp.compare(points[j], points[l]) == 0))
                        {
                            ls[size] = new LineSegment(points[i], points[l]);
                            // StdOut.println("size=" + size);
                            size++;
                        }
                    }
        LineSegment[] tmp = new LineSegment[size];
        for(int i = 0; i < size; i++)
        {
            tmp[i] = ls[i];
        }
        ls = tmp;
    }
    public int numberOfSegments()        // the number of line segments
    {
        return size;
    }
    public LineSegment[] segments()                // the line segments
    {
        return ls;
    }



    public static void main(String[] args) 
    {

        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // for(int i = 0; i < n; i++) {
        //     Point p = points[i];
        //     StdOut.println(p.toString());
        // }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}

