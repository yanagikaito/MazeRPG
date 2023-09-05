package dungeon_rpg.monster;

import dungeon_rpg.character.Character;

public class Monster extends Character {
    private String name;
    private int hp;
    private int attackDamage;
    private int lv;


    public Monster(String name, int hp, int lv, int attackDamage) {
        super(name, hp, lv);
        this.name = name;
        this.hp = hp;
        this.lv = lv;
        this.attackDamage = attackDamage;
    }
}