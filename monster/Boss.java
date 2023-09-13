package dungeon_rpg.monster;

import dungeon_rpg.character.Character;

public class Boss extends Character {
    private String name;
    private int hp;
    private int attackDamage;
    private int lv;

    public Boss(String name, int hp, int attackDamage, int lv) {
        super(name, hp, lv);
        this.name = name;
        this.hp = hp;
        this.attackDamage = attackDamage;
        this.lv = lv;
    }
}
