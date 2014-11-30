package proj2;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PopulationTest {
	Population p;
	Population p2;
	Population p3;
	Map<Point, Cell> m;

	@Before
	public void setUp() throws Exception {
		p = new Population(2, 3);
		p2 = new Population(100, 200);
		p3 = new Population(5,5);
		m = new HashMap<Point, Cell>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetPop() {
		//System.out.println(p.getPop().values());
		m.put(new Point(100, 100), new Cell(0, new Point(100, 100)));
		p.setPop(m);
		//System.out.println(p.getPop().values());

		
	}

	@Test
	public void testGetNumRows() {
		assertEquals(p.numRows, 2);
	}

	@Test
	public void testGetNumCols() {
		assertEquals(p.numCols, 3);	
		p3.setNeighbors();
		}

	

}
