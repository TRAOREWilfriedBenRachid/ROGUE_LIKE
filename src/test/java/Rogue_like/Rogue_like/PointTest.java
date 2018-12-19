package Rogue_like.Rogue_like;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

		public Point point;
		public Point point1;
		
	@Test
	public void test() {
		fail("Not yet implemented");
		
		point = new Point(20, 20, 20);
		point1 = new Point(20, 20, 20);
		
		// test equality
		assertEquals(point, point1);
		
		// test hashcode
		assertTrue(point.hashCode() == point1.hashCode());
		
		List<Point> points = point.neighbors8();
		List<Point> points1 = point1.neighbors8();
		
		Assert.assertFalse(point.neighbors8().isEmpty());
		Assert.assertEquals(point.neighbors8().size(), 8);
		
		// test if empty
		Assert.assertFalse(points.isEmpty());
		
		// test if size 8
		Assert.assertEquals(points.size(), 8);
		
		
		
	}

}
