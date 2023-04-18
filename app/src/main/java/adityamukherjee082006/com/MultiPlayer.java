package adityamukherjee082006.com;

import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MultiPlayer extends AppCompatActivity implements View.OnClickListener {
    static ImageButton emptyImage;
    TextView result;
    ImageButton imageButton1;
    ImageButton imageButton2;
    ImageButton imageButton3;
    ImageButton imageButton4;
    ImageButton imageButton5;
    ImageButton imageButton6;
    ImageButton imageButton7;
    ImageButton imageButton8;
    ImageButton imageButton9;
    boolean b = true;
    boolean check;
    ImageButton musicButton2;
    MediaPlayer music;

    public static boolean hasWinner(ImageButton imageButton1, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4,
                                    ImageButton imageButton5, ImageButton imageButton6, ImageButton imageButton7, ImageButton imageButton8,
                                    ImageButton imageButton9) {
        //checks rows
        if (imageButton1.getDrawable().equals(imageButton2.getDrawable()) && imageButton2.getDrawable().equals(imageButton3.getDrawable())
                && !imageButton3.getDrawable().equals(emptyImage.getDrawable()))
            return true;
        else if (imageButton4.getDrawable().equals(imageButton5.getDrawable()) && imageButton5.getDrawable().equals(imageButton6.getDrawable())
                && !imageButton6.getDrawable().equals(emptyImage.getDrawable()))
            return true;
        else if (imageButton7.getDrawable().equals(imageButton8.getDrawable()) && imageButton8.getDrawable().equals(imageButton9.getDrawable())
                && !imageButton9.getDrawable().equals(emptyImage.getDrawable()))
            return true;
            //checks columns
        else if (imageButton1.getDrawable().equals(imageButton4.getDrawable()) && imageButton4.getDrawable().equals(imageButton7.getDrawable())
                && !imageButton7.getDrawable().equals(emptyImage.getDrawable()))
            return true;
        else if (imageButton2.getDrawable().equals(imageButton5.getDrawable()) && imageButton5.getDrawable().equals(imageButton8.getDrawable())
                && !imageButton8.getDrawable().equals(emptyImage.getDrawable()))
            return true;
        else if (imageButton3.getDrawable().equals(imageButton6.getDrawable()) && imageButton6.getDrawable().equals(imageButton9.getDrawable())
                && !imageButton9.getDrawable().equals(emptyImage.getDrawable()))
            return true;
            //checks diagonals
        else if (imageButton1.getDrawable().equals(imageButton5.getDrawable()) && imageButton5.getDrawable().equals(imageButton9.getDrawable())
                && !imageButton9.getDrawable().equals(emptyImage.getDrawable()))
            return true;
        else
            return imageButton3.getDrawable().equals(imageButton5.getDrawable()) && imageButton5.getDrawable().equals(imageButton7.getDrawable())
                    && !imageButton7.getDrawable().equals(emptyImage.getDrawable());
    }

    public static Drawable getWinner(ImageButton imageButton1, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4,
                                     ImageButton imageButton5, ImageButton imageButton6, ImageButton imageButton7, ImageButton imageButton8,
                                     ImageButton imageButton9) {
        //checks rows
        if (imageButton1.getDrawable().equals(imageButton2.getDrawable()) && imageButton2.getDrawable().equals(imageButton3.getDrawable())
                && !imageButton3.getDrawable().equals(emptyImage.getDrawable()))
            return imageButton3.getDrawable();
        else if (imageButton4.getDrawable().equals(imageButton5.getDrawable()) && imageButton5.getDrawable().equals(imageButton6.getDrawable())
                && !imageButton6.getDrawable().equals(emptyImage.getDrawable()))
            return imageButton6.getDrawable();
        else if (imageButton7.getDrawable().equals(imageButton8.getDrawable()) && imageButton8.getDrawable().equals(imageButton9.getDrawable())
                && !imageButton9.getDrawable().equals(emptyImage.getDrawable()))
            return imageButton9.getDrawable();
            //checks columns
        else if (imageButton1.getDrawable().equals(imageButton4.getDrawable()) && imageButton4.getDrawable().equals(imageButton7.getDrawable())
                && !imageButton7.getDrawable().equals(emptyImage.getDrawable()))
            return imageButton7.getDrawable();
        else if (imageButton2.getDrawable().equals(imageButton5.getDrawable()) && imageButton5.getDrawable().equals(imageButton8.getDrawable())
                && !imageButton8.getDrawable().equals(emptyImage.getDrawable()))
            return imageButton8.getDrawable();
        else if (imageButton3.getDrawable().equals(imageButton6.getDrawable()) && imageButton6.getDrawable().equals(imageButton9.getDrawable())
                && !imageButton9.getDrawable().equals(emptyImage.getDrawable()))
            return imageButton9.getDrawable();
            //checks diagonals
        else if (imageButton1.getDrawable().equals(imageButton5.getDrawable()) && imageButton5.getDrawable().equals(imageButton9.getDrawable())
                && !imageButton9.getDrawable().equals(emptyImage.getDrawable()))
            return imageButton9.getDrawable();
        else if (imageButton3.getDrawable().equals(imageButton5.getDrawable()) && imageButton5.getDrawable().equals(imageButton7.getDrawable())
                && !imageButton7.getDrawable().equals(emptyImage.getDrawable()))
            return imageButton7.getDrawable();
        return emptyImage.getDrawable();
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

        emptyImage = (ImageButton) findViewById(R.id.emptyImage);
        result = findViewById(R.id.textView);

        imageButton1.setOnClickListener(this);
        imageButton2.setOnClickListener(this);
        imageButton3.setOnClickListener(this);
        imageButton4.setOnClickListener(this);
        imageButton5.setOnClickListener(this);
        imageButton6.setOnClickListener(this);
        imageButton7.setOnClickListener(this);
        imageButton8.setOnClickListener(this);
        imageButton9.setOnClickListener(this);
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
            imageButton1.setEnabled(false);
            imageButton2.setEnabled(false);
            imageButton3.setEnabled(false);
            imageButton4.setEnabled(false);
            imageButton5.setEnabled(false);
            imageButton6.setEnabled(false);
            imageButton7.setEnabled(false);
            imageButton8.setEnabled(false);
            imageButton9.setEnabled(false);
            return;
        }
        switch (view.getId()) {
            case R.id.imageButton1:
                imageButton1.setImageResource(b ? R.drawable.x : R.drawable.o);
                b = !b;
                imageButton1.setEnabled(false);
                break;
            case R.id.imageButton2:
                imageButton2.setImageResource(b ? R.drawable.x : R.drawable.o);
                b = !b;
                imageButton2.setEnabled(false);
                break;
            case R.id.imageButton3:
                imageButton3.setImageResource(b ? R.drawable.x : R.drawable.o);
                b = !b;
                imageButton3.setEnabled(false);
                break;
            case R.id.imageButton4:
                imageButton4.setImageResource(b ? R.drawable.x : R.drawable.o);
                b = !b;
                imageButton4.setEnabled(false);
                break;
            case R.id.imageButton5:
                imageButton5.setImageResource(b ? R.drawable.x : R.drawable.o);
                b = !b;
                imageButton5.setEnabled(false);
                break;
            case R.id.imageButton6:
                imageButton6.setImageResource(b ? R.drawable.x : R.drawable.o);
                b = !b;
                imageButton6.setEnabled(false);
                break;
            case R.id.imageButton7:
                imageButton7.setImageResource(b ? R.drawable.x : R.drawable.o);
                b = !b;
                imageButton7.setEnabled(false);
                break;
            case R.id.imageButton8:
                imageButton8.setImageResource(b ? R.drawable.x : R.drawable.o);
                b = !b;
                imageButton8.setEnabled(false);
                break;
            case R.id.imageButton9:
                imageButton9.setImageResource(b ? R.drawable.x : R.drawable.o);
                b = !b;
                imageButton9.setEnabled(false);
                break;
        }
        if (hasWinner(imageButton1, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6, imageButton7, imageButton8,
                imageButton9)) {
            if (getWinner(imageButton1, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6, imageButton7,
                    imageButton8, imageButton9).equals(R.drawable.x))
                result.setText("X Wins!");
            else
                result.setText("O Wins!");
            check = true;
        }
//        if (gameover(imageButton1, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6, imageButton7, imageButton8, imageButton9)) {
//            result.setText("Draw!");
//            check = true;
//        }
    }

//    public boolean gameover(ImageButton imageButton1, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4, ImageButton imageButton5, ImageButton imageButton6, ImageButton imageButton7, ImageButton imageButton8, ImageButton imageButton9) {
//        if (imageButton1.getDrawable().equals(emptyImage.getDrawable()))
//            return false;
//        if (imageButton2.getDrawable().equals(emptyImage.getDrawable()))
//            return false;
//        if (imageButton3.getDrawable().equals(emptyImage.getDrawable()))
//            return false;
//        if (imageButton4.getDrawable().equals(emptyImage.getDrawable()))
//            return false;
//        if (imageButton5.getDrawable().equals(emptyImage.getDrawable()))
//            return false;
//        if (imageButton6.getDrawable().equals(emptyImage.getDrawable()))
//            return false;
//        if (imageButton7.getDrawable().equals(emptyImage.getDrawable()))
//            return false;
//        if (imageButton8.getDrawable().equals(emptyImage.getDrawable()))
//            return false;
//        if (imageButton9.getDrawable().equals(emptyImage.getDrawable()))
//            return false;
//        return true;
//    }
}
