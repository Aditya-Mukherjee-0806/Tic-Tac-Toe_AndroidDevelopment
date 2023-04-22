package adityamukherjee082006.com;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class SinglePlayer extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    TextView singlePlayerText;
    ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player_page);
        //initializes and sets single player text to the selected difficulty level
        singlePlayerText = (TextView) findViewById(R.id.singleplayertext);
        singlePlayerText.setText(SelectDifficulty.difficultyLevel.getText());
        //link toggleButton to its xml id and sets OnCheckedChangeListener
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        toggleButton.setChecked(SelectDifficulty.toggleButton.isChecked());
        toggleButton.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        startService(new Intent(this, MusicService.class));
    }
}