package dungeon_rpg.map;

import dungeon_rpg.GameStart;
import dungeon_rpg.Position;

import java.util.Random;
import java.util.Scanner;

public class MapManager {
    GameStart gs;
    public Map mapTile = new Map();
    public Position current = new Position(1, 1);
    public Position current2 = new Position(6, 1);
    public Position goal = new Position(6, 1);
    public Position goal2 = new Position(1, 0);

    public MapManager(GameStart gs) {
        this.gs = gs;
    }

    public void maze() {

        for (; ; ) {

            // 迷路の表示
            for (int col = 0; col < mapTile.map.length; col++) {

                for (int row = 0; row < mapTile.map[col].length; row++) {

                    if (row == current.getRow() && col == current.getCol()) {
                        System.out.print("P");

                    } else if (mapTile.map[col][row] == 1) {
                        System.out.print("■");

                    } else {
                        System.out.print(".");
                    }
                }
                System.out.println();
            }

            // ゴール判定
            if (current.equals(goal)) {
                System.out.println("ステージ2!");
                break;
            }
            update();
        }
    }

    public void maze2() {

        for (; ; ) {

            // 迷路の表示
            for (int col = 0; col < mapTile.map2.length; col++) {

                for (int row = 0; row < mapTile.map2[col].length; row++) {

                    if (row == current2.getRow() && col == current2.getCol()) {
                        System.out.print("P");

                    } else if (mapTile.map2[col][row] == 3) {
                        System.out.print("▲");

                    } else if (mapTile.map2[col][row] == 2) {
                        System.out.print(".");
                    }
                }
                System.out.println();
            }

            // ゴール判定
            if (current2.equals(goal2)) {
                System.out.println("GOAL!!");
                break;
            }
            update2();
        }
    }

    public void update() {

        // キー入力処理

        Scanner ch = new Scanner(System.in);
        String str = ch.nextLine();

        // 押された方向の座標を得る
        Position next = switch (str) {
            case "a" -> new Position(current.getRow() - 1, current.getCol());
            case "w" -> new Position(current.getRow(), current.getCol() - 1);
            case "s" -> new Position(current.getRow() + 1, current.getCol());
            case "z" -> new Position(current.getRow(), current.getCol() + 1);
            default -> current;
        };

        // 押された方向が通路なら進む
        if (mapTile.map[next.getCol()][next.getRow()] == 0) {
            current = next;
        }
        int randomProbability = 5;
        Random random = new Random();
        if ((random.nextInt(randomProbability) + 1) == 1) {
            if (mapTile.map[next.getCol()][next.getRow()] == 0) {
                current = next;
                System.out.println("勇者はモンスターに遭遇した！");
                gs.battleLog();
            }
        }
    }

    public void update2() {

        Scanner ch = new Scanner(System.in);
        String str2 = ch.nextLine();

        Position next2 = switch (str2) {
            case "a" -> new Position(current2.getRow() - 1, current2.getCol());
            case "w" -> new Position(current2.getRow(), current2.getCol() - 1);
            case "s" -> new Position(current2.getRow() + 1, current2.getCol());
            case "z" -> new Position(current2.getRow(), current2.getCol() + 1);
            default -> current2;
        };

        if (mapTile.map2[next2.getCol()][next2.getRow()] == 2) {
            current2 = next2;
        }
        int randomProbability = 5;
        Random random = new Random();
        if ((random.nextInt(randomProbability) + 1) == 1) {
            if (mapTile.map2[next2.getCol()][next2.getRow()] == 2) {
                current2 = next2;
                System.out.println("勇者はモンスターに遭遇した！");
                gs.battleLog();
            }
        }
    }
}




