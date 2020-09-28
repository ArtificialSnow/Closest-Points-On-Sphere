package main;

import io.InputData;
import io.InputParser;
import io.OutputData;
import io.OutputWriter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputParser parser = new InputParser(reader);
        OutputWriter writer = new OutputWriter();

        int iteration = 1;
        while (true) {
            int numPoints = Integer.parseInt(reader.readLine().strip());
            if (numPoints == 0) {
                System.exit(0);
            }

            InputData inputData = parser.readInput(numPoints);

            ClosestPoints algorithm = new ClosestPoints();
            OutputData outputData = algorithm.findClosestPoints(inputData);
            writer.writeOutput(iteration, outputData);

            iteration++;
        }
    }
}
