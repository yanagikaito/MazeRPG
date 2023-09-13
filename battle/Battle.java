package dungeon_rpg.battle;

import dungeon_rpg.monster.Boss;
import dungeon_rpg.monster.Monster;
import dungeon_rpg.player.Player;

import java.util.Random;

public class Battle {
    private static final int MIN = 0;
    private Random random = new Random();

    public Battle() {

    }

    public void playerAttackDamage(Player player, Monster monster) {
        int attackDamage = 0;
        int enemyRandomDamage = 200;
        attackDamage = random.nextInt(enemyRandomDamage) + 11;
        int monsterResult = monster.getHp() - attackDamage < MIN ? MIN : monster.getHp() - attackDamage;
        monster.setHp(monsterResult);
        if (monster.setHp(monsterResult) < MIN) {
            monster.Hp0();
        }
        player.putStatus();
        player.put(player.getName() + "の攻撃！" + monster.getName() + "に" + attackDamage
                + "のダメージ！" + " 残りの" + monster.getName() + "のHPは" + monster.setHp(monsterResult));
    }

    public void playerBossAttackDamage(Player player, Boss boss) {
        int attackDamage = 0;
        int enemyRandomDamage = 200;
        attackDamage = random.nextInt(enemyRandomDamage) + 11;
        int bossResult = boss.getHp() - attackDamage < MIN ? MIN : boss.getHp() - attackDamage;
        boss.setHp(bossResult);
        if (boss.setHp(bossResult) < MIN) {
            boss.Hp0();
        }
        player.putStatus();
        player.put(player.getName() + "の攻撃！" + boss.getName() + "に" + attackDamage
                + "のダメージ！" + " 残りの" + boss.getName() + "のHPは" + boss.setHp(bossResult));
    }

    public void monsterAttackDamage(Player player, Monster monster) {
        int attackDamage = 0;
        int enemyRandomDamage = 5;
        attackDamage = random.nextInt(enemyRandomDamage) + 8;
        int playerResult = player.getHp() - attackDamage < MIN ? MIN : player.getHp() - attackDamage;
        if (player.setHp(playerResult) < MIN) {
            player.Hp0();
        }
        monster.putStatus();
        monster.put(monster.getName() + "の攻撃！" + player.getName() + "に" + attackDamage
                + "のダメージ！" + " 残りの" + player.getName() + "のHPは" + player.setHp(playerResult));
    }

    public void playerCriticalHit(Player player, Monster monster) {
        int criticalHit = 0;
        int enemyRandomDamage = 10;
        int randomPlayerCriticalHitProbability = 5;
        if ((random.nextInt(randomPlayerCriticalHitProbability) + 1) == 1) {
            criticalHit = random.nextInt(enemyRandomDamage) + 11;
            criticalHit *= 2;
            int monsterResult = monster.getHp() - criticalHit < MIN ? MIN : monster.getHp() - criticalHit;
            if (monster.setHp(monsterResult) < MIN) {
                monster.Hp0();
            }
            player.putStatus();
            player.put(player.getName() + "の攻撃！会心の一撃！" + monster.getName() + "に" + criticalHit
                    + "のダメージ！" + " 残りの" + monster.getName() + "のHPは " + monster.setHp(monsterResult));
        }
    }

    public void monsterLargeDamage(Player player, Monster monster) {
        int monsterCriticalHit = 0;
        int enemyRandomDamage = 10;
        int randomMonsterLargeDamageProbability = 10;
        if ((random.nextInt(randomMonsterLargeDamageProbability) + 1) == 1) {
            monsterCriticalHit = random.nextInt(enemyRandomDamage) + 11;
            monsterCriticalHit *= 2;
            int playerResult = player.getHp() - monsterCriticalHit < MIN ? MIN : player.getHp() - monsterCriticalHit;
            if (player.setHp(playerResult) < MIN) {
                player.Hp0();
            }
            monster.putStatus();
            monster.put(monster.getName() + "の攻撃！" + player.getName() + "に" + monsterCriticalHit
                    + "の大ダメージ！" + " 残りの" + player.getName() + "のHPは" + player.setHp(playerResult));
        }
    }

    public void bossAttackDamage(Player player, Boss boss) {
        int attackDamage = 0;
        int enemyRandomDamage = 500;
        attackDamage = random.nextInt(enemyRandomDamage) + 8;
        int playerResult = player.getHp() - attackDamage < MIN ? MIN : player.getHp() - attackDamage;
        if (player.setHp(playerResult) < MIN) {
            player.Hp0();
        }
        boss.putStatus();
        boss.put(boss.getName() + "の攻撃！" + player.getName() + "に" + attackDamage
                + "のダメージ！" + " 残りの" + player.getName() + "のHPは" + player.setHp(playerResult));
    }

    public int training(Player player) {

        // レベル上昇1～9
        int lvUp = random.nextInt(10) + 1;
        int xp = random.nextInt(100) + 1; //　経験値
        if (xp > lvUp) {
            int lvamount = lvUp;
            int hpResult = player.getHp() + player.setLv(lvamount);
            player.setHp(hpResult);
            player.put(player.getName() + "のlvは : " + player.getLv() + "lv上がりました！" + " : HPは : " + lvamount + "回復しました！");
            player.put(player.getName() + " : 残りHP : " + player.getHp() + "です！");
        } else {
            player.put(player.getName() + "のlvは : " + player.getLv() + " : lv上がりませんでした！" + " : 残り : HPは : " + player.getHp() + "です！");
        }
        return MIN;
    }
}
