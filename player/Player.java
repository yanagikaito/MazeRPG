package dungeon_rpg.player;

import dungeon_rpg.character.Character;


public class Player extends Character {
    private String name;
    private int hp;
    private int lv;
    private int mp;
    private int gold;
    private int criticalHit;
    private int attackDamage;
    private int magicAttack;

    public Player(String name, int hp, int lv, int mp, int attackDamage, int magicAttack, int criticalHit, int gold) {
        super(name, hp, lv, gold, mp);
        this.name = name;
        this.hp = hp;
        this.lv = lv;
        this.mp = mp;
        this.gold = gold;
        this.attackDamage = attackDamage;
        this.criticalHit = criticalHit;
        this.magicAttack = magicAttack;
    }
}



