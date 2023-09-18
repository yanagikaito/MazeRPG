package dungeon_rpg.magic;


import dungeon_rpg.player.Player;

public class Fire implements Magic {
    private final Player player;

    public Fire(final Player player) {
        this.player = player;
    }

    public String name() {
        return "ファイア";
    }

    public int costMagicPoint() {
        return 2;
    }

    public int attackPower() {
        return 20 + (int) (player.getMp() * 0.5);
    }

    public int costTechnicalPoint() {
        return 0;
    }
}
