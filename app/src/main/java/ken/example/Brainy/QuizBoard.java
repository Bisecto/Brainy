package ken.example.Brainy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import ken.example.Brainy.R;

public class QuizBoard extends AppCompatActivity {
TextView count;
CountDownTimer countDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_quiz_board);
        count= findViewById(R.id.Timer);
        countDownTimer = new CountDownTimer(10000,1000) {
          @Override
          public void onTick(long millisUntilFinished) {
              count.setText(  String.valueOf(millisUntilFinished/1000));
          }

          @Override
          public void onFinish() {
              Intent i = new Intent(QuizBoard.this,MainQuiz.class);
              startActivity(i);
          }
      }.start();
     // countDownTimer.start();
    }

    @Override
    public void onBackPressed() {
        countDownTimer.cancel();
        Intent i = new Intent(QuizBoard.this,CategoryActivity.class);
        startActivity(i);
    }
}