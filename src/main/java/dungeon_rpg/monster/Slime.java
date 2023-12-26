package dungeon_rpg.monster;

import dungeon_rpg.character.Character;

public class Slime extends Character {
    private String name;
    private int hp;
    private int attackDamage;
    private int lv;
    private int gold;

    public Slime(String name, int hp, int lv, int attackDamage, int gold) {
        super(name, hp, lv, gold, attackDamage);
        this.name = name;
        this.hp = hp;
        this.lv = lv;
        this.gold = gold;
        this.attackDamage = attackDamage;
    }
}