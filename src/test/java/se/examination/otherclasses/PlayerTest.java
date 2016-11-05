package se.examination.otherclasses;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import se.examination.otherclasses.Player;

public class PlayerTest {

	public static final Logger LOG = Logger.getLogger(Player.class.getName());
	Player player = new Player();
	
	@Test
	public void testSetAndGetName() {
		player.setName("Carina");
		LOG.info("Testing the setName and getName methods with value: Carina");
		assertEquals(player.getName(), "Carina");
	}

	@Test
	public void testSetAndGetPoints() {
		player.setPoints(37);
		LOG.info("Testing the setPoints and getPoints methods with value: 37");
		assertEquals(player.getPoints(), 37);
	}
	
	@Test
	public void testIncreasePoints() {
		player.setPoints(37);
		player.increasePoints();
		LOG.info("Testing the increasePoints method with value: 37");
		assertEquals(player.getPoints(), 38);
	}
	
	@Test
	public void testSetAndGetCompleted() {
		player.setCompleted(8);
		LOG.info("Testing the setCompleted and getCompleted methods with value: 8");
		assertEquals(player.getCompleted(), 8);
	}
	
	@Test
	public void testIncreaseCompleted() {
		player.setCompleted(8);
		player.increaseCompleted();
		LOG.info("Testing the increaseCompleted method with value: 8");
		assertEquals(player.getCompleted(), 9);
	}

}
