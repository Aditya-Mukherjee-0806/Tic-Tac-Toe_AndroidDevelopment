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
        //links buttons to their xml ids and sets onClickListener
        playButton = (Button) findViewById(R.id.playButton);
        playButton.setOnClickListener(this);
        //links image to its xml id and sets onClickListener
        tictactoe = (ImageView) findViewById(R.id.TicTacToe_Image);
        //links musicButton to its xml id
        musicButton = (ImageButton) findViewById(R.id.musicButton);
        musicButton.setOnClickListener(this);
        //link music to mp3 and starts the music
        music = MediaPlayer.create(this, R.raw.music);
        music.start();
        music.setLooping(true);
    }

    @Override
    public void onClick(View view) {
        //checks if playButton is clicked and opens SelectPlayType
        if (view.getId() == R.id.playButton) {
            openSelectPlayType();
            music.stop();
            position = music.getCurrentPosition();
            musicButton.setImageResource(R.drawable.sound_off);
        }
        //checks if musicButton is clicked and starts or pauses music
        //if music is playing, it pauses it and changes the image to sound_off
        //if music is paused, it starts it and changes the image to sound_on
        //music is set to loop so it will continue to play after it finishes playing
        //music is set to start at the position it was at when it was paused
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