package burakaytac.suresearch.model;

import java.util.ArrayList;
import java.util.Objects;

public class Option {
    String text;
    ArrayList<OptionParameter> optionParameters;
    Long id;

    public Option() {
        text = "";
        optionParameters = new ArrayList<>();
        generateRandomLongID();
    }

    public Option(String text, ArrayList<OptionParameter> optionParameters) {
        this.text = text;
        this.optionParameters = optionParameters;
        generateRandomLongID();
    }

    public void generateRandomLongID() {
        id = (long)(Math.random() * 10000000);
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<OptionParameter> getOptionParameters() {
        return optionParameters;
    }

    public void setOptionParameters(ArrayList<OptionParameter> optionParameters) {
        this.optionParameters = optionParameters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Option option = (Option) o;
        return Objects.equals(text, option.text) &&
                Objects.equals(optionParameters, option.optionParameters);
    }

    @Override
    public int hashCode() {

        return Objects.hash(text, optionParameters);
    }
}
