package ken.example.Brainy;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import ken.example.Brainy.R;

public class catarray extends ArrayAdapter {
    ArrayList<String> name;
    Context context;
    ListView list;

    public catarray(@NonNull Context context, ArrayList<String> name) {
        super(context, R.layout.category,name);
        this.name = name;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.category,parent,false);
        TextView text1 = view.findViewById(R.id.text);
        list = view.findViewById(R.id.Category_Listview);
        text1.setText(name.get(position));
        return view;
    }
}
