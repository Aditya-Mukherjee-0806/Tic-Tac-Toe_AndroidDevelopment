package adityamukherjee082006.com;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SelectDifficulty extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    SeekBar seekBar;
    static TextView difficultyLevel;
    Button okButton;
    MediaPlayer music;
    ImageButton musicButton3;
    static int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_difficulty);

        musicButton3 = (ImageButton) findViewById(R.id.musicButton3);
        musicButton3.setOnClickListener(this);
        music = MediaPlayer.create(this, R.raw.music);
        music.seekTo(SelectPlayType.position);
        music.start();
        music.setLooping(true);
        //initializing seekbar along with the corresponding textview and button
        seekBar = findViewById(R.id.seekBarDiscrete);
        seekBar.setOnSeekBarChangeListener(this);
        difficultyLevel = findViewById(R.id.difficultyLevel);
        okButton = findViewById(R.id.okButton);
        okButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //if music is on then turn it off and vice versa
        if (view.getId() == R.id.musicButton3) {
            if (music.isPlaying()) {
                music.pause();
                musicButton3.setImageResource(R.drawable.sound_off);
            } else {
                music.start();
                musicButton3.setImageResource(R.drawable.sound_on);
            }
        }
        //if okButton is clicked then open the difficulty on seekbar
        if (view.getId() == R.id.okButton) {
            if (position == 0)
                openSinglePlayer();
            if (position == 1)
                openSinglePlayer();
            if (position == 2)
                openSinglePlayer();
            if (position == 3)
                openSinglePlayer();
        }
    }

    public void openSinglePlayer() {
        Intent intent = new Intent(this, SinglePlayer.class);
        startActivity(intent);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        if (i == 0)
            difficultyLevel.setText("Easy");
        if (i == 1)
            difficultyLevel.setText("Medium");
        if (i == 2)
            difficultyLevel.setText("Hard");
        if (i == 3)
            difficultyLevel.setText("Impossible");
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}