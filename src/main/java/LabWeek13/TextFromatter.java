package LabWeek13;

interface TextFormatter{
    String formatText(String text);
}

class UpperCaseFormatter implements TextFormatter {
    @Override
    public String formatText(String text) {
        return text.toUpperCase();
    }
}

class LowerCaseFormatter implements TextFormatter {
    @Override
    public String formatText(String text) {
        return text.toLowerCase();
    }
}

class CamelCaseFormatter implements TextFormatter {
    @Override
    public String formatText(String text) {
        StringBuilder result = new StringBuilder();
        boolean capitalize = true;
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                capitalize = true;
            } else {
                result.append(capitalize ? Character.toUpperCase(c) : Character.toLowerCase(c));
                capitalize = false;
            }
        }
        return result.toString();
    }
}

class TextEditor {
    private TextFormatter formatter;

    public void setFormatter(TextFormatter formatter) {
        this.formatter = formatter;
    }

    public String formatText(String text) {
        if (formatter == null) {
            throw new IllegalStateException("TextFormatter is not set");
        }
        return formatter.formatText(text);
    }
}

class TextFromatter{
    public static void main(String[] args) {

        TextEditor editor = new TextEditor();

        editor.setFormatter(new UpperCaseFormatter());
        System.out.println("UpperCase: " + editor.formatText("hello world"));

        editor.setFormatter(new LowerCaseFormatter());
        System.out.println("LowerCase: " + editor.formatText("HELLO WORLD"));

        editor.setFormatter(new CamelCaseFormatter());
        System.out.println("CamelCase: " + editor.formatText("hello world"));
    }
}
