package fr.fidtec.mocks;

import java.util.List;

public class GameSpy {
	
	private Player player;

	private List<String> opponents;
	
    public GameSpy(Player player, List<String> opponents) {
        this.player = player;
        this.opponents = opponents;
    }

    public String attack() {
        return "Player attack with: " + player.getWeapon();
    }
    
    public int numberOfEnemies() {
        return opponents.size();
      }
}
