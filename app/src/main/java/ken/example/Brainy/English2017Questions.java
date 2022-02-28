package ken.example.Brainy;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import ken.example.Brainy.R;

public class English2017Questions extends AppCompatActivity {
    MyDataBase myDataBase;

    LinearLayout container,Linear;
    LayoutInflater layoutInflater;
    int id;
    Cursor res;
    TextView popQuestion, popOption1,popOption2, popOption3,popOption4,popAnswer,subject,Admin_Board;


    EditText Enter_Question, firstOption,secondOption,thirdOption,fourthOption,CorrectOption;
    Button Input;
    Boolean isInserted;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input__question);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        Admin_Board=findViewById(R.id.Admin_Board);
        subject=findViewById(R.id.subject);
        subject.setText("English");
        Admin_Board.setText("En217Q");

        myDataBase=new MyDataBase(this);
        layoutInflater = LayoutInflater.from(this);
        container= findViewById(R.id.container);
        res = myDataBase. ReadEn2017Question();

        Enter_Question=findViewById(R.id.Enter_Question);
        firstOption=findViewById(R.id.Enter_First_Option);
        secondOption=findViewById(R.id.Enter_Second_Option);
        thirdOption=findViewById(R.id.Enter_Third_Option);
        fourthOption=findViewById(R.id.Enter_Forth_Option);
        CorrectOption=findViewById(R.id.Enter_Correct_Option);
        Input= findViewById(R.id.Input);


        while (res.moveToNext()) {
            final View view = layoutInflater.inflate(R.layout.registered_question_populate, container, false);
            popQuestion = view.findViewById(R.id.popQuestion);
            popOption1 = view.findViewById(R.id.popOption1);
            popOption2 = view.findViewById(R.id.popOption2);
            popOption3 = view.findViewById(R.id.popOption3);
            popOption4 = view.findViewById(R.id.popOption4);
            popAnswer = view.findViewById(R.id.popAnswer);
            id = res.getInt(res.getColumnIndex("id"));
            popQuestion.setText(res.getString(res.getColumnIndex("List_of_Question")));
            popOption1.setText(res.getString(res.getColumnIndex("Option1")));
            popOption2.setText(res.getString(res.getColumnIndex("Option2")));
            popOption3.setText(res.getString(res.getColumnIndex("Option3")));
            popOption4.setText(res.getString(res.getColumnIndex("Option4")));
            popAnswer.setText(res.getString(res.getColumnIndex("Answer")));
            container.addView(view);
        }
        Input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               myDataBase= new MyDataBase(English2017Questions.this);
                String  Question= String.valueOf(Enter_Question.getText());
                String Op1= String.valueOf(firstOption.getText());
                String Op2= String.valueOf(secondOption.getText());
                String Op3= String.valueOf(thirdOption.getText());
                String Op4= String.valueOf(fourthOption.getText());
                String Ans= String.valueOf(CorrectOption.getText());
                String sub= String.valueOf(subject.getText());
                String sub_cat= String.valueOf(Admin_Board.getText());
                if (!Question.trim().equals("")){
                    if (!Op1.trim().equals("")){
                        if (!Op2.trim().equals("")){
                            if (!Op3.trim().equals("")){
                                if (!Op4.trim().equals("")){
                                    if (!Ans.trim().equals("")){
                                        if (Ans.equals(Op1)||Ans.equals(Op2)|| Ans.equals(Op3) ||Ans.equals(Op4)){
                                            isInserted = myDataBase.Insert_MyTable(sub,sub_cat,Question, Op1, Op2, Op3, Op4,Ans);
                                            if (isInserted == true) {
                                                //Log.i("my","correct");
                                                Toast.makeText(English2017Questions.this, "Question Sucessfully Added", Toast.LENGTH_LONG).show();
                                                Intent i = new Intent(English2017Questions.this, English2017Questions.class);
                                                finish();
                                                overridePendingTransition(0,0);
                                                startActivity(i);
                                                overridePendingTransition(0,0);
                                            } else{
                                                Toast.makeText(English2017Questions.this, "Not Sucessful", Toast.LENGTH_LONG).show();
                                            }
                                        } else {
                                            CorrectOption.setError("The Correct Option does'nt Match Any Option");
                                        }

                                    }else {
                                        CorrectOption.setError("Empty Field");
                                    }

                                }else {
                                    fourthOption.setError("Empty Field");
                                }

                            }else {
                                thirdOption.setError("Empty Field");
                            }

                        }else {
                            secondOption.setError("Empty Field");
                        }

                    }else {
                        firstOption.setError("Empty Field");
                    }

                } else {
                    Enter_Question.setError("Empty Field");
                }
            }
        });

    }
}
