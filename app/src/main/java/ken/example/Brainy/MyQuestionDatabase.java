package ken.example.Brainy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyQuestionDatabase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME= "QUIZ55.db";
    public static final int DATABASE_VERSION= 1;
    public static final String Random_Question= "Random_Question";
    public static final String Profile="Profile";
    public static final String General_Knowledge= "General_Knoledge";
    public static final String Sports= "Sports";
    public static final String Mathematics= "Mathematics";
    public static final String Current_Affair= "Current_Affair";
    public static final String Science= "Science";
    public static final String Technology= "Technology";
    public static final String History= "History";
    public static final String Column4= "Option4";

    public MyQuestionDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "Create TABLE If not EXISTS " +Random_Question+"(id INTEGER primary key AUTOINCREMENT, List_of_Question TEXT UNIQUE, Option1 TEXT, Option2 Text, Option3 Text,Option4 Text, Answer Text )" ;
        db.execSQL(sql);
        String General_sql = "Create TABLE If not EXISTS " +General_Knowledge+"(id INTEGER primary key AUTOINCREMENT, List_of_Question TEXT UNIQUE, Option1 TEXT, Option2 Text, Option3 Text,Option4 Text, Answer Text )" ;
        db.execSQL(General_sql);
        String Sports_sql = "Create TABLE If not EXISTS " +Sports+"(id INTEGER primary key AUTOINCREMENT, List_of_Question TEXT UNIQUE, Option1 TEXT, Option2 Text, Option3 Text,Option4 Text, Answer Text )" ;
        db.execSQL(Sports_sql);
        String Maths_sql = "Create TABLE If not EXISTS " +Mathematics+"(id INTEGER primary key AUTOINCREMENT, List_of_Question TEXT UNIQUE, Option1 TEXT, Option2 Text, Option3 Text,Option4 Text, Answer Text )" ;
        db.execSQL(Maths_sql);
        String Current_sql = "Create TABLE If not EXISTS " +Current_Affair+"(id INTEGER primary key AUTOINCREMENT, List_of_Question TEXT UNIQUE, Option1 TEXT, Option2 Text, Option3 Text,Option4 Text, Answer Text )" ;
        db.execSQL(Current_sql);
        String Science_sql = "Create TABLE If not EXISTS " +Science+"(id INTEGER primary key AUTOINCREMENT, List_of_Question TEXT UNIQUE, Option1 TEXT, Option2 Text, Option3 Text,Option4 Text, Answer Text )" ;
        db.execSQL(Science_sql);
        String Tech_sql = "Create TABLE If not EXISTS " +Technology+"(id INTEGER primary key AUTOINCREMENT, List_of_Question TEXT UNIQUE, Option1 TEXT, Option2 Text, Option3 Text,Option4 Text, Answer Text )" ;
        db.execSQL(Tech_sql);
        String History_sql = "Create TABLE If not EXISTS " +History+"(id INTEGER primary key AUTOINCREMENT, Date TEXT, Score Text, Time Text )" ;
        db.execSQL(History_sql);
        String Profile_sql = "Create TABLE If not EXISTS " +Profile+"(id INTEGER primary key AUTOINCREMENT, Firstname TEXT, Lastname Text, Email Text, Gender Text, Username Text ,Password Text )" ;
        db.execSQL(Profile_sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ Random_Question);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS "+ General_Knowledge);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS "+ Sports);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS "+ Mathematics);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS "+ Current_Affair);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS "+ Science);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS "+ Technology);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS "+ History);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS "+ Profile);
        onCreate(db);
    }
    public boolean  Insert_Profile(String Firstname, String Lastname, String Email, String Gender, String Username , String Password){
        SQLiteDatabase db = getReadableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("Firstname", Firstname);
        contentValues.put("Lastname",Lastname);
        contentValues.put("Email",Email);
        contentValues.put("Gender",Gender);
        contentValues.put("Username",Username);
        contentValues.put("Password",Password);
        long i = db.insert(Profile,null,contentValues);
        if (i>0){
            return true;
        } else {
            return false;
        }
    }
    public boolean  Insert_Random(String List_of_Question, String Option1,String Option2,String Option3,String Option4, String Answer){
        SQLiteDatabase db = getReadableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("List_of_Question", List_of_Question);
        contentValues.put("Option1",Option1);
        contentValues.put("Option2",Option2);
        contentValues.put("Option3",Option3);
        contentValues.put("Option4",Option4);
        contentValues.put("Answer",Answer);
        long i = db.insert(Random_Question,null,contentValues);
        if (i>0){
            return true;
        } else {
            return false;
        }
    }
    public boolean  Insert_General_KNowledge(String List_of_Question, String Option1,String Option2,String Option3,String Option4, String Answer){
        SQLiteDatabase db = getReadableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("List_of_Question", List_of_Question);
        contentValues.put("Option1",Option1);
        contentValues.put("Option2",Option2);
        contentValues.put("Option3",Option3);
        contentValues.put("Option4",Option4);
        contentValues.put("Answer",Answer);
        long i = db.insert(General_Knowledge,null,contentValues);
        if (i>0){
            return true;
        } else {
            return false;
        }
    }public boolean  Insert_Sports(String List_of_Question, String Option1,String Option2,String Option3,String Option4, String Answer){
        SQLiteDatabase db = getReadableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("List_of_Question", List_of_Question);
        contentValues.put("Option1",Option1);
        contentValues.put("Option2",Option2);
        contentValues.put("Option3",Option3);
        contentValues.put("Option4",Option4);
        contentValues.put("Answer",Answer);
        long i = db.insert(Sports,null,contentValues);
        if (i>0){
            return true;
        } else {
            return false;
        }
    }public boolean  Insert_Mathematics(String List_of_Question, String Option1,String Option2,String Option3,String Option4, String Answer){
        SQLiteDatabase db = getReadableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("List_of_Question", List_of_Question);
        contentValues.put("Option1",Option1);
        contentValues.put("Option2",Option2);
        contentValues.put("Option3",Option3);
        contentValues.put("Option4",Option4);
        contentValues.put("Answer",Answer);
        long i = db.insert(Mathematics,null,contentValues);
        if (i>0){
            return true;
        } else {
            return false;
        }
    }
    public boolean  Insert_Current(String List_of_Question, String Option1,String Option2,String Option3,String Option4, String Answer){
        SQLiteDatabase db = getReadableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("List_of_Question", List_of_Question);
        contentValues.put("Option1",Option1);
        contentValues.put("Option2",Option2);
        contentValues.put("Option3",Option3);
        contentValues.put("Option4",Option4);
        contentValues.put("Answer",Answer);
        long i = db.insert(Current_Affair,null,contentValues);
        if (i>0){
            return true;
        } else {
            return false;
        }
    }public boolean  Insert_Science(String List_of_Question, String Option1,String Option2,String Option3,String Option4, String Answer){
        SQLiteDatabase db = getReadableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("List_of_Question", List_of_Question);
        contentValues.put("Option1",Option1);
        contentValues.put("Option2",Option2);
        contentValues.put("Option3",Option3);
        contentValues.put("Option4",Option4);
        contentValues.put("Answer",Answer);
        long i = db.insert(Science,null,contentValues);
        if (i>0){
            return true;
        } else {
            return false;
        }
    }
    public boolean  Insert_Technology(String List_of_Question, String Option1,String Option2,String Option3,String Option4, String Answer){
        SQLiteDatabase db = getReadableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("List_of_Question", List_of_Question);
        contentValues.put("Option1",Option1);
        contentValues.put("Option2",Option2);
        contentValues.put("Option3",Option3);
        contentValues.put("Option4",Option4);
        contentValues.put("Answer",Answer);
        long i = db.insert(Technology,null,contentValues);
        if (i>0){
            return true;
        } else {
            return false;
        }
    }
    public boolean  History(String Date , String Score, String Time){
        SQLiteDatabase db = getReadableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("Date",Date);
        contentValues.put("Score",Score);
        contentValues.put("Time",Time);
        long i = db.insert(History,null,contentValues);
        if (i>0){
            return true;
        } else {
            return false;
        }
    }

    public Cursor ReadData(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from "+Random_Question+" ORDER by RANDOM()", new String[] {});
        return  cursor;
    }
    public Cursor ReadRandomDATABASE(){
        SQLiteDatabase db = getReadableDatabase();
        String query= "g"  ;
        Cursor cursor = db.rawQuery("SELECT * FROM "+Random_Question+" WHERE Option4 = '"+query+"' ",null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        return  cursor;
    }
    public Cursor ReadProfileDATABASE(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from "+Profile+" ORDER by ID", new String[] {});
        return  cursor;
    }
    public Cursor ReadGeneralData(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from "+General_Knowledge+" ORDER by ID desc", new String[] {});
        return  cursor;
    }
    public Cursor ReadSportsData(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from "+Sports+" ORDER by ID desc", new String[] {});
        return  cursor;
    }
    public Cursor ReadMathsData(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from "+Mathematics+" ORDER by ID desc", new String[] {});
        return  cursor;
    }
    public Cursor ReadCurrentData(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from "+Current_Affair+" ORDER by ID desc", new String[] {});
        return  cursor;
    }
    public Cursor ReadScienceData(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from "+Science+" ORDER by ID desc", new String[] {});
        return  cursor;
    }
    public Cursor ReadTechData(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from "+Technology+" ORDER by RANDOM() desc", new String[] {});
        return  cursor;
    }
    public Cursor ReadHistoryData(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from "+History+" ORDER by ID desc", new String[] {});
        return  cursor;
    }
    public Integer DeleteRandomRow(String id){
        SQLiteDatabase db = getReadableDatabase();

        return db.delete(Random_Question,"id=?", new String[]{id} );
    }
    public Integer DeleteHistoryRow(String id){
        SQLiteDatabase db = getReadableDatabase();

        return db.delete(History,"id=?", new String[]{id} );
    }
}
