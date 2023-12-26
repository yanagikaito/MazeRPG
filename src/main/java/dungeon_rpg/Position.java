package dungeon_rpg;

import java.util.Objects;

public class Position {

    private final int row;

    private final int col;


    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        var that = (Position) obj;
        return this.col == that.col &&
                this.row == that.row;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

    @Override
    public String toString() {
        return "Position[" +
                "row=" + row + ", " +
                "col=" + col + ']';
    }
}

