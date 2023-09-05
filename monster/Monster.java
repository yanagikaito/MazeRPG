package dungeon_rpg.monster;

import dungeon_rpg.character.Character;

public class Monster extends Character {
    private String name;
    private int hp;
    private int attackDamage;


    public Monster(String name, int hp, int attackDamage) {
        super(name, hp);
        this.name = name;
        this.hp = hp;
        this.attackDamage = attackDamage;
    }
}