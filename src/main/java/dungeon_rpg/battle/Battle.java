package dungeon_rpg.battle;

import dungeon_rpg.magic.*;
import dungeon_rpg.monster.Boss;
import dungeon_rpg.monster.Slime;
import dungeon_rpg.player.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Battle {
    private static final int MIN = 0;
    private Random random = new Random();

    public Battle() {

    }

    public void playerAttackDamage(Player player, Slime slime) {
        int attackDamage = 0;
        int enemyRandomDamage = 100;
        attackDamage = random.nextInt(enemyRandomDamage) + 11;
        int monsterResult = slime.getHp() - attackDamage < MIN ? MIN : slime.getHp() - attackDamage;
        slime.setHp(monsterResult);
        if (slime.setHp(monsterResult) < MIN) {
            slime.Hp0();
        }
        player.putStatus();
        player.put(player.getName() + "の攻撃！" + slime.getName() + "に" + attackDamage
                + "のダメージ！" + " 残りの" + slime.getName() + "のHPは" + slime.setHp(monsterResult));
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

    public void monsterAttackDamage(Player player, Slime slime) {
        int attackDamage = 0;
        int enemyRandomDamage = 5;
        attackDamage = random.nextInt(enemyRandomDamage) + 8;
        int playerResult = player.getHp() - attackDamage < MIN ? MIN : player.getHp() - attackDamage;
        if (player.setHp(playerResult) < MIN) {
            player.Hp0();
        }
        slime.putStatus();
        slime.put(slime.getName() + "の攻撃！" + player.getName() + "に" + attackDamage
                + "のダメージ！" + " 残りの" + player.getName() + "のHPは" + player.setHp(playerResult));
    }

    public void playerCriticalHit(Player player, Slime slime) {
        int criticalHit = 0;
        int enemyRandomDamage = 10;
        int randomPlayerCriticalHitProbability = 5;
        if ((random.nextInt(randomPlayerCriticalHitProbability) + 1) == 1) {
            criticalHit = random.nextInt(enemyRandomDamage) + 11;
            criticalHit *= 2;
            int monsterResult = slime.getHp() - criticalHit < MIN ? MIN : slime.getHp() - criticalHit;
            if (slime.setHp(monsterResult) < MIN) {
                slime.Hp0();
            }
            player.putStatus();
            player.put(player.getName() + "の攻撃！会心の一撃！" + slime.getName() + "に" + criticalHit
                    + "のダメージ！" + " 残りの" + slime.getName() + "のHPは " + slime.setHp(monsterResult));
        }
    }

    public void monsterLargeDamage(Player player, Slime slime) {
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
            slime.putStatus();
            slime.put(slime.getName() + "の攻撃！" + player.getName() + "に" + monsterCriticalHit
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

    public void magicAttack(MagicType magicType, Player player, Slime slime) {
        final Map<MagicType, Magic> magics = new HashMap<>();
        Fire fire = new Fire(player, 50);
        Thunder thunder = new Thunder(player, player.getMp());
        Blizzard blizzard = new Blizzard(player, player.getMp());
        magics.put(MagicType.FIRE, fire);
        magics.put(MagicType.THUNDER, thunder);
        magics.put(MagicType.BLIZZARD, blizzard);
        Magic usingMagic = magics.get(magicType);
        showMagicName(usingMagic);
        consumeMagicPoint(usingMagic, player);
        magicDamage(usingMagic, slime, player);
    }

    public void showMagicName(Magic magic) {
        String name = magic.name();
        System.out.println(" 魔法 :" + name + "を発動！");
    }

    // 魔法力を消費する
    public void consumeMagicPoint(Magic magic, Player player) {
        int costMagicPoint = magic.costMagicPoint();
        int magicResult = magic.getPlayerMp() - costMagicPoint < MIN ? MIN : magic.getPlayerMp() - costMagicPoint;
        player.setMp(magicResult);
        if (player.setMp(magicResult) < MIN) {
            player.Mp0();
        }
        player.put(player.getName() + "はMP : " + costMagicPoint + "を消費した！");
        player.put("残りの : " + player.getName() + "のMPは : " + player.setMp(magicResult) + "です！");
    }

    // ダメージ計算をする
    public void magicDamage(Magic magic, Slime slime, Player player) {
        int attackPower = magic.attackPower();
        int monsterResult = slime.getHp() - attackPower < MIN ? MIN : slime.getHp() - attackPower;
        slime.setHp(monsterResult);
        if (slime.setHp(monsterResult) < MIN) {
            slime.Hp0();
        }
        player.put(player.getName() + "の魔法攻撃！" + slime.getName() + "に" + attackPower
                + "のダメージ！" + " 残りの" + slime.getName() + "のHPは" + slime.setHp(monsterResult));
        player.putStatus();
    }

    public void bossMagicAttack(MagicType magicType, Player player, Boss boss) {
        final Map<MagicType, Magic> magics = new HashMap<>();
        Fire fire = new Fire(player, 50);
        Thunder thunder = new Thunder(player, player.getMp());
        Blizzard blizzard = new Blizzard(player, player.getMp());
        magics.put(MagicType.FIRE, fire);
        magics.put(MagicType.THUNDER, thunder);
        magics.put(MagicType.BLIZZARD, blizzard);
        Magic usingMagic = magics.get(magicType);
        showMagicName(usingMagic);
        consumeMagicPoint(usingMagic, player);
        bossMagicDamage(usingMagic, boss, player);
    }

    public void bossMagicDamage(Magic magic, Boss boss, Player player) {
        int attackPower = magic.attackPower();
        int monsterResult = boss.getHp() - attackPower < MIN ? MIN : boss.getHp() - attackPower;
        boss.setHp(monsterResult);
        if (boss.setHp(monsterResult) < MIN) {
            boss.Hp0();
        }
        player.put(player.getName() + "の魔法攻撃！" + boss.getName() + "に" + attackPower
                + "のダメージ！" + " 残りの" + boss.getName() + "のHPは" + boss.setHp(monsterResult));
        player.putStatus();
    }


    public void training(Player player) {

        // レベル上昇1～9
        int lvUp = random.nextInt(10) + 1;
        int xp = random.nextInt(100) + 1; //　経験値
        int randomGold = random.nextInt(10) + 1; // 通貨
        if (xp > lvUp) {
            int lvamount = player.getLv() + lvUp;
            int hpResult = player.getHp() + lvUp;
            int goldAmount = player.getGold() + randomGold;
            player.setLv(lvamount);
            player.setHp(hpResult);
            player.setGold(goldAmount);
            player.put("経験値 : " + xp + " : 入手 " + player.getName() + "のlvは : " + " lv : " + lvUp + "上がりました！" + " : HP : " + lvUp + " 回復しました！");
            player.put("ゴールド : " + randomGold + " G入手！ ");
            player.put(player.getName() + " : 残りHP : " + player.getHp() + "です！");
            player.put(player.getName() + " : 所持金 : " + player.getGold() + "Gです!");
            player.put(player.getName() + " : 現在のlv : " + player.setLv(lvamount) + "です！");
        } else {
            player.put(player.getName() + "のlvは : " + player.getLv() + " : lv上がりませんでした！" + " : 残り : HPは : " + player.getHp() + "です！");
            player.put("所持金は入手できませんでした！");
        }
    }
}
