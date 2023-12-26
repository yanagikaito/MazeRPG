package dungeon_rpg.magic;


import dungeon_rpg.player.Player;

public class Fire implements Magic {
    private final Player player;

    private int mp;

    public Fire(final Player player, int mp) {
        this.player = player;
        this.mp = mp;
    }

    public String name() {
        return "ファイア";
    }

    public int getPlayerMp() {
        return this.mp;
    }

    public int setPlayerMp(int mp) {
        return this.mp = mp;
    }

    public int costMagicPoint() {
        return 2;
    }

    public int attackPower() {
        return 20 + (int) (player.getMp() * player.getLv());
    }
}
