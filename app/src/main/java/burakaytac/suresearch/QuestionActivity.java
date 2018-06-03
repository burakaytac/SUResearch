package burakaytac.suresearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

import burakaytac.suresearch.model.Question;

public class QuestionActivity extends AppCompatActivity {

    RecyclerView questionList;
    QuestionRecyclerAdapter questionRecyclerAdapter;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        setupRecyclerView();
        fetchQuestions();
    }

    private void setupRecyclerView() {
        questionList = findViewById(R.id.question_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        questionList.setLayoutManager(linearLayoutManager);

        questionRecyclerAdapter = new QuestionRecyclerAdapter(new ArrayList<Question>());
        questionList.setAdapter(questionRecyclerAdapter);
    }

    private void fetchQuestions() {
        db.collection("questions")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        ArrayList<Question> questions = new ArrayList<>();

                        for (DocumentSnapshot document : task.getResult()) {
                            questions.add(document.toObject(Question.class));
                        }

                        questionRecyclerAdapter.setData(questions);
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.refresh:
                fetchQuestions();
            default:
                return super.onOptionsItemSelected(item);
        }

    }

     public void addQuestion(View v) {
         Intent intent = new Intent(this, QuestionEditActivity.class);
         startActivity(intent);
     }

}