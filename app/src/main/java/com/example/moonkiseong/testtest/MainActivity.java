package com.example.moonkiseong.testtest;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int mCount = 0 ;
    Handler mHandler  = new Handler();
    TextView tvCount = null ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCount = (TextView) findViewById(R.id.Count);

        Thread countThread = new Thread("Count Thread")
        {

            public  void run(){

                for (int i = 0 ; i < 10 ; i ++)
                {
                    mCount++ ;
                    MainActivity.this.runOnUiThread(new Runnable()
                    {

                        @Override
                        public void run() {

                            Log.d("superdroid", "Count : " + mCount);
                            tvCount.setText("Conut : " + mCount);

                        }
                    });

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }

            }


        };


        countThread.start();

    }
}
