package ken.example.Brainy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import ken.example.Brainy.R;

public class ScoreBoard extends AppCompatActivity {

    MyQuestionDatabase myQuestionDatabase;
    int id;
    Cursor res;

    Boolean isInserted;
TextView myScore;
Button Go_To_DashBoard,Try_Again;
SharedPreferences sharedPreferences;
SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_score_board);
        sharedPreferences= this.getPreferences(this.MODE_PRIVATE);
        editor= sharedPreferences.edit();
        Try_Again= findViewById(R.id.Try_Again);
        Go_To_DashBoard=findViewById(R.id.Go_To_DashBoard);
        myScore=findViewById(R.id.myScore);
        String abo = getIntent().getExtras().getString("ss");
        myScore.setText("You Scored "+abo+" Out Of 5");


        Try_Again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myhistory();
                Intent i = new Intent(ScoreBoard.this, MainQuiz.class);
                startActivity(i);
            }
        });
        Go_To_DashBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myhistory();
                String first = sharedPreferences.getString("user_fn", "");
                String last = sharedPreferences.getString("user_ln", "");
                Intent i = new Intent(ScoreBoard.this, DashBoard.class);
                i.putExtra("ifirst",first);
                i.putExtra("ilast",last);
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed() {
        myhistory();
        AlertDialog.Builder dialog = new AlertDialog.Builder(ScoreBoard.this);
        dialog.setCancelable(true);
        dialog.setTitle("Exit the Quiz?");
        dialog.setMessage("Do You Want to Leave The Quiz");
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i= new Intent(ScoreBoard.this,MainActivity.class);
                startActivity(i);
            }
        });
        final AlertDialog alert = dialog.create();
        alert.show();
    }
    public void myhistory(){
        myQuestionDatabase= new MyQuestionDatabase(ScoreBoard.this);
        String time = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        String  meScore= String.valueOf(myScore.getText());
        isInserted = myQuestionDatabase.History(date,meScore,time);
        if (isInserted == true) {
            //Log.i("my","correct");
            Toast.makeText(ScoreBoard.this, "Sucessfully Added", Toast.LENGTH_LONG).show();
        } else{
            Toast.makeText(ScoreBoard.this, "Not Sucessful", Toast.LENGTH_LONG).show();
        }
    }
}