package ken.example.Brainy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import ken.example.Brainy.R;

public class MainQuiz extends AppCompatActivity {
    MyQuestionDatabase myQuestionDatabase;
    CountDownTimer countDownTimer;
    TextView Question,count,S_Textview,question_remaining;
    String answer;
    Cursor res;
    RadioGroup radioGroup;
    Button radiobtn1,radiobtn2,radiobtn3,radiobtn4;
    Button next_question;
    int counter = 1;
    int  Question_Rem=1;
    int Score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_main_quiz);

        quizcountdown();
        question_remaining=findViewById(R.id.question_remaining);

        question_remaining.setText(Question_Rem+"/5");
        S_Textview=findViewById(R.id.S_Textview);
        S_Textview.setText(String.valueOf(Score));
        count= findViewById(R.id.Timer);
        Question= findViewById(R.id.question);
        radioGroup=findViewById(R.id.radiogroup);
        radiobtn1=findViewById(R.id.radiobtn1);
        radiobtn2=findViewById(R.id.radiobtn2);
        radiobtn3=findViewById(R.id.radiobtn3);
        radiobtn4=findViewById(R.id.radiobtn4);
        next_question=findViewById(R.id.next_question);
        myQuestionDatabase = new MyQuestionDatabase(this);
        res();


}
    public void getTex(Cursor res){
        int id = res.getInt(res.getColumnIndex("id"));
        Question.setText(res.getString(res.getColumnIndex("List_of_Question")));
        radiobtn1.setText(res.getString(res.getColumnIndex("Option1")));
        radiobtn2.setText(res.getString(res.getColumnIndex("Option2")));
        radiobtn3.setText(res.getString(res.getColumnIndex("Option3")));
        radiobtn4.setText(res.getString(res.getColumnIndex("Option4")));
        answer=res.getString(res.getColumnIndex("Answer"));
    }

    public void res(){
        res = myQuestionDatabase.ReadData();
        while(res.moveToNext()) {
         getTex(res);
         getSelectedOption();
        }
}
    public void lastques(){
        countDownTimer = new CountDownTimer(15000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            count.setText(String.valueOf(millisUntilFinished / 1000));
        }

            @Override
            public void onFinish() {
               String ss= String.valueOf(S_Textview.getText());
               Intent i= new Intent(MainQuiz.this,ScoreBoard.class);
               i.putExtra("ss",ss);
               startActivity(i);
        }
    }.start();
}

    public void quizcountdown(){
        count= findViewById(R.id.Timer);
        countDownTimer = new CountDownTimer(15000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                count.setText(  String.valueOf(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                Question_Rem++;
                question_remaining.setText(Question_Rem+"/5");
                buttonColor();
                getSelectedOption();
                radioGroup.clearCheck();
                counter++;

                try {
                    countDownTimer.cancel();
                    quizcountdown();
                    res = myQuestionDatabase.ReadData();
                    while(res.moveToNext()){
                        String co = res.getString(res.getColumnIndex("Option2"));
                        Log.i("nextnext", co + String.valueOf(counter));
                        getTex(res);
                    }
                } catch (SQLException e){
                    Toast.makeText(MainQuiz.this, "An Error", Toast.LENGTH_SHORT).show();

}
                String g= String.valueOf(question_remaining.getText());
                if (g.equals("5/5")){
                    next_question.setVisibility(View.GONE);
                    //Toast.makeText(MainQuiz.this, "End", Toast.LENGTH_SHORT).show();
                    countDownTimer.cancel();
                    lastques();
                }
            }
        }.start();

    }

    public void next(View view) {
        Question_Rem++;
        question_remaining.setText(Question_Rem+"/5");
        buttonColor();
        getSelectedOption();
        radioGroup.clearCheck();
        counter++;

        try {
            countDownTimer.cancel();
            quizcountdown();
            res = myQuestionDatabase.ReadData();
            while(res.moveToNext()){
                String co = res.getString(res.getColumnIndex("Option2"));
                Log.i("nextnext", co + String.valueOf(counter));
                getTex(res);
            }
        } catch (SQLException e){
            Toast.makeText(MainQuiz.this, "An Error", Toast.LENGTH_SHORT).show();
        }

       String g= String.valueOf(question_remaining.getText());
       if (g.equals("5/5")){
          next_question.setVisibility(View.GONE);
           Toast.makeText(MainQuiz.this, "End", Toast.LENGTH_SHORT).show();
            countDownTimer.cancel();
           lastques();
       }


    }
    public void buttonColor(){
        radiobtn1.setBackgroundColor(Color.rgb(198,198,198));
        radiobtn2.setBackgroundColor(Color.rgb(198,198,198));
        radiobtn3.setBackgroundColor(Color.rgb(198,198,198));
        radiobtn4.setBackgroundColor(Color.rgb(198,198,198));
    }

public void getSelectedOption(){
        radiobtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radiobtn1.setBackgroundColor(Color.rgb(69,137,209));
                radiobtn1.setClickable(false);
                radiobtn2.setClickable(false);
                radiobtn3.setClickable(false);
                radiobtn4.setClickable(false);
                String get= (String) radiobtn1.getText();
                if (get.equals(answer)){
                    Score++;
                    S_Textview.setText(String.valueOf(Score));
                }
            }
        });
    radiobtn2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            radiobtn2.setBackgroundColor(Color.rgb(69,137,209));
            radiobtn2.setClickable(false);
            radiobtn1.setClickable(false);
            radiobtn3.setClickable(false);
            radiobtn4.setClickable(false);
            String get= (String) radiobtn2.getText();
            if (get.equals(answer)){
                Score++;
                S_Textview.setText(String.valueOf(Score));
            }
        }
    });
    radiobtn3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            radiobtn3.setBackgroundColor(Color.rgb(69,137,209));
            radiobtn1.setClickable(false);
            radiobtn2.setClickable(false);
            radiobtn4.setClickable(false);
            radiobtn3.setClickable(false);
            String get= (String) radiobtn3.getText();
            if (get.equals(answer)){
                Score++;
                S_Textview.setText(String.valueOf(Score));
            }
        }
    });
    radiobtn4.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            radiobtn4.setBackgroundColor(Color.rgb(69,137,209));
            radiobtn1.setClickable(false);
            radiobtn2.setClickable(false);
            radiobtn3.setClickable(false);
            radiobtn4.setClickable(false);
            String get= (String) radiobtn4.getText();
            if (get.equals(answer)){
                Score++;
                S_Textview.setText(String.valueOf(Score));
            }
        }
    });
}

    @Override
    public void onBackPressed() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainQuiz.this);
        dialog.setCancelable(true);
        dialog.setTitle("Exit the Quiz?");
        dialog.setMessage("Do You Want to Leave The Quiz");
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i= new Intent(MainQuiz.this,MainActivity.class);
                startActivity(i);
            }
        });
        final AlertDialog alert = dialog.create();
        alert.show();
    }
}