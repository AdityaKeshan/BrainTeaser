package com.example.brainteaser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.gridlayout.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button go,button,button1,button2,button3,playagain;
    char d[];
    TextView ques,timer,score,result,rec;
    GridLayout griddy;
    int k;
    public void kos(View v)
    {
        go.setVisibility(View.VISIBLE);
        playagain.setVisibility(View.INVISIBLE);
        rec.setVisibility(View.INVISIBLE);
    }
    public void checker(View v)
    {
        try {
            String tag = (String) v.getTag();
            if (tag.equals(Integer.toString(k))) {
                result.setText("Correct!");
                String k = score.getText().toString();
                int a = Integer.valueOf(k.substring(0, k.indexOf('/')).trim());
                int b = Integer.valueOf(k.substring(k.indexOf('/') + 1).trim());
                a++;
                b++;
                Log.i("the tag is:",Integer.toString(a)+" "+Integer.toString(b));
                score.setText(Integer.toString(a) + " / " + b);
            } else {
                result.setText("Incorrect!");
                String k = score.getText().toString();
                int a = Integer.valueOf(k.substring(0, k.indexOf('/')).trim());
                int b = Integer.valueOf(k.substring(k.indexOf('/') + 1).trim());
                b++;
                score.setText(Integer.toString(a) + " / " + b);
            }
            generateQuestion();
        }
        catch(Exception e)
        {
            Log.i("error is:",e.getMessage());
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            go = (Button) findViewById(R.id.go);
            button = (Button) findViewById(R.id.button);
            button1 = (Button) findViewById(R.id.button1);
            button2 = (Button) findViewById(R.id.button2);
            button3 = (Button) findViewById(R.id.button3);
            d = new char[]{'+', '-', '*', '/'};
            playagain = (Button) findViewById(R.id.playagain);
            ques = (TextView) findViewById(R.id.ques);
            timer = (TextView) findViewById(R.id.timer);
            score = (TextView) findViewById(R.id.score);
            result = (TextView) findViewById(R.id.result);
            rec=(TextView)findViewById(R.id.rec);
            griddy = (GridLayout) findViewById(R.id.griddy);
            griddy.setVisibility(View.INVISIBLE);
            timer.setVisibility(View.INVISIBLE);
            score.setVisibility(View.INVISIBLE);
            playagain.setVisibility(View.INVISIBLE);
            ques.setVisibility(View.INVISIBLE);
            rec.setVisibility(View.INVISIBLE);
        }
        catch(Exception e)
        {
            Log.i("The error is:",e.getMessage());
        }
    }
    public int akk(int a,int b,char ch)
    {
        switch(ch)
        {
            case '+':return (a+b);
            case '-':return (a-b);
            case '*':return (a*b);
            case '/':return (a/b);
        }
        return 0;
    }
    public void generateQuestion()
    {
        Random ob=new Random();
        int a =ob.nextInt(100)+1;
        int b =ob.nextInt(100)+1;
        int c =ob.nextInt(2)+1;
        ques.setText(Integer.toString(a)+" "+d[c]+" "+Integer.toString(b));
        int de=akk(a,b,d[c]);
        int e=ob.nextInt(4)+1;
        if(e==1) {
            button.setText(Integer.toString(de));
            a = ob.nextInt(100) + 1;
            button1.setText(Integer.toString(a));
            a = ob.nextInt(100) + 1;
            button2.setText(Integer.toString(a));
            a = ob.nextInt(100) + 1;
            button3.setText(Integer.toString(a));
        }
        else if(e==2) {
            button1.setText(Integer.toString(de));
            a = ob.nextInt(100) + 1;
            button.setText(Integer.toString(a));
            a = ob.nextInt(100) + 1;
            button2.setText(Integer.toString(a));
            a = ob.nextInt(100) + 1;
            button3.setText(Integer.toString(a));
        }
        else if(e==3) {
            button2.setText(Integer.toString(de));
            a = ob.nextInt(100) + 1;
            button1.setText(Integer.toString(a));
            a = ob.nextInt(100) + 1;
            button.setText(Integer.toString(a));
            a = ob.nextInt(100) + 1;
            button3.setText(Integer.toString(a));
        }
        else if(e==4) {
            button3.setText(Integer.toString(de));
            a = ob.nextInt(100) + 1;
            button1.setText(Integer.toString(a));
            a = ob.nextInt(100) + 1;
            button2.setText(Integer.toString(a));
            a = ob.nextInt(100) + 1;
            button.setText(Integer.toString(a));
        }
        k=e;
    }
    public void start(View v)
    {
        try {
            score.setText("0/0");
            timer.setText("30s");
            go.setVisibility(View.INVISIBLE);
            griddy.setVisibility(View.VISIBLE);
            timer.setVisibility(View.VISIBLE);
            score.setVisibility(View.VISIBLE);
            ques.setVisibility(View.VISIBLE);
            result.setText("");
            result.setVisibility(View.VISIBLE);
            generateQuestion();
            CountDownTimer countDownTimer = new CountDownTimer(30000, 1000) {

                @Override
                public void onTick(long millis) {

                    timer.setText(Long.toString(millis / 1000) + "s");

                }

                @Override
                public void onFinish() {
                    griddy.setVisibility(View.INVISIBLE);
                    timer.setVisibility(View.INVISIBLE);
                    rec.setVisibility(View.VISIBLE);
                    rec.setText(score.getText());
                    ques.setVisibility(View.INVISIBLE);
                    playagain.setVisibility(View.VISIBLE);
                    score.setVisibility(View.INVISIBLE);
                    result.setVisibility(View.INVISIBLE);
                }
            }.start();
        }
        catch (Exception e)
        {
            Log.i("the error is:",e.getMessage());
        }
    }
}
