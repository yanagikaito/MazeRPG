package dungeon_rpg.magic;


import dungeon_rpg.player.Player;

public class Blizzard implements Magic {
    private final Player player;

    private int mp;

    public Blizzard(final Player player, int mp) {
        this.player = player;
        this.mp = mp;
    }

    public String name() {
        return "ブリザド";
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
        return 200 + (int) (player.getLv() * 0.5 + player.getMp() * 2);
    }
}
