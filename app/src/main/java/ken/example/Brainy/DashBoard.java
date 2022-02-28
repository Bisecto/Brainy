package ken.example.Brainy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import ken.example.Brainy.R;

public class DashBoard extends AppCompatActivity {
    TextView users_name;
    String usern,first,last,email,gender,pasw;
    MyQuestionDatabase myQuestionDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_dash_board);
        users_name= findViewById(R.id.users_name);
        myQuestionDatabase=new MyQuestionDatabase(this);
//        first= getIntent().getStringExtra("ifirst");
//        last = getIntent().getStringExtra("ilast");
//
//        users_name.setText(first);

//        Bundle bundle = getIntent().getExtras();
//        String bund = bundle.getString("ifirst");
//        String bun = bundle.getString("ilast");
        //users_name.setText(String.format("%s %s", bund, bun));
        //users_name.setText(String.format("%s%s", bund, bun));

    }

    public void AddQuestion(View view) {
        Intent i = new Intent(DashBoard.this, Subject_Category.class);
        startActivity(i);
    }

    public void Online(View view) {
    }

    public void offline(View view) {
        Intent i = new Intent(DashBoard.this,CategoryActivity.class);
        startActivity(i);
    }

    public void History(View view) {
        Intent i = new Intent(DashBoard.this,HistoryActivity.class);
        startActivity(i);
    }
}