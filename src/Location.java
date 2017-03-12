/**
 * Created by Carlos on 12/03/2017.
 */
import java.awt.geom.Point2D;
import java.util.Random;

public class Location {
    Point2D.Double topLeft;
    Point2D.Double bottomRight;
    Random r;

    public Location() {

    }

    public Location(Point2D.Double pTopLeft, Point2D.Double pBottomRight) {
        this.topLeft = pTopLeft;
        this.bottomRight = pBottomRight;
        r = new Random();
    }

    public Point2D.Double getRandomLocation() {
        boolean isXDifferenceInfinite = Double.isInfinite(this.topLeft.getX() - this.bottomRight.getX());
        boolean isYDifferenceInfinite = Double.isInfinite(this.topLeft.getY() - this.bottomRight.getY());
        // Have to add proper relative bounds checking
        double randomX = 0.0;
        double randomY = 0.0;
        if(!isXDifferenceInfinite && !isYDifferenceInfinite) {
            if(this.topLeft.getX() > this.bottomRight.getX()) {
                randomX = this.bottomRight.getX() + (this.topLeft.getX() - this.bottomRight.getX()) * r.nextDouble();
            }
            else {
                randomX = this.topLeft.getX() + (this.bottomRight.getX() - this.topLeft.getX()) * r.nextDouble();
            }
            if(this.topLeft.getY() > this.bottomRight.getY()) {
                randomY = this.bottomRight.getY() + (this.topLeft.getY() - this.bottomRight.getY()) * r.nextDouble();
            }
            else {
                randomY = this.topLeft.getY() + (this.bottomRight.getY() - this.topLeft.getY()) * r.nextDouble();
            }
        }
        return new Point2D.Double(randomX, randomY);
    }

}
