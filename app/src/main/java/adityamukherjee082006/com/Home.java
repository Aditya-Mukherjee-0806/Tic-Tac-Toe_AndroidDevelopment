package adityamukherjee082006.com;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity implements View.OnClickListener {
    static int position;
    Button playButton;
    ImageView tictactoe;
    MediaPlayer music;
    ImageButton musicButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        playButton = (Button) findViewById(R.id.playButton);
        playButton.setOnClickListener(this);
        tictactoe = (ImageView) findViewById(R.id.TicTacToe_Image);
        musicButton = (ImageButton) findViewById(R.id.musicButton);
        musicButton.setOnClickListener(this);
        music = MediaPlayer.create(this, R.raw.music);
        music.start();
        music.setLooping(true);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.playButton) {
            openSelectPlayType();
            music.stop();
            position = music.getCurrentPosition();
            musicButton.setImageResource(R.drawable.sound_off);
        }
        if (view.getId() == R.id.musicButton) {
            if (music.isPlaying()) {
                music.pause();
                musicButton.setImageResource(R.drawable.sound_off);
            } else {
                music.start();
                musicButton.setImageResource(R.drawable.sound_on);
            }
        }
    }

    public void openSelectPlayType() {
        Intent intent = new Intent(this, SelectPlayType.class);
        startActivity(intent);
    }
}