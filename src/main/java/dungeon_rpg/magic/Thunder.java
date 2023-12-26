package dungeon_rpg.magic;


import dungeon_rpg.player.Player;

public class Thunder implements Magic {
    private final Player player;
    private int mp;

    public Thunder(final Player player, int mp) {
        this.player = player;
        this.mp = mp;
    }

    public String name() {
        return "サンダー";
    }

    public int getPlayerMp() {
        return this.mp;
    }

    public int setPlayerMp(int mp) {
        return this.mp = mp;
    }

    public int costMagicPoint() {
        return 5 + (int) (player.getMp() * 0.2);
    }

    public int attackPower() {
        return 20 + (int) (player.getLv() * 0.5);
    }
}

