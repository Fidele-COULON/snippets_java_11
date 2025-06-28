package fr.fidtec.mocks;

public class GameSimple {
	
	private final Player player;

    public GameSimple(Player player) {
        this.player = player;
    }

    public String attack() {
        return "Player attack with: " + player.getWeapon();
    }
}
