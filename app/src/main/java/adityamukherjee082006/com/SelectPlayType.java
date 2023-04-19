package adityamukherjee082006.com;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class SelectPlayType extends AppCompatActivity implements View.OnClickListener {
    static int position;
    Button pvpButton;
    Button pvcButton;
    ImageButton musicButton4;
    MediaPlayer music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_play_type);
        //links xml buttons to java buttons
        pvpButton = (Button) findViewById(R.id.pvpButton);
        pvcButton = (Button) findViewById(R.id.pvcButton);
        //makes the buttons detect clicks and calls the onClick method
        pvpButton.setOnClickListener(this);
        pvcButton.setOnClickListener(this);
        //links xml button to java button
        musicButton4 = (ImageButton) findViewById(R.id.musicButton4);
        //makes the button detect clicks and calls the onClick method
        musicButton4.setOnClickListener(this);
        //links music variable to mp3 file
        music = MediaPlayer.create(this, R.raw.music);
        music.seekTo(Home.position);
        music.start();
        //links sound on image to musicButton
        musicButton4.setImageResource(R.drawable.sound_on);
    }

    @Override
    public void onClick(View view) {
        //checks if the button pressed is the music button and if it is, it plays or pauses the music
        //if the music is playing, it changes the image to sound on and if it is paused, it changes the image to sound off
        if (view.getId() == R.id.musicButton4) {
            if (music.isPlaying()) {
                music.pause();
                musicButton4.setImageResource(R.drawable.sound_off);
            } else {
                music.start();
                musicButton4.setImageResource(R.drawable.sound_on);
            }
        }
        //if the button pressed is the pvp button, it opens the multi player activity
        //if the button pressed is the pvc button, it opens the select difficulty activity
        //the music stops when the activity is closed
        if (view.getId() == R.id.pvpButton) {
            openMultiPlayer();
            music.stop();
            position = music.getCurrentPosition();
            musicButton4.setImageResource(R.drawable.sound_off);
        } else if (view.getId() == R.id.pvcButton) {
            openSelectDifficulty();
            music.stop();
            position = music.getCurrentPosition();
            musicButton4.setImageResource(R.drawable.sound_off);
        }
    }

    public void openMultiPlayer() {
        //opens multiplayer page
        Intent intent = new Intent(this, MultiPlayer.class);
        startActivity(intent);
    }

    public void openSelectDifficulty() {
        //opens select difficulty page
        Intent intent = new Intent(this, SelectDifficulty.class);
        startActivity(intent);
    }
}