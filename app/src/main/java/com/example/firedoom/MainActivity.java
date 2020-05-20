package com.example.firedoom;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final MediaPlayer mPlayer = MediaPlayer.create(this, R.raw.soundtrack);


        final ImageButton imageButton = findViewById(R.id.imageB);

        ImageButton.OnClickListener onClickListener = new ImageButton.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (flag) {
                    imageButton.setBackgroundResource(R.drawable.doom_boy);
                    flag = false;
                    try{
                        mPlayer.start();
                    }catch (IllegalStateException e) {
                        mPlayer.pause();
                    }
                } else {
                    // возвращаем первую картинку
                    imageButton.setBackgroundResource(R.drawable.doom_transparent);
                    flag = true;
                    try{
                        mPlayer.pause();
                    }catch (IllegalStateException e) {
                        mPlayer.pause();
                    }
                }

            }
        };

        imageButton.setOnClickListener(onClickListener);

    }

}
