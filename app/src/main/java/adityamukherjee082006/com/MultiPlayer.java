package adityamukherjee082006.com;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MultiPlayer extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    static TextView result;
    static char[] input = new char[9];
    static ToggleButton toggleButton;
    static boolean turn = true;
    ImageButton imageButton1;
    ImageButton imageButton2;
    ImageButton imageButton3;
    ImageButton imageButton4;
    ImageButton imageButton5;
    ImageButton imageButton6;
    ImageButton imageButton7;
    ImageButton imageButton8;
    ImageButton imageButton9;
    Button reset;
    ImageButton backHome;
    boolean isGoingToBackground = false;

    public static void resetGame(ImageButton imageButton1, ImageButton imageButton2, ImageButton imageButton3,
                                 ImageButton imageButton4, ImageButton imageButton5, ImageButton imageButton6,
                                 ImageButton imageButton7, ImageButton imageButton8, ImageButton imageButton9) {
        imageButton1.setImageResource(R.drawable.empty_image);
        imageButton1.setEnabled(true);
        imageButton2.setImageResource(R.drawable.empty_image);
        imageButton2.setEnabled(true);
        imageButton3.setImageResource(R.drawable.empty_image);
        imageButton3.setEnabled(true);
        imageButton4.setImageResource(R.drawable.empty_image);
        imageButton4.setEnabled(true);
        imageButton5.setImageResource(R.drawable.empty_image);
        imageButton5.setEnabled(true);
        imageButton6.setImageResource(R.drawable.empty_image);
        imageButton6.setEnabled(true);
        imageButton7.setImageResource(R.drawable.empty_image);
        imageButton7.setEnabled(true);
        imageButton8.setImageResource(R.drawable.empty_image);
        imageButton8.setEnabled(true);
        imageButton9.setImageResource(R.drawable.empty_image);
        imageButton9.setEnabled(true);
        for (int i = 0; i < 9; i++)
            input[i] = ' ';
        result.setText("");
        turn = true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_player);
        imageButton1 = (ImageButton) findViewById(R.id.imageButton1);
        imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        imageButton3 = (ImageButton) findViewById(R.id.imageButton3);
        imageButton4 = (ImageButton) findViewById(R.id.imageButton4);
        imageButton5 = (ImageButton) findViewById(R.id.imageButton5);
        imageButton6 = (ImageButton) findViewById(R.id.imageButton6);
        imageButton7 = (ImageButton) findViewById(R.id.imageButton7);
        imageButton8 = (ImageButton) findViewById(R.id.imageButton8);
        imageButton9 = (ImageButton) findViewById(R.id.imageButton9);

        imageButton1.setOnClickListener(this);
        imageButton2.setOnClickListener(this);
        imageButton3.setOnClickListener(this);
        imageButton4.setOnClickListener(this);
        imageButton5.setOnClickListener(this);
        imageButton6.setOnClickListener(this);
        imageButton7.setOnClickListener(this);
        imageButton8.setOnClickListener(this);
        imageButton9.setOnClickListener(this);

        reset = (Button) findViewById(R.id.reset);
        reset.setOnClickListener(this);
        backHome = (ImageButton) findViewById(R.id.back_home_button);
        backHome.setOnClickListener(this);
        result = findViewById(R.id.textView);
        //link toggleButton to its xml id and sets OnCheckedChangeListener
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        toggleButton.setChecked(SelectPlayType.toggleButton.isChecked());
        toggleButton.setOnCheckedChangeListener(this);
        for (int i = 0; i < 9; i++)
            input[i] = ' ';
    }

    @Override
    public void onClick(View view) {
        //checks which button was pressed, changes image to X or O, and makes the button disabled
        switch (view.getId()) {
            case R.id.imageButton1:
                imageButton1.setImageResource(turn ? R.drawable.x : R.drawable.o);
                input[0] = turn ? 'x' : 'o';
                turn = !turn;
                imageButton1.setEnabled(false);
                break;
            case R.id.imageButton2:
                imageButton2.setImageResource(turn ? R.drawable.x : R.drawable.o);
                input[1] = turn ? 'x' : 'o';
                turn = !turn;
                imageButton2.setEnabled(false);
                break;
            case R.id.imageButton3:
                imageButton3.setImageResource(turn ? R.drawable.x : R.drawable.o);
                input[2] = turn ? 'x' : 'o';
                turn = !turn;
                imageButton3.setEnabled(false);
                break;
            case R.id.imageButton4:
                imageButton4.setImageResource(turn ? R.drawable.x : R.drawable.o);
                input[3] = turn ? 'x' : 'o';
                turn = !turn;
                imageButton4.setEnabled(false);
                break;
            case R.id.imageButton5:
                imageButton5.setImageResource(turn ? R.drawable.x : R.drawable.o);
                input[4] = turn ? 'x' : 'o';
                turn = !turn;
                imageButton5.setEnabled(false);
                break;
            case R.id.imageButton6:
                imageButton6.setImageResource(turn ? R.drawable.x : R.drawable.o);
                input[5] = turn ? 'x' : 'o';
                turn = !turn;
                imageButton6.setEnabled(false);
                break;
            case R.id.imageButton7:
                imageButton7.setImageResource(turn ? R.drawable.x : R.drawable.o);
                input[6] = turn ? 'x' : 'o';
                turn = !turn;
                imageButton7.setEnabled(false);
                break;
            case R.id.imageButton8:
                imageButton8.setImageResource(turn ? R.drawable.x : R.drawable.o);
                input[7] = turn ? 'x' : 'o';
                turn = !turn;
                imageButton8.setEnabled(false);
                break;
            case R.id.imageButton9:
                imageButton9.setImageResource(turn ? R.drawable.x : R.drawable.o);
                input[8] = turn ? 'x' : 'o';
                turn = !turn;
                imageButton9.setEnabled(false);
                break;
            case R.id.reset:
                resetGame(imageButton1, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6, imageButton7, imageButton8, imageButton9);
                break;
            case R.id.back_home_button:
                startService(new Intent(this, MusicService.class));
                startActivity(new Intent(this, Home.class));
        }
        if (getWinner(input) == 'x') {
            result.setText("X Wins!");
            disableButtons();
        } else if (getWinner(input) == 'o') {
            result.setText("O Wins!");
            disableButtons();
        } else draw(input);
    }

    public char getWinner(char[] input) {
        //checks rows
        if (input[0] == input[1] && input[1] == input[2])
            return input[0];
        if (input[3] == input[4] && input[4] == input[5])
            return input[3];
        if (input[6] == input[7] && input[7] == input[8])
            return input[6];
        //checks columns
        if (input[0] == input[3] && input[3] == input[6])
            return input[0];
        if (input[1] == input[4] && input[4] == input[7])
            return input[1];
        if (input[2] == input[5] && input[5] == input[8])
            return input[2];
        //checks diagonals
        if (input[0] == input[4] && input[4] == input[8])
            return input[0];
        if (input[2] == input[4] && input[4] == input[6])
            return input[2];
        return ' ';
    }

    public void draw(char[] input) {
        if (input[0] != ' ' && input[1] != ' ' && input[2] != ' ' && input[3] != ' ' && input[4] != ' ' && input[5] != ' ' && input[6] != ' ' && input[7] != ' ' && input[8] != ' ')
            result.setText("Draw!");
    }

    public void disableButtons() {
        imageButton1.setEnabled(false);
        imageButton2.setEnabled(false);
        imageButton3.setEnabled(false);
        imageButton4.setEnabled(false);
        imageButton5.setEnabled(false);
        imageButton6.setEnabled(false);
        imageButton7.setEnabled(false);
        imageButton8.setEnabled(false);
        imageButton9.setEnabled(false);
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