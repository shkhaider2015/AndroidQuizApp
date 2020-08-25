package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    List<DataModel> mDataList;
    int counter;
    int score;

    CardView mCardView;
    TextView mNumberOfQuestions, mQuestion, mTotalScore;
    Button mNext, mStartQuiz, mRestart;
    RadioGroup mRadioGroup;
    RadioButton mOpt1, mOpt2, mOpt3, mOpt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        prepareData();
    }

    private void init()
    {
        mCardView = findViewById(R.id.card_view);
        mNumberOfQuestions = findViewById(R.id.number_of_questions);
        mTotalScore = findViewById(R.id.totalscore);
        mQuestion = findViewById(R.id.question);
        mNext = findViewById(R.id.next);
        mStartQuiz = findViewById(R.id.start_quiz);
        mRestart = findViewById(R.id.restart);
        mRadioGroup = findViewById(R.id.radio_group);
        mOpt1 = findViewById(R.id.opt1);
        mOpt2 = findViewById(R.id.opt2);
        mOpt3 = findViewById(R.id.opt3);
        mOpt4 = findViewById(R.id.opt4);

        mStartQuiz.setOnClickListener(this);
        mNext.setOnClickListener(this);
        mRestart.setOnClickListener(this);

        mStartQuiz.setVisibility(View.VISIBLE);

        mCardView.setVisibility(View.GONE);
        mTotalScore.setVisibility(View.GONE);
        mRestart.setVisibility(View.GONE);

        counter = 0;
        score = 0;

    }
    private void prepareData()
    {
      DataModel q1 = new DataModel("What is 2 + 2 ?", "5", "13", "4", "22", "4");
      DataModel q2 = new DataModel("Android is Developed by", "Apple", "Google", "Microsoft", "Android Inc", "Android Inc");
      DataModel q3 = new DataModel("What is 3 + 2 ?", "5", "13", "4", "22", "5");
      DataModel q4 = new DataModel("What is 11 + 2 ?", "5", "13", "4", "22", "13");
      DataModel q5 = new DataModel("What is 13 + 7 ?", "5", "13", "20", "22", "20");

      mDataList = new ArrayList<>();
      mDataList.add(q1); mDataList.add(q2); mDataList.add(q3); mDataList.add(q4); mDataList.add(q5);
    }

    private void startQuiz()
    {
        mStartQuiz.setVisibility(View.GONE);
        mCardView.setVisibility(View.VISIBLE);
        updateQuiz();

    }
    private void updateQuiz()
    {
        if (counter > 4)
        {
            collectResult();
            return;
        }


        DataModel dataModel = mDataList.get(counter);

        mQuestion.setText(dataModel.getmQuestion());
        mOpt1.setText(dataModel.getmOptionOne());
        mOpt2.setText(dataModel.getmOptionTwo());
        mOpt3.setText(dataModel.getmOptionThree());
        mOpt4.setText(dataModel.getmOptionFour());

        String text = counter + 1 + "/5";
        mNumberOfQuestions.setText(text);

        if (counter == 4)
            mNext.setText(R.string.submit);
    }

    private void collectResult()
    {
        Toast.makeText(getApplicationContext(), score+"" , Toast.LENGTH_SHORT).show();
        mCardView.setVisibility(View.GONE);
        mTotalScore.setVisibility(View.VISIBLE);
        mRestart.setVisibility(View.VISIBLE);

        String text = "Total Score : " + score;
        mTotalScore.setText(text);

    }
    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.start_quiz:
                startQuiz();
                break;
            case R.id.next:
                if (!isButtonChecked())
                {
                    Toast.makeText(this, "Select Answer", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (getAnswer())
                    score+=1;
                counter++;
                updateQuiz();
                break;
            case R.id.restart:
                restart();
                break;
        }
    }

    private boolean getAnswer()
    {
        String answer = null;

        int selectedId = mRadioGroup.getCheckedRadioButtonId();

        switch (selectedId)
        {
            case R.id.opt1:
                //
                answer = mOpt1.getText().toString();
                break;
            case R.id.opt2:
                //
                answer = mOpt2.getText().toString();
                break;
            case R.id.opt3:
                //
                answer = mOpt3.getText().toString();
                break;
            case R.id.opt4:
                //
                answer = mOpt4.getText().toString();
                break;
        }

        return mDataList.get(counter).getmCorrectOption().equalsIgnoreCase(answer);

    }

    private boolean isButtonChecked()
    {
        return mOpt1.isChecked() || mOpt2.isChecked() || mOpt3.isChecked() || mOpt4.isChecked();
    }

    private void restart()
    {
        mRestart.setVisibility(View.GONE);
        mTotalScore.setVisibility(View.GONE);
        mStartQuiz.setVisibility(View.GONE);

        counter = 0;
        score = 0;

        mCardView.setVisibility(View.VISIBLE);
        updateQuiz();
    }
}