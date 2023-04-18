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
        pvpButton = (Button) findViewById(R.id.pvpButton);
        pvcButton = (Button) findViewById(R.id.pvcButton);
        pvpButton.setOnClickListener(this);
        pvcButton.setOnClickListener(this);
        musicButton4 = (ImageButton) findViewById(R.id.musicButton4);
        musicButton4.setOnClickListener(this);
        music = MediaPlayer.create(this, R.raw.music);
        music.seekTo(Home.position);
        music.start();
        musicButton4.setImageResource(R.drawable.sound_on);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.musicButton4) {
            if (music.isPlaying()) {
                music.pause();
                musicButton4.setImageResource(R.drawable.sound_off);
            } else {
                music.start();
                musicButton4.setImageResource(R.drawable.sound_on);
            }
        }
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
        Intent intent = new Intent(this, MultiPlayer.class);
        startActivity(intent);
    }

    public void openSelectDifficulty() {
        Intent intent = new Intent(this, SelectDifficulty.class);
        startActivity(intent);
    }
}