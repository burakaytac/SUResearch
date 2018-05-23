package burakaytac.suresearch;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ExpandableListView;

import java.util.ArrayList;

import burakaytac.suresearch.model.Option;
import burakaytac.suresearch.model.Question;

public class QuestionEditActivity extends AppCompatActivity {

    private OptionParameterExpandableListAdapter optionParameterExpandableListAdapter;
    private Question question;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_edit);
        EditText questionTextField = findViewById(R.id.question_text);
        ExpandableListView optionList = findViewById(R.id.option_list);

        optionParameterExpandableListAdapter = new OptionParameterExpandableListAdapter(new ArrayList<Option>());
        optionList.setAdapter(optionParameterExpandableListAdapter);

        question = new Question();
        questionTextField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                question.setText(s.toString());
            }
        });
    }

    public void addOption(View v) {
        Option option = new Option();
        optionParameterExpandableListAdapter.addData(option);
    }
}
