import java.util.Arrays;


public class FastCollinearPoints 
{
    public FastCollinearPoints(Point[] points)     // finds all line segments containing 4 or more points
    {
        if(points == null) throw new IllegalArgumentException();
        for(int i = 0; i < points.length; i++)
            if(points[i] == null) throw new IllegalArgumentException();


    }
    public int numberOfSegments()        // the number of line segments
    {

    }
    public LineSegment[] segments()                // the line segments
    {

    }
}
