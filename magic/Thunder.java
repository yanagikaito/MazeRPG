package dungeon_rpg.magic;


import dungeon_rpg.player.Player;

public class Thunder implements Magic {
    private final Player player;

    public Thunder(final Player player) {
        this.player = player;
    }

    public String name() {
        return "サンダー";
    }

    public int costMagicPoint() {
        return 5 + (int) (player.getMp() * 0.2);
    }

    public int attackPower() {
        return 20 + (int) (player.getLv() * 0.5);
    }

    public int costTechnicalPoint() {
        return 0;
    }
}

