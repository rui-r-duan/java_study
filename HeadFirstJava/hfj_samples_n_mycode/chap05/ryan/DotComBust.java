package chap05.ryan;

import java.io.*;
import java.util.ArrayList;

class DotCom {
    private String name;
    private ArrayList<Position> positions;

    public DotCom(String name) {
        this.name = name;
        positions = new ArrayList<Position>();
    }

    private void onHit(int posIndex) {
        positions.remove(posIndex);
    }

    public boolean isAlive() {
        return !positions.isEmpty();
    }

    public boolean isHit(Position p) {
        int index = positions.indexOf(p);
        if (index != -1) {
            onHit(index);
            return true;
        } else {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    // test
    public void addPos(Position p) {
        positions.add(p);       // may throw RuntimeException
    }
}

// TODO:
// optimize the internal data representation to make the comparison faster.
class Position {
    private int row;
    private int column;

    public Position(int r, int c) {
        row = r;
        column = c;
    }

    @Override
    public boolean equals(Object o) {
        if (null == o) {
            return false;
        } else if (this == o) {
            return true;
        }else if (o.getClass() != this.getClass())
            return false;
        } else {
            final Position p = (Position)o;
            return row == p.row && column == p.column;
        }
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = hash * 31 + row;
        hash = hash * 17 + column;
        return hash;
    }

    @Override
    public String toString() {
        return getClass().getName()
            + "(" + row + "," + column + ")";
    }

    public static Position translatePosStr(String posStr) {
        try {
            int row = posStr.charAt(0) - 'A';
            int column = Integer.parseInt(posStr.substring(1, 2));
            return new Position(row, column);
        } catch (NumberFormatException e) {
            System.out.println(e);
            throw e;
        }
    }
}

class GameBoard {
    private int rows;
    private int columns;

    public GameBoard(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }
}

public class DotComBust {
    private static final int DOTCOM_NUM = 3;
    private static final int GAMEBOARD_ROWS = 7;
    private static final int GAMEBOARD_COLS = 7;

    public static void main(String[] args) {
        int guessCnt = 0;
        DotComBust game = new DotComBust();
        GameBoard board = new GameBoard(GAMEBOARD_ROWS, GAMEBOARD_COLS);
        DotCom[] dotcoms = game.genDotComs(DOTCOM_NUM);
        if (dotcoms == null) {
            return;
        }

        game.placeDotComs(dotcoms, board);

        // TODO:
        // DotComBust game stores the status of alive or not,
        // get synced by callbacks from DotComs.
        while (game.anyDotComAlive(dotcoms)) {
            String guessedStr = game.getUserInput("Enter a guess  ");
            if (guessedStr == null) {
                System.out.println("You inputted nothing.  Try again.");
                continue;
            }

            Position guessedPos = null; // must out of try block for later use
            try {
                guessedPos = Position.translatePosStr(guessedStr);
                guessCnt++;
            } catch (NumberFormatException e) {
                System.out.println(guessedStr +
                                   " is not a valid input.  Please try again.");
                continue;
            }

            int i;              // must out of for loop for later use
            for (i = 0; i < dotcoms.length; i++) {
                if (dotcoms[i].isHit(guessedPos)) {
                    System.out.println("hit " + dotcoms[i].getName());

                    // TODO:
                    // use a callback to get informed by DotComs whether they
                    // are alive or not
                    // 
                    // OR
                    // 
                    // modify DotCom.isHit() to return "miss", "hit" and "kill"
                    if (!dotcoms[i].isAlive()) {
                        System.out.println("Ouch! You sunk " + dotcoms[i].getName());
                        // TODO:
                        // remove dead DotCom
                        // Be cautious in a iteration loop!!
                    }
                    break;
                }
            }
            if (i == dotcoms.length) {
                System.out.println("miss");
            }
        }
        // Now no DotCom is alive, you win!
        System.out.println("YOU WIN in " + guessCnt + " guess(es)!");
    }

    private DotCom[] genDotComs(int number) {
        DotCom[] dotcoms = new DotCom[number];
        for (int i = 0; i < number; i++) {
            // TODO:
            // give them names from a name pool
            dotcoms[i] = new DotCom(Integer.toString(i));
         }
        return dotcoms;
    }

    private void placeDotComs(DotCom[] dotcoms, GameBoard board) {
        // TODO:
        // 1. two types of DotCom, vertical and horizontal
        // 2. place them randomly in the game board; they must not overlap
        dotcoms[0].addPos(new Position(3, 0));
        dotcoms[0].addPos(new Position(2, 0));
        dotcoms[0].addPos(new Position(1, 0));

        dotcoms[1].addPos(new Position(3, 2));
        dotcoms[1].addPos(new Position(3, 3));
        dotcoms[1].addPos(new Position(3, 4));

        dotcoms[2].addPos(new Position(6, 3));
        dotcoms[2].addPos(new Position(6, 4));
        dotcoms[2].addPos(new Position(6, 5));
    }

    private boolean anyDotComAlive(DotCom[] dotcoms) {
        for (int i = 0; i < DOTCOM_NUM; i++) {
            if (dotcoms[i].isAlive()) {
                return true;
            }
        }
        return false;
    }

    private String getUserInput(String prompt) {
        String line = null;
        System.out.print(prompt);
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            line = reader.readLine();
            if (line.length() == 0) {
                return null;
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return line;
    }
}