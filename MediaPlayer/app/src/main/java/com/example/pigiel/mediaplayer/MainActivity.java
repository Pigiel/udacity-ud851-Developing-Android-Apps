package com.example.pigiel.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    private double startTime = 0;
    private double finalTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.closer);

        TextView titleTextView = (TextView) findViewById(R.id.song_title);
        titleTextView.setText("The Chainsmokers feat. Halsey - Closer");

        Button playButton = (Button) findViewById(R.id.play_button);
        playButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mediaPlayer.start();
                startTime = mediaPlayer.getCurrentPosition();
                finalTime = mediaPlayer.getDuration();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toast.makeText(MainActivity.this, "I'm done", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(MainActivity.this, "I'm done", Toast.LENGTH_SHORT).show();
            }
        });

        Button pauseButton = (Button) findViewById(R.id.pause_button);
        pauseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mediaPlayer.pause();
            }
        });

        Button previousButton = (Button) findViewById(R.id.previous_button);
        previousButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mediaPlayer.seekTo(0);
            }
        });

        Button forwardButton = (Button) findViewById(R.id.forward_button);
        forwardButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mediaPlayer.seekTo(mediaPlayer.getCurrentPosition() + 5000);
                Toast.makeText(getApplicationContext(), "+5 seconds forward", Toast.LENGTH_SHORT).show();
            }
        });

        Button backwardButton = (Button) findViewById(R.id.backward_button);
        backwardButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mediaPlayer.seekTo(mediaPlayer.getCurrentPosition() - 5000);
                Toast.makeText(getApplicationContext(), "-5 seconds backward", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
