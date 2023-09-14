package dungeon_rpg.character;


import java.util.Random;

public class Character {
    private static final int MIN = 0;
    private String name;
    private Integer hp;
    private Integer lv;
    private Integer gold;
    private Random random = new Random();

    public Character(String name, Integer hp, Integer lv, Integer gold) {
        this.name = name;
        this.lv = lv;
        if (hp < MIN || gold < MIN) {
            try {
                throw new IllegalAccessException();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        this.hp = hp;
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

    public void Hp0() {
        this.hp = MIN;
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

