package adityamukherjee082006.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class SelectDifficulty extends AppCompatActivity implements View.OnClickListener {
    Button easy,medium,hard,impossible;
    ImageButton musicButton3;
    MediaPlayer music;
    static int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_difficulty);
        easy=findViewById(R.id.easy);
        easy.setOnClickListener(this);
        medium=findViewById(R.id.medium);
        medium.setOnClickListener(this);
        hard=findViewById(R.id.hard);
        hard.setOnClickListener(this);
        impossible=findViewById(R.id.impossible);
        impossible.setOnClickListener(this);
        musicButton3 = (ImageButton) findViewById(R.id.musicButton3);
        musicButton3.setOnClickListener(this);
        music = MediaPlayer.create(this, R.raw.music);
        music.seekTo(SelectPlayType.position);
        music.start();
        music.setLooping(true);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.musicButton3) {
            if (music.isPlaying()) {
                music.pause();
                musicButton3.setImageResource(R.drawable.sound_off);
            } else {
                music.start();
                musicButton3.setImageResource(R.drawable.sound_on);
            }
        }
        if(view.getId()==R.id.easy)
        {
            openSinglePlayer();
            music.stop();
            position = music.getCurrentPosition();
        }
        if(view.getId()==R.id.medium)
        {
            openSinglePlayer();
            music.stop();
            position = music.getCurrentPosition();
        }
        if(view.getId()==R.id.hard)
        {
            openSinglePlayer();
            music.stop();
            position = music.getCurrentPosition();
        }
        if(view.getId()==R.id.impossible)
        {
            openSinglePlayer();
            music.stop();
            position = music.getCurrentPosition();
        }
    }
    public void openSinglePlayer()
    {
        Intent intent=new Intent(this,SinglePlayer.class);
        startActivity(intent);
    }
}