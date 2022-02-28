package ken.example.Brainy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import ken.example.Brainy.R;

public class SplashScreenActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_splash_screen2);
        Thread thread= new Thread() {
            public void run() {
                try {
                    sleep(3000);
                    Intent intent = new Intent(SplashScreenActivity2.this, MainActivity.class);
                    finish();

                    startActivity(intent);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        };
        thread.start();
    }
}