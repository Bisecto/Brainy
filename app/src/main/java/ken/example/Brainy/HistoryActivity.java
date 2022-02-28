package ken.example.Brainy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import ken.example.Brainy.R;

public class HistoryActivity extends AppCompatActivity {
Cursor res;
LayoutInflater layoutInflater;
TextView Date_Format,Time_Format,ma_Score,dele;
LinearLayout container;
int id;
MyQuestionDatabase myQuestionDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        container=findViewById(R.id.Container);
        myQuestionDatabase=new MyQuestionDatabase(this);
        layoutInflater = LayoutInflater.from(this);
        res = myQuestionDatabase.ReadHistoryData();


        while (res.moveToNext()) {
            final View view = layoutInflater.inflate(R.layout.historyxml, container, false);
            Date_Format = view.findViewById(R.id.Date_Format);
            Time_Format = view.findViewById(R.id.Time_Format);
            ma_Score= view.findViewById(R.id.ma_Score);
            dele= view.findViewById(R.id.dele);


            id = res.getInt(res.getColumnIndex("id"));
            Date_Format.setText(res.getString(res.getColumnIndex("Date")));
            Time_Format.setText(res.getString(res.getColumnIndex("Time")));
            ma_Score.setText(res.getString(res.getColumnIndex("Score")));
dele.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Integer integer=  myQuestionDatabase.DeleteHistoryRow(String.valueOf(id));
    }
});
            container.addView(view);
        }
    }
}