package com.kuzdowicz.algo.maze.solvers;

import java.util.ArrayList;
import java.util.List;

public class MazeSolver {

    private final String EXIT_CHAR = "3";
    private final String WALL_CHAR = "1";
    private final int START_ROW = 0;
    private final int START_COL = 0;

    private boolean founded = false;

    private final List<List<String>> maze;
    private final boolean canMoveDiagonal;

    public MazeSolver(List<List<String>> maze, boolean canMoveDiagonal) {
        this.maze = maze;
        this.canMoveDiagonal = canMoveDiagonal;
    }

    public boolean solve() {

        List<List<Boolean>> visited = new ArrayList<>();

        for (int i = 0; i < maze.size(); i++) {
            visited.add(new ArrayList<>());
            for (int j = 0; j < maze.get(i).size(); j++) {
                visited.get(i).add(false);
            }
        }


        solveRecursively(visited, START_ROW, START_COL);

        return founded;
    }

    private void solveRecursively(List<List<Boolean>> visited, int rowIdx, int colIdx) {

        System.out.println("visiting rowIdx: " + rowIdx + " , colIdx: " + colIdx);

        if (colIdx < 0 || colIdx >= maze.size()) return;
        if (rowIdx < 0 || rowIdx >= maze.size()) return;
        if (visited.get(rowIdx).get(colIdx)) return;

        String currentChar = maze.get(colIdx).get(rowIdx);

        if (currentChar.equals(WALL_CHAR)) return;

        if (currentChar.equals(EXIT_CHAR)) {
            System.out.println("SOLVED MAZE !!!!!!");
            founded = true;
            return;
        }

        visited.get(rowIdx).add(colIdx, true);

        solveRecursively(visited, rowIdx - 1, colIdx);
        solveRecursively(visited, rowIdx + 1, colIdx);
        solveRecursively(visited, rowIdx, colIdx + 1);
        solveRecursively(visited, rowIdx, colIdx - 1);

        if (canMoveDiagonal) {
            solveRecursively(visited, rowIdx - 1, colIdx - 1);
            solveRecursively(visited, rowIdx + 1, colIdx + 1);
        }
    }

}
