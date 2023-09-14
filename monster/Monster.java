package dungeon_rpg.monster;

import dungeon_rpg.character.Character;

public class Monster extends Character {
    private String name;
    private int hp;
    private int attackDamage;
    private int lv;
    private int gold;

    public Monster(String name, int hp, int lv, int attackDamage, int gold) {
        super(name, hp, lv, gold);
        this.name = name;
        this.hp = hp;
        this.lv = lv;
        this.gold = gold;
        this.attackDamage = attackDamage;
    }
}