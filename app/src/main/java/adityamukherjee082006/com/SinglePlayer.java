package adityamukherjee082006.com;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SinglePlayer extends AppCompatActivity implements View.OnClickListener {
    TextView singleplayertext;
    ImageButton musicButton5;
    MediaPlayer music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player_page);
        singleplayertext = (TextView) findViewById(R.id.singleplayertext);
        musicButton5 = (ImageButton) findViewById(R.id.musicButton5);
        musicButton5.setOnClickListener(this);
        music = MediaPlayer.create(this, R.raw.music);
        music.seekTo(SelectDifficulty.position);
        music.start();
        music.setLooping(true);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.musicButton5) {
            if (music.isPlaying()) {
                music.pause();
                musicButton5.setImageResource(R.drawable.sound_off);
            } else {
                music.start();
                musicButton5.setImageResource(R.drawable.sound_on);
            }
        }
    }
}