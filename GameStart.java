package dungeon_rpg;

import dungeon_rpg.battle.Battle;
import dungeon_rpg.map.MapManager;
import dungeon_rpg.monster.Monster;
import dungeon_rpg.player.Player;


public class GameStart {
    Player player = new Player("勇者", 100, 1, 0, 0);
    Monster monster = new Monster("スライム", 200, 1, 0);
    Battle battle = new Battle();
    Position current = new Position(1, 1);

    // MapManagerクラスをインスタンス化して引数this(GameStart)を渡します。
    public MapManager mapM = new MapManager(this);


    public GameStart() {
        mapM.maze();
    }

    public void battleLog() {
        for (int i = 0; monster.getHp() > 0; i++) {
            if (monster.getHp() != 0) {
                battle.playerAttackDamage(player, monster);
                if (monster.getHp() <= 0) {
                    monster.Hp0();
                    break;
                }
                battle.playerCriticalHit(player, monster);
                if (monster.getHp() <= 0) {
                    monster.Hp0();
                    break;
                }
                battle.monsterAttackDamage(player, monster);
                if (player.getHp() <= 0) {
                    player.Hp0();
                    break;
                }
                battle.monsterLargeDamage(player, monster);
                if (player.getHp() <= 0) {
                    player.Hp0();
                    break;
                }
            }
        }
        if (player.getHp() > 0) {
            System.out.println("勇者は勝利した！");
            player.training();
            player.put(player.getName() + "のlvは" + player.getLv() + "lv上がりました！" + " : HPは : " + player.getLv() + "回復しました！");
            player = new Player("勇者", player.getHp(), player.getLv(), 0, 0);
            monster = new Monster("スライム", 200, 1, 0);
        } else {
            System.out.println("勇者は負けた！");
            mapM.current = new Position(1, 1);
            monster = new Monster("スライム", 200, 1, 0);
        }
    }
}
