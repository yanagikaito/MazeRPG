package dungeon_rpg.map;

import dungeon_rpg.GameStart;
import dungeon_rpg.Position;
import java.util.Random;
import java.util.Scanner;

public class MapManager {
    GameStart gs;
    public Map mapTile = new Map();
    public Position current = new Position(1, 1);
    public Position goal = new Position(6, 0);

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
                System.out.println("GOAL!!");
                break;
            }
            update();
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
}



