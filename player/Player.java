package dungeon_rpg.player;

import dungeon_rpg.character.Character;

import java.util.Random;

public class Player extends Character {
    private String name;
    private int hp;
    private int lv;
    private int criticalHit;
    private int attackDamage;

    public Player(String name, int hp, int lv, int attackDamage, int criticalHit) {
        super(name, hp, lv);
        this.name = name;
        this.hp = hp;
        this.lv = lv;
        this.attackDamage = attackDamage;
        this.criticalHit = criticalHit;
    }
}



