package burakaytac.suresearch.model;

import java.util.ArrayList;
import java.util.Objects;

public class Question {
    private ArrayList<Option> options = new ArrayList<>();
    private String text;
    long id;

    public Question() {
        generateRandomLongID();
    }


    public Question(String text) {
        this.text = text;
        generateRandomLongID();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void generateRandomLongID() {
        id = (long)(Math.random() * 10000000);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(text, question.text);
    }

    @Override
    public int hashCode() {

        return Objects.hash(text);
    }

    public long getId() {
        return id;
    }

    public Question(ArrayList<Option> options, String text, long id) {
        this.options = options;
        this.text = text;
        this.id = id;
    }

    public ArrayList<Option> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<Option> options) {
        this.options = options;
    }

}
