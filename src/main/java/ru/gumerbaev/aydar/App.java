package ru.gumerbaev.aydar;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Application main class.
 */
public class App {

    public static void main(String[] args) {
        String inputFileName = args.length > 0 ? args[0] : "input.txt";

        // Reading input data.
        List<String> inputData = InputReader.read(inputFileName);

        // Calculating process.
        float result = new Calculator(inputData).calc();
        System.out.println(new DecimalFormat("#.##").format(result));
    }
}
