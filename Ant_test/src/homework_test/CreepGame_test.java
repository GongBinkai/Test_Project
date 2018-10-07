package homework_test;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import homework.Ant;
import homework.Stick;
import homework.CreepGame;

public class CreepGame_test {
	Ant[] ants = new Ant[5];
	Stick stick = new Stick(50);
	CreepGame creepgame = new CreepGame(ants, stick);
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testIsEnd() {
		ants[0] = new Ant("1", -1, 1, Color.RED);
		ants[1] = new Ant("1", 51, 1, Color.RED);
		ants[2] = new Ant("1", -1, 1, Color.RED);
		ants[3] = new Ant("1", 51, 1, Color.RED);
		ants[4] = new Ant("1", -1, 1, Color.RED);
		assertEquals(true, creepgame.isEnd());
	}

}
