package ru.ruru.st.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by m.shoshin on 07.11.2016.
 */
public class PointTests {

    @Test
    public void testDistanceHP() {
        Point p1 = new Point(5, 7);
        Point p2 = new Point(1, 3);
        double a = 5.656854249492381;
        Assert.assertEquals(p1.distance(p2), a);
    }

    @Test
    public void testDistanceNegative() {
        Point p1 = new Point(-5, -7);
        Point p2 = new Point(-1, -3);
        double a = 5.656854249492381;
        Assert.assertEquals(p1.distance(p2), a);
    }

    @Test
    public void testDistanceZero() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 0);
        double a = 0;
        Assert.assertEquals(p1.distance(p2), a);
    }
}
