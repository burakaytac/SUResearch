package burakaytac.suresearch.model;

public class OptionParameter {
    String text, input, defaultValue;

    public OptionParameter() {
    }

    public OptionParameter(String text, String input, String defaultValue) {
        this.text = text;
        this.input = input;
        this.defaultValue = defaultValue;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }
}
