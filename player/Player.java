package dungeon_rpg.player;

import dungeon_rpg.character.Character;

public class Player extends Character {
    private String name;
    private int hp;
    private int criticalHit;
    private int attackDamage;


    public Player(String name, int hp, int attackDamage, int criticalHit) {
        super(name, hp);
        this.name = name;
        this.hp = hp;
        this.attackDamage = attackDamage;
        this.criticalHit = criticalHit;
    }
}



