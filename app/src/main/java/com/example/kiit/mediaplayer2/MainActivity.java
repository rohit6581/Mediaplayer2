package com.example.kiit.mediaplayer2;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;
    SeekBar sk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sk=(findViewById(R.id.seekBar));
        mp =MediaPlayer.create(this,R.raw.song);
        sk.setMax(mp.getDuration());
        Thread t =new Thread() {
            public void run() {
                while (true) {
                    if (mp == null) {
                        sk.setProgress(0);
                    } else {
                        sk.setProgress(mp.getCurrentPosition());
                    }

                }

            }
        };
        sk.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mp.seekTo(progress);
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });
        t.start();

    }
    public void play(View view) {

        if (mp != null) {

            mp.start();
        } else {
            mp=MediaPlayer.create(this, R.raw.song);
            mp.start();

        }
    }

    public void stop(View view){
        if (mp ==null){
        }
        else
        {
            mp.stop();
            mp=null;
        }
         }

        public void pause(View view){
        if(mp==null){

        }else{
            mp.pause();
        }


    }
}
