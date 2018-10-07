package homework_test;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import homework.Ant;

public class Ant_test {
	
	Ant ant1 = new Ant("1", 0, 1, Color.RED);
	Ant ant2 = new Ant("2", 5, 1, Color.RED);
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testIsCollision() {
		ant1.creeping();
		assertEquals(true, ant1.isCollision(ant2));
	}

	@Test
	public void testCreeping() {
		ant1.creeping();
		assertEquals(5, ant1.getPosition());
	}

	@Test
	public void testChangeDirect() {
		ant1.changeDirect();
		assertEquals(-1, ant1.getDirect());
	}

}
