package it.unicam.cs.pa.mastermind.JTest;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.mastermind.player.InteractivePlayer;
import it.unicam.cs.pa.mastermind.player.PlayerAction;
import it.unicam.cs.pa.mastermind.player.Role;

class Player_Test {

	@Test
	void test() 
	{
		InteractivePlayer simo = new InteractivePlayer();
		simo.setRole(Role.CODEBREACKER);
		simo.fillPlayerActionMap();
		simo.getPlayerActionMap();
		simo.selectAction();
		assertTrue(simo.getPlayerActionMap().containsValue(PlayerAction.INSERTCOLOR));
		assertTrue(simo.getAction() == PlayerAction.INSERTCOLOR);
		System.out.println(simo.getAction());
	}

}
