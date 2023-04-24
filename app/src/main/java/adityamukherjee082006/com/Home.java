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
}