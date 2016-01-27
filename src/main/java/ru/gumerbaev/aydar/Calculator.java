package ru.gumerbaev.aydar;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Stores the instructions and initializes calculation process.
 */
public class Calculator {
    private static Logger LOG = Logger.getLogger(Calculator.class);

    private List<Instruction> instructions = new ArrayList<>();

    public Calculator(List<String> inputData) {
        Iterator<String> iterator = inputData.listIterator();
        while (iterator.hasNext()) {
            if (addInstruction(iterator.next()) && iterator.hasNext()) {
                LOG.warn("'APPLY' command were received. Next rows will be ignored.");
                break;
            }
        }
        LOG.info("Instructions loaded successfully.");
    }

    /**
     * Create single instruction from input line and put it to instructions list.
     *
     * @param line input line
     * @return <strong>true</strong> - if instruction contains 'APPLY' command
     * (means that calculator initialization done).
     */
    private boolean addInstruction(String line) {
        LOG.debug("New instruction: " + line);
        Instruction instruction = new Instruction(line);
        instructions.add(instruction);
        return instruction.isLast();
    }

    /**
     * Calculate all available instructions.
     * @return result of calculation.
     */
    public float calc() {
        if (instructions.isEmpty()) {
            throw new RuntimeException("No instructions - nothing to solve.");
        }

        LOG.debug("Getting 'APPLY' instruction...");
        Instruction last = instructions.get(instructions.size() - 1);
        if (!last.isLast()) {
            throw new RuntimeException("No initial value found. 'APPLY' command must be defined.");
        }

        LOG.debug("Calculating...");
        float result = last.getNumber();
        for (Instruction instruction : instructions) {
            result = instruction.apply(result);
        }

        return result;
    }
}
