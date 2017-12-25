package com.example.harsharora.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button startButton;
    Button button0;
    Button button1;
    Button button2;
    Button button3 ;
    Button playAgain;
    RelativeLayout relLayout;
    TextView result;
    TextView points;
    TextView sumTextview;
    TextView timer;
    GridLayout gridLayout;
    ArrayList<Integer> answers=new ArrayList<Integer>();
    int correctLocation;
    int score=0;
    int nQues=0;
    public void playAgain(View view)
    {
       score=0;
        nQues=0;
        timer.setText("30s");
        points.setText("0/0");
        result.setText("");
        playAgain.setVisibility(View.INVISIBLE);
        gridLayout.setVisibility(View.VISIBLE);
        generateQues();

        new CountDownTimer(30100,1000)

    {

        @Override
        public void onTick(long millisUntilFinished)
        {
            timer.setText(String.valueOf(millisUntilFinished/1000));
        }

        @Override
        public void onFinish() {
            playAgain.setVisibility(View.VISIBLE);
            result.setText("Your Score is "+Integer.toString(score)+"/"+Integer.toString(nQues));
            timer.setText("0s");
            gridLayout.setVisibility(View.INVISIBLE);

        }
    }.start();

    }
    public void generateQues()
    {
        Random rand=new Random();
        int a = rand.nextInt(41);
        int b = rand.nextInt(41);


        sumTextview.setText(Integer.toString(a)+ "+"+Integer.toString(b));
        correctLocation=rand.nextInt(4);
        answers.clear();

        int incorrectAnswer;
        for (int i=0;i<4;i++)
        {
            if (i==correctLocation)
                answers.add(a+b);
            else {
                incorrectAnswer = rand.nextInt(81);
                while (incorrectAnswer == a + b) {
                    incorrectAnswer = rand.nextInt(81);
                }

                answers.add(incorrectAnswer);
            }
        }
        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));
    }

    public void chooseAnswer (View view)
    {   nQues++;
        if (view.getTag().toString().equals(Integer.toString(correctLocation)))
        {score++;

        result.setText("Correct!");
         points.setText(Integer.toString(score)+"/"+Integer.toString(nQues));
            generateQues();
         }
         else
        {
         result.setText("Wrong!");
            generateQues();
            points.setText(Integer.toString(score)+"/"+Integer.toString(nQues));

        }


    }
    public void start (View view)
    {
        startButton.setVisibility(View.INVISIBLE);
        relLayout.setVisibility(View.VISIBLE);
        playAgain(findViewById(R.id.playAgainButton));//calls The function



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton=(Button) findViewById(R.id.startButton);
         button0=(Button)findViewById(R.id.button0);
         button1=(Button)findViewById(R.id.button1);
         button2=(Button)findViewById(R.id.button2);
         button3=(Button)findViewById(R.id.button3);
        result=(TextView)findViewById(R.id.resultTextView);
        points=(TextView)findViewById(R.id.pointsTextView);
        sumTextview= (TextView) findViewById(R.id.sumTextView);
        startButton = (Button) findViewById(R.id.startButton);
         timer=(TextView)findViewById(R.id.timerTextView);
        playAgain=(Button)findViewById(R.id.playAgainButton);
        relLayout=(RelativeLayout)findViewById(R.id.relLayout);
        gridLayout=(GridLayout)findViewById(R.id.gridLayout);





    }
}
