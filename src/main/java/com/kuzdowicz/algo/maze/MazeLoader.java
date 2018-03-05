package com.kuzdowicz.algo.maze;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MazeLoader {

    List<List<String>> loadMazeFromFile(final String fileName) {
        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);

        List<List<String>> maze = new ArrayList<>();

        try {
            String fileContent = IOUtils.toString(is, StandardCharsets.UTF_8);
            Arrays.asList(fileContent.split("\n"))
                    .forEach(line -> maze.add(Arrays.asList(line.split(" "))));

            return maze;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return maze;
    }

}
