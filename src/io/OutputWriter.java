package io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Writes the algorithm solution passed in from an OutputData object to standard out.
 */
public class OutputWriter {

    BufferedWriter writer;

    public OutputWriter() {
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public void writeOutput(int iteration, OutputData outputData) throws IOException {
        writer.write(String.format("Scenario %d:", iteration));
        writer.newLine();
        writer.flush();

        String nameA = outputData.getPointA().getName();
        String nameB = outputData.getPointB().getName();
        if(nameA.compareTo(nameB) < 0) {
            writer.write(String.format("Closest pair: %s %s", nameA, nameB));
        } else {
            writer.write(String.format("Closest pair: %s %s", nameB, nameA));
        }
        writer.newLine();
        writer.flush();

        writer.write(String.format("Distance: %.1f", outputData.getDistance()));
        writer.newLine();
        writer.flush();
    }
}
