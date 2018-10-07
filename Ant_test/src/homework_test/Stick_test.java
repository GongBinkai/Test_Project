package homework_test;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import homework.Ant;
import homework.Stick;

public class Stick_test {
	Ant ant1 = new Ant("1", 51, 1, Color.RED);
	Stick stick = new Stick(50);
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testIsOut() {
		assertEquals(true, stick.isOut(ant1));
	}

}
