package com.example.kritvinkomin.geoquiz_top;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button bCorrect , bFalse;
    TextView tvQuestion;
    private int mCurrentIndex = 0;
    private TrueFalse[] mQuestionBank = new TrueFalse[]{
            new TrueFalse(R.string.question1, false),
            new TrueFalse(R.string.question2, true),
            new TrueFalse(R.string.question3, false),
    };

    private void updateQuestion(){    //update the question
        mCurrentIndex = (mCurrentIndex + 1 ) % mQuestionBank.length; // increment through array
        int question = mQuestionBank[mCurrentIndex].getQuestion(); //get new textview question
        tvQuestion.setText(question);
    }
    public void checkAnswer(boolean userPressTrue){
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isTrueQuestion();  // check from array if answer is true
        if (userPressTrue == answerIsTrue){          //if onClick match the TF of the question
            Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();
            updateQuestion();
        }else{
            Toast.makeText(MainActivity.this, "NoCorrect", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvQuestion = (TextView)findViewById(R.id.tv1);

        bCorrect = (Button)findViewById(R.id.bCorrect);
        bCorrect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });
        bFalse = (Button)findViewById(R.id.bFalse);
        bFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
