package ken.example.Brainy;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ken.example.Brainy.R;

public class ChemistryYearCategory extends AppCompatActivity {
    ListView listView;
    LayoutInflater inflater;
    ArrayList<String> name;
    ArrayList<Integer> image;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_category);
        listView= findViewById(R.id.Category_Listview);
        name= new ArrayList<>();
        image= new ArrayList<>();
        List<String> na = Arrays.asList("Chemistry 2015 Question","Chemistry 2016 Question","Chemistry 2017 Question","Chemistry 2018 Question","Chemistry 2019 Question","Chemistry 2020 Question");

        name.addAll(na);
        catarray arr = new catarray(this, (ArrayList<String>) name);
        listView.setAdapter(arr);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent i = new Intent(ChemistryYearCategory.this, Chemistry2015Questions.class);
                    startActivity(i);
                }
                if(position==1){
                    Intent i = new Intent(ChemistryYearCategory.this, Chemistry2016Questions.class);
                    startActivity(i);
                }
                if(position==2){
                    Intent i = new Intent(ChemistryYearCategory.this, Chemistry2017Questions.class);
                    startActivity(i);
                }
                if(position==3){
                    Intent i = new Intent(ChemistryYearCategory.this, Chemistry2018Questions.class);
                    startActivity(i);
                }
                if(position==4){
                    Intent i = new Intent(ChemistryYearCategory.this, Chemistry2019Questions.class);
                    startActivity(i);
                }
                if(position==5){
                    Intent i = new Intent(ChemistryYearCategory.this, Chemistry2020Questions.class);
                    startActivity(i);
                }
            }
        });
    }
}
