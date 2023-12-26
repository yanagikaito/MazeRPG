package dungeon_rpg.magic;

public interface Magic {
    String name();

    int getPlayerMp();

    int setPlayerMp(int mp);

    int costMagicPoint();

    int attackPower();
}
