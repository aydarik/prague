package ru.gumerbaev.aydar;

/**
 * Instructions in an intelligible form.
 */
public class Instruction {

    private enum Operation {
        ADD, MULTIPLY, DIVIDE, SUBTRACT, APPLY
    }

    private Operation operation;
    private float number;

    public Instruction(String line) {
        String[] parts = line.split(" ");
        if (parts.length != 2) {
            throw new RuntimeException(String.format("Line '%s' is not valid instruction.", line));
        }

        this.operation = Operation.valueOf(parts[0].toUpperCase());
        this.number = Float.valueOf(parts[1]);
    }

    /**
     * Apply current instruction to last value.
     *
     * @param in number to apply instruction
     * @return calculation result.
     */
    public float apply(float in) {
        switch (operation) {
            case ADD:
                return in + number;
            case SUBTRACT:
                return in - number;
            case MULTIPLY:
                return in * number;
            case DIVIDE:
                return in / number;
            default:
                return in; // do nothing
        }
    }

    /**
     * Check the instruction is last (contains 'APPLY' command).
     *
     * @return <strong>true</strong> - if the instruction is really last;<br>
     * <strong>false</strong> - otherwise.
     */
    public boolean isLast() {
        return Operation.APPLY.equals(operation);
    }

    public float getNumber() {
        return number;
    }
}
