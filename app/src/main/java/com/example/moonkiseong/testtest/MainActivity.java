package com.example.moonkiseong.testtest;

import android.app.Activity;
import android.os.Handler;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends Activity {
    int mCount = 0 ;
    Handler mHandler  = new Handler();
    TextView tvCount = null ;

        //***test
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
