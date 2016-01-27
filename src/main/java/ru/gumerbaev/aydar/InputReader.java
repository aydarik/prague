package ru.gumerbaev.aydar;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads input data for array of strings.
 */
public class InputReader {

    public static List<String> read(String fileName) {
        List<String> result = new ArrayList<>();

        try {
            File file = new File(fileName);
            LineIterator iterator = FileUtils.lineIterator(file, "UTF-8");
            try {
                while (iterator.hasNext()) {
                    String line = iterator.nextLine();
                    result.add(line);
                }
            } finally {
                LineIterator.closeQuietly(iterator);
            }
        } catch (IOException e) {
            throw new RuntimeException(String.format("Can't find '%s' file with calculation instructions.", fileName));
        }

        return result;
    }
}
