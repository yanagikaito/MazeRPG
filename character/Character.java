package dungeon_rpg.character;

import dungeon_rpg.player.Player;

import java.util.Random;

public class Character {
    private static final int MIN = 0;
    private String name;
    private Integer hp;
    private Integer lv;
    private Random random = new Random();


    public Character(String name, Integer hp, Integer lv) {
        this.name = name;
        this.lv = lv;
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

    public Integer getLv() {
        return this.lv;
    }

    public Integer setHp(Integer hp) {
        return this.hp = hp;
    }

    public void Hp0() {
        this.hp = MIN;
    }

    public void putStatus() {
        put("--------------------------");

        put("--------------------------");
    }

    public void put(String str) {
        System.out.println(str);
    }
}

