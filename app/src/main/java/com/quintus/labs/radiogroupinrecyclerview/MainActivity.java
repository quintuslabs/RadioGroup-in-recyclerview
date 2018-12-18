package com.quintus.labs.radiogroupinrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.quintus.labs.radiogroupinrecyclerview.adapter.QuestionAdapter;
import com.quintus.labs.radiogroupinrecyclerview.model.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewQuestions;
    private List<Question> questions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewQuestions = findViewById(R.id.recycler_view_questions);
        prepareQuestions();
        initQuestionsAdapter();
    }

    private void prepareQuestions() {
        for (int i = 0; i < 50; i++) {
            Question question = new Question();

            question.id = i;
            question.question = "Question #" + (i + 1);
            question.optionA = "Option A";
            question.optionB = "Option B";
            question.optionC = "Option C";
            question.optionD = "Option D";
            question.correctOption = new Random().nextInt(3);
            question.answer = "Answer is: " + question.correctOption;

            questions.add(question);
        }
    }

    private void initQuestionsAdapter() {
        recyclerViewQuestions.setLayoutManager(new LinearLayoutManager(this));
        QuestionAdapter questionAdapter = new QuestionAdapter(this, questions);
        recyclerViewQuestions.setAdapter(questionAdapter);
    }

}
