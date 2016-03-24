package com.whispon.number;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;



public class MainActivity extends AppCompatActivity {

    int[] hairetsu;

    String mondai;
    int seikai;
    TextView textView;
    TextView finishedText;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Timer timer;
    ProgressBar progressBar;
    int count;
    MyTiemrTask timerTask;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        start();
        buttonRandom();

        finishedText = (TextView)findViewById(R.id.finishedText);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        //プログレスバーの最大値の設定
        count = 20;
        progressBar.setMax(count);
        timer = new Timer();
        timerTask = new MyTiemrTask();

        timer.scheduleAtFixedRate(timerTask, 3 * 1000, 1 * 1000);
        Toast.makeText(this,"開始!!",Toast.LENGTH_SHORT).show();
        handler = new Handler();

    }

    public void start(){
        hairetsu = new int[4];
        Random rand = new Random();
        hairetsu[0] = rand.nextInt(4) + 1;
        hairetsu[1] = rand.nextInt(4) + 1;
        hairetsu[2] = rand.nextInt(4) + 1;
        hairetsu[3] = rand.nextInt(4) + 1;

        mondai =
                Integer.toString(hairetsu[0])
                + Integer.toString(hairetsu[1])
                + Integer.toString(hairetsu[2])
                + Integer.toString(hairetsu[3]);
        textView.setText(mondai);

        seikai = 0;
     }

    public void number1(View v){
        if(String.valueOf(hairetsu[seikai]) == button1.getText()){
            mondai = mondai.substring(1);
            textView.setText(mondai);
            seikai = seikai + 1;
            if(seikai == 4){
                start();
                buttonRandom();
            }
        }else {
            Toast.makeText(this,"数字が違う",Toast.LENGTH_SHORT).show();
        }
    }

    public void number2(View v){
        if(String.valueOf(hairetsu[seikai]) == button2.getText()){
            mondai = mondai.substring(1);
            textView.setText(mondai);
            seikai = seikai + 1;
            if(seikai == 4){
                start();
                buttonRandom();
            }
        }else {
            Toast.makeText(this,"数字が違う",Toast.LENGTH_SHORT).show();
        }
    }

    public void number3(View v){
        if(String.valueOf(hairetsu[seikai]) == button3.getText()){
            mondai = mondai.substring(1);
            textView.setText(mondai);
            seikai = seikai + 1;
            if(seikai == 4){
                start();
                buttonRandom();
            }
        }else {
            Toast.makeText(this,"数字が違う",Toast.LENGTH_SHORT).show();
        }
    }

    public void number4(View v){
        if(String.valueOf(hairetsu[seikai]) == button4.getText()){
            mondai = mondai.substring(1);
            textView.setText(mondai);
            seikai = seikai + 1;
            if(seikai == 4){
                start();
                buttonRandom();
            }
        }else {
            Toast.makeText(this,"数字が違う",Toast.LENGTH_SHORT).show();
        }
    }

    public void buttonRandom(){
        int[] bntNum = {1,2,3,4};
        int j,temp;
        Random rand = new Random();
        //Fiher-Yatesによるシャッフル処理
        for(int i = 4-1;i > 1;i --){
            j = rand.nextInt(i+1);
            temp = bntNum[j];
            bntNum[j] = bntNum[i];
            bntNum[i] = temp;
        }
        button1.setText(String.valueOf(bntNum[0]));
        button2.setText(String.valueOf(bntNum[1]));
        button3.setText(String.valueOf(bntNum[2]));
        button4.setText(String.valueOf(bntNum[3]));
    }

    class MyTiemrTask extends TimerTask{
        public void run(){
            handler.post(new Runnable() {
                @Override
                public void run() {
                    count --;
                    progressBar.setProgress(count);
                    if(count == 0){
                        finishedText.setText("終了!");
                        //ボタンを押しても反応しないようにする
                        button1.setEnabled(false);
                        button2.setEnabled(false);
                        button3.setEnabled(false);
                        button4.setEnabled(false);

                    }
                }
            });
        }

    }
}
