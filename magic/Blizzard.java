package dungeon_rpg.magic;


import dungeon_rpg.player.Player;

public class Blizzard implements Magic {
    private final Player player;

    public Blizzard(final Player player) {
        this.player = player;
    }

    public String name() {
        return "ブリザド";
    }

    public int costMagicPoint() {
        return 2;
    }

    public int attackPower() {
        return 200 + (int) (player.getLv() * 0.5 + player.getMp() * 2);
    }

    public int costTechnicalPoint() {
        return 0;
    }
}
