package io;

import main.Point;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Reads input from standard in and returns an InputData object.
 */
public class InputParser {
    BufferedReader reader;
    StringTokenizer tokenizer;

    public InputParser(BufferedReader reader) {
        this.reader = reader;
    }

    public InputData readInput(int numPoints) throws IOException {
        Point[] pointsByLatitude = new Point[numPoints];
        Point[] pointsByLatitudeCopy = new Point[numPoints];

        for (int i = 0; i < numPoints; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            StringBuilder name = new StringBuilder(tokenizer.nextToken());

            while (tokenizer.countTokens() > 2) {
                name.append(" ").append(tokenizer.nextToken());
            }

            double latitude = Double.parseDouble(tokenizer.nextToken());
            double longitude = Double.parseDouble(tokenizer.nextToken());
            pointsByLatitude[i] = new Point(name.toString(), latitude, longitude);
        }

        Arrays.sort(pointsByLatitude, Comparator.comparingDouble(Point::getLatitude));
        System.arraycopy(pointsByLatitude, 0, pointsByLatitudeCopy, 0, numPoints);

        return new InputData(numPoints, pointsByLatitude, pointsByLatitudeCopy);
    }
}
