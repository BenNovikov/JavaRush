package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ben on 2017-10-06.
 *
 * */
public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    int score;
    int maxTile;

    public Model() {
        resetGameTiles();
        score = 0;
        maxTile = 2;
    }

    void resetGameTiles() {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }

        addTile();
        addTile();
    }

    private void addTile() {
        List<Tile> tiles = getEmptyTiles();
        if (tiles != null && !tiles.isEmpty())
            tiles.get((int)(Math.random() * tiles.size())).setValue(Math.random() < 0.9 ? 2 : 4);
    }

    List<Tile> getEmptyTiles() {
        List<Tile> list = new ArrayList<>();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].isEmpty())
                    list.add(gameTiles[i][j]);
            }
        }

        return list;
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean isChanged = false;
        Tile temp;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tiles[j].getValue() == 0 && tiles[j + 1].getValue() != 0) {
                    temp = tiles[j];
                    tiles[j] = tiles[j + 1];
                    tiles[j + 1] = temp;
                    isChanged = true;
                }
            }
        }

        return isChanged;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean isChanged = false;
        for (int j = 0; j < 3; j++) {
            if (tiles[j].getValue() != 0 && tiles[j].getValue() == tiles[j + 1].getValue()) {
                tiles[j].setValue(tiles[j].getValue() * 2);
                tiles[j + 1].setValue(0);
                if (tiles[j].getValue() > maxTile)
                    maxTile = tiles[j].getValue();
                score += tiles[j].getValue();
                isChanged = true;
            }
        }

        if (isChanged) {
            Tile temp;
            for (int j = 0; j < 3; j++) {
                if (tiles[j].getValue() == 0 && tiles[j + 1].getValue() != 0) {
                    temp = tiles[j];
                    tiles[j] = tiles[j + 1];
                    tiles[j + 1] = temp;
                }
            }
        }

        return isChanged;
    }

    public void left() {
        boolean isChanged = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i])) {
                isChanged = true;
            }
        }
        if (isChanged) {
            addTile();
        }
    }

    public void up() {
        rotate();
        left();
        rotate();
        rotate();
        rotate();
    }

    public void right() {
        rotate();
        rotate();
        left();
        rotate();
        rotate();
    }

    public void down() {
        rotate();
        rotate();
        rotate();
        left();
        rotate();
    }

    // поворот матрицы на 90 градусов против часовой стрелки
    private void rotate() {
        int len = FIELD_WIDTH;
        for (int k = 0; k < len / 2; k++) // border -> center
        {
            for (int j = k; j < len - 1 - k; j++) // left -> right
            {

                Tile tmp = gameTiles[k][j];
                gameTiles[k][j] = gameTiles[j][len - 1 - k];
                gameTiles[j][len - 1 - k] = gameTiles[len - 1 - k][len - 1 - j];
                gameTiles[len - 1 - k][len - 1 - j] = gameTiles[len - 1 - j][k];
                gameTiles[len - 1 - j][k] = tmp;
            }
        }
    }

    // i'll keep my decision commented while that validator's craziness continues. it's a copy-paste up there.
//    private void rotateCW() {
//        final int M = gameTiles.length;
//        final int N = gameTiles[0].length;
//        Tile[][] ret = new Tile[N][M];
//        for (int r = 0; r < M; r++) {
//            for (int c = 0; c < N; c++) {
//                ret[c][M-1-r] = gameTiles[r][c];
//            }
//        }
//        gameTiles = ret;
//    }
}
