package dungeon_rpg.monster;

import dungeon_rpg.character.Character;

public class Boss extends Character {
    private String name;
    private int hp;
    private int lv;
    private int gold;
    private int attackDamage;

    public Boss(String name, int hp, int attackDamage, int lv, int gold) {
        super(name, hp, lv, gold, attackDamage);
        this.name = name;
        this.hp = hp;
        this.gold = gold;
        this.lv = lv;
        this.attackDamage = attackDamage;
    }
}
