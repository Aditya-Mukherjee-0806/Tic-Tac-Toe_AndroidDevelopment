package adityamukherjee082006.com;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    static ToggleButton toggleButton;
    Button playButton;
    boolean isGoingToBackground = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //starts music service
        startService(new Intent(this, MusicService.class));
        //links buttons to their xml ids and sets OnClickListener
        playButton = (Button) findViewById(R.id.playButton);
        playButton.setOnClickListener(this);
        //link toggleButton to its xml id and sets OnCheckedChangeListener
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        toggleButton.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View view) {
        //checks if playButton is clicked and opens SelectPlayType
        if (view.getId() == R.id.playButton)
            startActivity(new Intent(this, SelectPlayType.class));
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        startService(new Intent(this, MusicService.class));
    }

    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        // User has left the app
        //isGoingToBackground = true;
    }

    public void onBackPressed() {
        if (isTaskRoot()) {
            startService(new Intent(this, MusicService.class));
            finish();
        } else
            super.onBackPressed();
    }

    @Override
    protected void onStop() {
        // Check if the app is going to the background
        super.onStop();
        if (isGoingToBackground) {
            // App is going to the background (home button or recent apps button)
            startService(new Intent(this, MusicService.class));
        }
    }
//    @Override
//    public void onRestart() {
//        super.onRestart();
//        startService(new Intent(this, MusicService.class));
//        isGoingToBackground = false;
//    }
}