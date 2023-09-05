package dungeon_rpg.character;

import java.util.Random;

public class Character {
    private static final int MIN = 0;
    private String name;
    private Integer hp;
    private Random random = new Random();


    public Character(String name, Integer hp) {
        this.name = name;
        if (hp < MIN) {
            try {
                throw new IllegalAccessException();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        this.hp = hp;
    }

    public String getName() {
        return this.name;
    }

    public Integer getHp() {
        return this.hp;
    }

    public Integer setHp(Integer hp) {
        return this.hp = hp;
    }

    public void Hp0() {
        this.hp = MIN;
    }
}

