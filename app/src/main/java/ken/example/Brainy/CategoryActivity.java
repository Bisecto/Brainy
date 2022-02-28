package ken.example.Brainy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ken.example.Brainy.R;

public class CategoryActivity extends AppCompatActivity {
ListView listView;
    LayoutInflater inflater;
    ArrayList<String> name;
    ArrayList<Integer> image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_category);
        listView= findViewById(R.id.Category_Listview);
        name= new ArrayList<>();
        image= new ArrayList<>();
        List<String> na = Arrays.asList("English","Mathematics","Physics","Chemistry","Biology","Government");
        
        name.addAll(na);
        catarray arr = new catarray(this, (ArrayList<String>) name);
        listView.setAdapter(arr);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent i = new Intent(CategoryActivity.this,MainQuiz.class);
                    startActivity(i);
                }
            }
        });
    }


}