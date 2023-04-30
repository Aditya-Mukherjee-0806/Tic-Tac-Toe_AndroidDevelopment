package adityamukherjee082006.com;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class SelectPlayType extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    static ToggleButton toggleButton;
    Button pvpButton;
    Button pvcButton;
    boolean isGoingToBackground = false;

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
        //initializes the toggle button
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        toggleButton.setChecked(Home.toggleButton.isChecked());
        toggleButton.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View view) {
        //if the button pressed is the pvp button, it opens the multi player activity
        //if the button pressed is the pvc button, it opens the select difficulty activity
        if (view.getId() == R.id.pvpButton)
            startActivity(new Intent(this, MultiPlayer.class));
        else if (view.getId() == R.id.pvcButton)
            startActivity(new Intent(this, SelectDifficulty.class));
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
        if (isTaskRoot())
            startService(new Intent(this, MusicService.class));
        else
            super.onBackPressed();
    }

    @Override
    protected void onStop() {
        super.onStop();
        // Check if the app is going to the background
        if (isGoingToBackground) {
            // App is going to the background (home button or recent apps button)
            startService(new Intent(this, MusicService.class));
        }
    }
}