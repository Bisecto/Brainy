package ken.example.Brainy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import ken.example.Brainy.R;

public class MainActivity extends AppCompatActivity {
Button invisible, visible, sign,next;
EditText firstname,lastname,Email,Login_User,Login_Pass,username,password,confirm;
LinearLayout Login_Layout, Register_Layout;
RadioGroup radio;
RadioButton radio1,radio2;
    String gender,fn,ln,em,un,pw,con;
    Boolean isInserted;
MyQuestionDatabase myQuestionDatabase;
MyDataBase myDataBase;
    Cursor res;
SharedPreferences sharedPreferences;
SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        invisible = findViewById(R.id.invisible);
        visible = findViewById(R.id.visible);
        sign = findViewById(R.id.sign);
        Login_Layout = findViewById(R.id.Login_Layout);
        Register_Layout = findViewById(R.id.Register_Layout);
        firstname = findViewById(R.id.first_name);
        lastname = findViewById(R.id.Last_name);
        Email = findViewById(R.id.Email);
        next = findViewById(R.id.next);
        radio=findViewById(R.id.radio);
        radio1= findViewById(R.id.radio1);
        radio2= findViewById(R.id.radio2);
        confirm = findViewById(R.id.Confirm_yourpassword);
        Login_User = findViewById(R.id.Login_Username);
        Login_Pass = findViewById(R.id.Login_Password);
        username = findViewById(R.id.Enter_yourusername);
        password = findViewById(R.id.Enter_yourpassword);
        myDataBase=new MyDataBase(this);
        myQuestionDatabase=new MyQuestionDatabase(this);
        sharedPreferences= this.getPreferences(this.MODE_PRIVATE);
        editor= sharedPreferences.edit();
        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.radio1){
                }
                switch (checkedId) {
                    case R.id.radio1:
                        gender = "male";
                        break;
                    case R.id.radio2:
                        gender = "female";
                }
            }
        });
    }
    public void invisible(View view) {
        invisible.setVisibility(View.GONE);
        visible.setVisibility(View.VISIBLE);
        password.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }

    public void visible(View view) {
        invisible.setVisibility(View.VISIBLE);
        visible.setVisibility(View.GONE);
        password.setTransformationMethod(null);

    }

    public void sign(View view) {
        Login_Layout.setVisibility(view.GONE);
        Register_Layout.setVisibility(View.VISIBLE);

        radio.setVisibility(View.VISIBLE);
        firstname.setVisibility(View.VISIBLE);
        lastname.setVisibility(View.VISIBLE);
        Email.setVisibility(View.VISIBLE);
        username.setVisibility(View.GONE);
        password.setVisibility(View.GONE);
        confirm.setVisibility(View.GONE);
    }

    public void Next(View view) {
        myDataBase= new MyDataBase(MainActivity.this);
         fn = String.valueOf(firstname.getText());
         ln = String.valueOf(lastname.getText());
         em = String.valueOf(Email.getText());
         un = String.valueOf(username.getText());
         pw = String.valueOf(password.getText());
         con = String.valueOf(confirm.getText());
        if (!fn.trim().equals("")){
            if (!ln.trim().equals("")){
                if (!em.trim().equals("")) {
                    if (gender !=null) {
                        radio.setVisibility(View.GONE);
                    firstname.setVisibility(View.GONE);
                    lastname.setVisibility(View.GONE);
                    Email.setVisibility(View.GONE);
                    username.setVisibility(View.VISIBLE);
                    password.setVisibility(View.VISIBLE);
                    confirm.setVisibility(View.VISIBLE);
                    if (!un.trim().equals("")) {
                        if (!pw.trim().equals("")) {
                            if (con.trim().equals(pw)) {
                                Register_Layout.setVisibility(View.GONE);
                                Login_Layout.setVisibility(view.VISIBLE);
                                isInserted =myDataBase.Insert_Profile(fn,ln,em,gender, un, pw);
                                if (isInserted == true) {
                                    //Log.i("my","correct");
                                    Toast.makeText(MainActivity.this, "Account Sucessfully Created", Toast.LENGTH_LONG).show();
//                                    Intent i = new Intent(MainActivity.this, Maths_AddQuestion.class);
//                                    finish();
//                                    overridePendingTransition(0,0);
//                                    startActivity(i);
//                                    overridePendingTransition(0,0);
                                } else{
                                    Toast.makeText(MainActivity.this, "Not Sucessful", Toast.LENGTH_LONG).show();
                                }
                                firstname.setText("");
                                lastname.setText("");
                                Email.setText("");
                                username.setText("");
                                password.setText("");
                                confirm.setText("");


                            } else {
                                Toast.makeText(this, "Confirm Your password", Toast.LENGTH_LONG).show();
                            }

                        } else {
                            Toast.makeText(this, "Please a password", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(this, "Enter your username", Toast.LENGTH_LONG).show();
                    }
                }else{
                        Toast.makeText(this, "Tick your gender", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(this, "Please enter your Email", Toast.LENGTH_LONG).show();
                }

            } else {
                Toast.makeText(this, "Please enter your Lastname", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "Please enter your Firstname", Toast.LENGTH_LONG).show();
        }
    }

    public void Login(View view) {



//        if (!Login_User.getText().toString().trim().equals("")){
//            if (!Login_Pass.getText().toString().trim().equals("")){
//                String usern = sharedPreferences.getString("user_un", "");
//                String pasw = sharedPreferences.getString("user_pw", "");
//                String first = sharedPreferences.getString("user_fn", "");
//                String last = sharedPreferences.getString("user_ln", "");
//                String email = sharedPreferences.getString("user_em", "");
//                String gender = sharedPreferences.getString("user_gen", "");
//                String u= String.valueOf(Login_User.getText());
//                String p= String.valueOf(Login_Pass.getText());
//                res = myDataBase.Login_IN(u,p);
//                String usern=res.getString(res.getColumnIndex("Username"));
//                String pass=res.getString(res.getColumnIndex("Password"));



//                if (u.equals(usern) && u.equals(pass)){
//                    Toast.makeText(this, "hieee", Toast.LENGTH_SHORT).show();
                   Intent i = new Intent(MainActivity.this,DashBoard.class);
//
//
//                    //i.putExtra("ifirst",first);
//                    //i.putExtra("ilast",last);
                    startActivity(i);
//                    Login_User.setText("");
//                    Login_Pass.setText("");
//
//                } else{
//                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
//                    dialog.setCancelable(true);
//                    dialog.setTitle("please confirm Your username and password are correct");
//                    dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//
//                        }
//                    });
//                    final AlertDialog alert = dialog.create();
//                    alert.show();
//               }
//               // String gen = sharedPreferences.getString("user_gender", "");
//
//
////            } else{
//                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
//                dialog.setCancelable(true);
//                dialog.setTitle("Please Enter Your Password");
//                dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                });
//                final AlertDialog alert = dialog.create();
//                alert.show();
//            }
//        } else{
//            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
//            dialog.setCancelable(true);
//            dialog.setTitle("Please Enter Your username");
//            dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//
//                }
//            });
//            final AlertDialog alert = dialog.create();
//            alert.show();
//        }
    }

    public void forgot(View view) {
        Bundle bundle = getIntent().getExtras();
        String bund = bundle.getString("ipassword");
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setCancelable(true);
        dialog.setTitle("Your password is  "+bund+"");
        dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
             });

    }
}