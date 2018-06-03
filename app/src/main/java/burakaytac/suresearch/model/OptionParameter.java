package burakaytac.suresearch.model;

import java.util.Objects;

public class OptionParameter {
    String text, input, defaultValue;
    long id;

    public OptionParameter() {
    }

    public OptionParameter(String text, String input, String defaultValue) {
        this.text = text;
        this.input = input;
        this.defaultValue = defaultValue;
        generateRandomLongID();
    }

    public void generateRandomLongID() {
        id = (long)(Math.random() * 10000000);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OptionParameter that = (OptionParameter) o;
        return Objects.equals(text, that.text) &&
                Objects.equals(input, that.input) &&
                Objects.equals(defaultValue, that.defaultValue);
    }

    @Override
    public int hashCode() {

        return Objects.hash(text, input, defaultValue);
    }

    public long getId() {
        return id;
    }
}
