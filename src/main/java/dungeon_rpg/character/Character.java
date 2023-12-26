package dungeon_rpg.character;


import java.util.Random;

public class Character {
    private static final int MIN = 0;
    private String name;
    private Integer hp;
    private Integer lv;
    private Integer mp;
    private Integer gold;
    private Random random = new Random();

    public Character(String name, Integer hp, Integer lv, Integer mp, Integer gold) {
        this.name = name;
        this.lv = lv;
        if (hp < MIN || gold < MIN || mp < MIN) {
            try {
                throw new IllegalAccessException();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        this.hp = hp;
        this.mp = mp;
        this.gold = gold;
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

    public Integer getGold() {
        return this.gold;
    }

    public Integer setGold(Integer gold) {
        return this.gold = gold;
    }

    public Integer setLv(Integer lv) {
        return this.lv = lv;
    }

    public Integer setHp(Integer hp) {
        return this.hp = hp;
    }

    public Integer getMp() {
        return this.mp;
    }

    public Integer setMp(Integer mp) {
        return this.mp = mp;
    }

    public void Hp0() {
        this.hp = MIN;
    }

    public void Mp0() {
        this.mp = MIN;
    }

    public void Gold0() {
        this.gold = MIN;
    }

    public void putStatus() {
        put("--------------------------");

        put("--------------------------");
    }

    public void put(String str) {
        System.out.println(str);
    }
}

