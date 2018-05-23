package burakaytac.suresearch.model;

import java.util.ArrayList;

public class Option {
    String text;
    ArrayList<OptionParameter> optionParameters;

    public Option() {
        text = "";
        optionParameters = new ArrayList<>();
    }

    public Option(String text, ArrayList<OptionParameter> optionParameters) {
        this.text = text;
        this.optionParameters = optionParameters;
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
}
