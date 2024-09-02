package ru.javacode.student;

public class StringBuilderWithUndo {

    private final StringBuilder builder = new StringBuilder();
    private String snapshot;

    public void save() {
        snapshot = builder.toString();
    }

    public void undo() {
        if (snapshot != null) {
            builder.delete(0, builder.length());
            builder.append(snapshot);
            // snapshot remains by design
        }
    }

    public int length() {
        return builder.length();
    }

    public StringBuilderWithUndo append(String string) {
        builder.append(string);
        return this;
    }

    public StringBuilderWithUndo delete(int start, int end) {
        builder.delete(start, end);
        return this;
    }

    public StringBuilderWithUndo insert(int offset, String string) {
        builder.insert(offset, string);
        return this;
    }

    @Override
    public String toString() {
        return builder.toString();
    }

    // Test
    public static void main(String[] args) {
        StringBuilderWithUndo builder = new StringBuilderWithUndo();

        builder.append("Java");
        builder.save();
        builder.append(" Code");

        System.out.println(builder);
        builder.undo();
        System.out.println(builder);
        builder.undo();
        System.out.println(builder);
    }


}
