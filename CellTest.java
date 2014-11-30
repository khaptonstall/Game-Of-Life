package proj2;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CellTest {
	Cell a;
	Cell b;
	

	@Before
	public void setUp() throws Exception {
		a = new Cell(0, new Point(1, 2));
		b = new Cell(1, new Point(5,5));
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testCell(){
		assertEquals(a.state, 0);
		assertEquals(b.state, 1);
	}

	@Test
	public void testChangeState() {
		assertEquals(a.state, 0);
		a.changeState();
		assertEquals(a.state, 1);
	}

	@Test
	public void testGetLoc() {
		assertEquals(a.getLoc(), new Point(1,2));
		assertEquals(b.getLoc(), new Point(5,5));
	}

	@Test
	public void testSetLoc() {
		assertEquals(a.getLoc(), new Point(1,2));
		a.setLoc(new Point(100, 100));
		assertEquals(a.getLoc(), new Point(100,100));

	}

	@Test
	public void testAddNeighbor() {
		assertEquals(a.getNeighbors(), 0);
		a.addNeighbor(b);
		assertEquals(a.getNeighbors(), 1);

	}

}
