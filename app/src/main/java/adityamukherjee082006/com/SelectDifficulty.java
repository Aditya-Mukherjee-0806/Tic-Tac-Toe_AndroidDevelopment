package adityamukherjee082006.com;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class SelectDifficulty extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, CompoundButton.OnCheckedChangeListener {
    static TextView difficultyLevel;
    static int position;
    static ToggleButton toggleButton;
    SeekBar seekBar;
    Button okButton;
    boolean isGoingToBackground = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_difficulty);
        //initializing seekbar along with the corresponding textview and button
        seekBar = findViewById(R.id.seekBarDiscrete);
        seekBar.setOnSeekBarChangeListener(this);
        difficultyLevel = findViewById(R.id.difficultyLevel);
        okButton = findViewById(R.id.okButton);
        okButton.setOnClickListener(this);
        //link toggleButton to its xml id and sets OnCheckedChangeListener
        toggleButton = findViewById(R.id.toggleButton);
        toggleButton.setChecked(SelectPlayType.toggleButton.isChecked());
        toggleButton.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View view) {
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