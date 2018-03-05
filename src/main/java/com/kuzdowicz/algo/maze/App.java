package com.kuzdowicz.algo.maze;

import com.kuzdowicz.algo.maze.solvers.MazeSolver;

import java.util.List;

public class App {

    public static void main(String[] args) {

        List<List<String>> maze1 = new MazeLoader().loadMazeFromFile("small_maze.txt");
        System.out.println(maze1);
        boolean solved = new MazeSolver(maze1, false).solve();
        System.out.println("SOLVED maze1 => " + solved);

        List<List<String>> maze2 = new MazeLoader().loadMazeFromFile("small_maze_no_solution.txt");
        System.out.println(maze2);
        boolean solved2 = new MazeSolver(maze2, false).solve();
        System.out.println("SOLVED2 => " + solved2);

        boolean solved3 = new MazeSolver(maze2, true).solve();
        System.out.println("SOLVED3 with ability to move diagonal => " + solved3);

    }

}
