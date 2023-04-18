package adityamukherjee082006.com;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MultiPlayer extends AppCompatActivity implements View.OnClickListener {
    TextView result;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    boolean b = true;
    boolean check;
    ImageButton musicButton2;
    MediaPlayer music;

    public static boolean gameOver(Button button1, Button button2, Button button3, Button button4,
                                   Button button5, Button button6, Button button7, Button button8,
                                   Button button9) {
        if (button1.getText().equals(""))
            return false;
        if (button2.getText().equals(""))
            return false;
        if (button3.getText().equals(""))
            return false;
        if (button4.getText().equals(""))
            return false;
        if (button5.getText().equals(""))
            return false;
        if (button6.getText().equals(""))
            return false;
        if (button7.getText().equals(""))
            return false;
        if (button8.getText().equals(""))
            return false;
        return !button9.getText().equals("");
    }

    public static boolean hasWinner(Button button1, Button button2, Button button3, Button button4,
                                    Button button5, Button button6, Button button7, Button button8,
                                    Button button9) {
        //checks rows
        if (button1.getText().equals(button2.getText()) && button2.getText().equals(button3.getText())
                && !button3.getText().equals(""))
            return true;
        else if (button4.getText().equals(button5.getText()) && button5.getText().equals(button6.getText())
                && !button6.getText().equals(""))
            return true;
        else if (button7.getText().equals(button8.getText()) && button8.getText().equals(button9.getText())
                && !button9.getText().equals(""))
            return true;
            //checks columns
        else if (button1.getText().equals(button4.getText()) && button4.getText().equals(button7.getText())
                && !button7.getText().equals(""))
            return true;
        else if (button2.getText().equals(button5.getText()) && button5.getText().equals(button8.getText())
                && !button8.getText().equals(""))
            return true;
        else if (button3.getText().equals(button6.getText()) && button6.getText().equals(button9.getText())
                && !button9.getText().equals(""))
            return true;
            //checks diagonals
        else if (button1.getText().equals(button5.getText()) && button5.getText().equals(button9.getText())
                && !button9.getText().equals(""))
            return true;
        else
            return button3.getText().equals(button5.getText()) && button5.getText().equals(button7.getText())
                    && !button7.getText().equals("");
    }

    public static String getWinner(Button button1, Button button2, Button button3, Button button4,
                                   Button button5, Button button6, Button button7, Button button8,
                                   Button button9) {
        //checks rows
        if (button1.getText().equals(button2.getText()) && button2.getText().equals(button3.getText())
                && !button3.getText().equals(""))
            return (String) button3.getText();
        else if (button4.getText().equals(button5.getText()) && button5.getText().equals(button6.getText())
                && !button6.getText().equals(""))
            return (String) button6.getText();
        else if (button7.getText().equals(button8.getText()) && button8.getText().equals(button9.getText())
                && !button9.getText().equals(""))
            return (String) button9.getText();
            //checks columns
        else if (button1.getText().equals(button4.getText()) && button4.getText().equals(button7.getText())
                && !button7.getText().equals(""))
            return (String) button7.getText();
        else if (button2.getText().equals(button5.getText()) && button5.getText().equals(button8.getText())
                && !button8.getText().equals(""))
            return (String) button8.getText();
        else if (button3.getText().equals(button6.getText()) && button6.getText().equals(button9.getText())
                && !button9.getText().equals(""))
            return (String) button9.getText();
            //checks diagonals
        else if (button1.getText().equals(button5.getText()) && button5.getText().equals(button9.getText())
                && !button9.getText().equals(""))
            return (String) button9.getText();
        else if (button3.getText().equals(button5.getText()) && button5.getText().equals(button7.getText())
                && !button7.getText().equals(""))
            return (String) button7.getText();
        return "";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_player);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);

        result = findViewById(R.id.textView);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        musicButton2 = (ImageButton) findViewById(R.id.musicButton2);
        musicButton2.setOnClickListener(this);
        music = MediaPlayer.create(this, R.raw.music);
        music.seekTo(SelectPlayType.position);
        music.start();
        music.setLooping(true);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.musicButton2) {
            if (music.isPlaying()) {
                music.pause();
                musicButton2.setImageResource(R.drawable.sound_off);
            } else {
                music.start();
                musicButton2.setImageResource(R.drawable.sound_on);
            }
        }
        if (check) {
            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);
            button5.setEnabled(false);
            button6.setEnabled(false);
            button7.setEnabled(false);
            button8.setEnabled(false);
            button9.setEnabled(false);
            return;
        }
        switch (view.getId()) {
            case R.id.button1:
                button1.setText(b ? "X" : "O");
                b = !b;
                button1.setEnabled(false);
                break;
            case R.id.button2:
                button2.setText(b ? "X" : "O");
                b = !b;
                button2.setEnabled(false);
                break;
            case R.id.button3:
                button3.setText(b ? "X" : "O");
                b = !b;
                button3.setEnabled(false);
                break;
            case R.id.button4:
                button4.setText(b ? "X" : "O");
                b = !b;
                button4.setEnabled(false);
                break;
            case R.id.button5:
                button5.setText(b ? "X" : "O");
                b = !b;
                button5.setEnabled(false);
                break;
            case R.id.button6:
                button6.setText(b ? "X" : "O");
                b = !b;
                button6.setEnabled(false);
                break;
            case R.id.button7:
                button7.setText(b ? "X" : "O");
                b = !b;
                button7.setEnabled(false);
                break;
            case R.id.button8:
                button8.setText(b ? "X" : "O");
                b = !b;
                button8.setEnabled(false);
                break;
            case R.id.button9:
                button9.setText(b ? "X" : "O");
                b = !b;
                button9.setEnabled(false);
                break;
        }
        if (hasWinner(button1, button2, button3, button4, button5, button6, button7, button8,
                button9)) {
            result.setText(getWinner(button1, button2, button3, button4, button5, button6, button7,
                    button8, button9) + " Wins!");
            check = true;
        } else if (gameOver(button1, button2, button3, button4, button5, button6, button7, button8,
                button9)) {
            result.setText("Game is a Draw");
        }
    }
}
