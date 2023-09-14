package dungeon_rpg.player;

import dungeon_rpg.character.Character;


public class Player extends Character {
    private String name;
    private int hp;
    private int lv;
    private int gold;
    private int criticalHit;
    private int attackDamage;

    public Player(String name, int hp, int lv, int attackDamage, int criticalHit, int gold) {
        super(name, hp, lv, gold);
        this.name = name;
        this.hp = hp;
        this.lv = lv;
        this.gold = gold;
        this.attackDamage = attackDamage;
        this.criticalHit = criticalHit;
    }
}



