package ken.example.Brainy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDataBase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME= "QUIZ_DB.db";
    public static final int DATABASE_VERSION= 1;
    public static final String MyTable= "QuizTable";
    public static final String ProfileTable="Profile";
    public static final String HistoryTable= "History";

    public MyDataBase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "Create TABLE If not EXISTS " +MyTable+"(id INTEGER primary key AUTOINCREMENT, Subject Text, Sub_Year_Category, List_of_Question TEXT UNIQUE, Option1 TEXT, Option2 Text, Option3 Text,Option4 Text, Answer Text )" ;
        db.execSQL(sql);
        String History_sql = "Create TABLE If not EXISTS " +HistoryTable+"(id INTEGER primary key AUTOINCREMENT, Subject Text, Date TEXT, Score Text, Time Text )" ;
        db.execSQL(History_sql);
        String Profile_sql = "Create TABLE If not EXISTS " +ProfileTable+"(id INTEGER primary key AUTOINCREMENT, Firstname TEXT, Lastname Text, Email Text, Gender Text, Username Text ,Password Text )" ;
        db.execSQL(Profile_sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ MyTable);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS "+ HistoryTable);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS "+ ProfileTable);
        onCreate(db);
    }
    public boolean  Insert_Profile(String Firstname, String Lastname, String Email, String Gender, String Username , String Password) {
        SQLiteDatabase db = getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Firstname", Firstname);
        contentValues.put("Lastname", Lastname);
        contentValues.put("Email", Email);
        contentValues.put("Gender", Gender);
        contentValues.put("Username", Username);
        contentValues.put("Password", Password);
        long i = db.insert(ProfileTable, null, contentValues);
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }
    public Cursor Login_IN(String username, String password){
        SQLiteDatabase db = getReadableDatabase();
       // String query= "En215Q";
        String Use=username;
        String pass= password;
        Cursor cursor = db.rawQuery("SELECT * FROM "+ProfileTable+" WHERE Username = '"+Use+"' AND Password='"+pass+"' ",null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        return  cursor;
    }
    public boolean  Insert_MyTable( String Subject,String Sub_Year_Category ,String List_of_Question, String Option1,String Option2,String Option3,String Option4, String Answer){
        SQLiteDatabase db = getReadableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("Subject",Subject);
        contentValues.put("Sub_Year_Category",Sub_Year_Category);
        contentValues.put("List_of_Question", List_of_Question);
        contentValues.put("Option1",Option1);
        contentValues.put("Option2",Option2);
        contentValues.put("Option3",Option3);
        contentValues.put("Option4",Option4);
        contentValues.put("Answer",Answer);
        long i = db.insert(MyTable,null,contentValues);
        if (i>0){
            return true;
        } else {
            return false;
        }
    }
    public boolean  History(String Subject,String Date , String Score, String Time){
        SQLiteDatabase db = getReadableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("Subject",Subject);
        contentValues.put("Date",Date);
        contentValues.put("Score",Score);
        contentValues.put("Time",Time);
        long i = db.insert(HistoryTable,null,contentValues);
        if (i>0){
            return true;
        } else {
            return false;
        }
    }
    public Cursor ReadEn2015Question(){
        SQLiteDatabase db = getReadableDatabase();
        String query= "En215Q";
        Cursor cursor = db.rawQuery("SELECT * FROM "+MyTable+" WHERE Sub_Year_Category = '"+query+"' ORDER by ID Desc ",null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        return  cursor;
    }
    public Cursor ReadEn2016Question(){
        SQLiteDatabase db = getReadableDatabase();
        String query= "En216Q"  ;
        Cursor cursor = db.rawQuery("SELECT * FROM "+MyTable+" WHERE Sub_Year_Category = '"+query+"' ORDER by ID Desc ",null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        return  cursor;
    }
    public Cursor ReadEn2017Question(){
        SQLiteDatabase db = getReadableDatabase();
        String query= "En217Q"  ;
        Cursor cursor = db.rawQuery("SELECT * FROM "+MyTable+" WHERE Sub_Year_Category = '"+query+"' ORDER by ID Desc ",null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        return  cursor;
    }
    public Cursor ReadEn2018Question(){
        SQLiteDatabase db = getReadableDatabase();
        String query= "En218Q"  ;
        Cursor cursor = db.rawQuery("SELECT * FROM "+MyTable+" WHERE Sub_Year_Category = '"+query+"'  ORDER by ID Desc ",null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        return  cursor;
    }
    public Cursor ReadEn2019Question(){
        SQLiteDatabase db = getReadableDatabase();
        String query= "En219Q"  ;
        Cursor cursor = db.rawQuery("SELECT * FROM "+MyTable+" WHERE Sub_Year_Category = '"+query+"'  ORDER by ID Desc ",null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        return  cursor;
    }
    public Cursor ReadEn2020Question(){
        SQLiteDatabase db = getReadableDatabase();
        String query= "En220Q"  ;
        Cursor cursor = db.rawQuery("SELECT * FROM "+MyTable+" WHERE Sub_Year_Category = '"+query+"' ORDER by ID Desc ",null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        return  cursor;
    }
    public Cursor ReadMa2015Question(){
        SQLiteDatabase db = getReadableDatabase();
        String query= "Ma215Q"  ;
        Cursor cursor = db.rawQuery("SELECT * FROM "+MyTable+" WHERE Sub_Year_Category = '"+query+"' ORDER by ID Desc ",null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        return  cursor;
    }
    public Cursor ReadMa2016Question(){
        SQLiteDatabase db = getReadableDatabase();
        String query= "Ma216Q"  ;
        Cursor cursor = db.rawQuery("SELECT * FROM "+MyTable+" WHERE Sub_Year_Category = '"+query+"' ORDER by ID Desc ",null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        return  cursor;
    }
    public Cursor ReadMa2017Question(){
        SQLiteDatabase db = getReadableDatabase();
        String query= "Ma217Q"  ;
        Cursor cursor = db.rawQuery("SELECT * FROM "+MyTable+" WHERE Sub_Year_Category = '"+query+"' ORDER by ID Desc ",null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        return  cursor;
    }
    public Cursor ReadMa2018Question(){
        SQLiteDatabase db = getReadableDatabase();
        String query= "Ma218Q"  ;
        Cursor cursor = db.rawQuery("SELECT * FROM "+MyTable+" WHERE Sub_Year_Category = '"+query+"' ORDER by ID Desc ",null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        return  cursor;
    }
    public Cursor ReadMa2019Question(){
        SQLiteDatabase db = getReadableDatabase();
        String query= "Ma219Q"  ;
        Cursor cursor = db.rawQuery("SELECT * FROM "+MyTable+" WHERE Sub_Year_Category = '"+query+"' ORDER by ID Desc ",null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        return  cursor;
    }
    public Cursor ReadMa2020Question(){
        SQLiteDatabase db = getReadableDatabase();
        String query= "Ma220Q"  ;
        Cursor cursor = db.rawQuery("SELECT * FROM "+MyTable+" WHERE Sub_Year_Category = '"+query+"' ORDER by ID Desc ",null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        return  cursor;
    }
    public Cursor ReadPhy2015Question(){
        SQLiteDatabase db = getReadableDatabase();
        String query= "Phy215Q"  ;
        Cursor cursor = db.rawQuery("SELECT * FROM "+MyTable+" WHERE Sub_Year_Category = '"+query+"' ORDER by ID Desc ",null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        return  cursor;
    }
    public Cursor ReadPhy2016Question(){
        SQLiteDatabase db = getReadableDatabase();
        String query= "Phy216Q"  ;
        Cursor cursor = db.rawQuery("SELECT * FROM "+MyTable+" WHERE Sub_Year_Category = '"+query+"' ORDER by ID Desc ",null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        return  cursor;
    }
    public Cursor ReadPhy2017Question(){
        SQLiteDatabase db = getReadableDatabase();
        String query= "Phy217Q"  ;
        Cursor cursor = db.rawQuery("SELECT * FROM "+MyTable+" WHERE Sub_Year_Category = '"+query+"' ORDER by ID Desc ",null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        return  cursor;
    }
    public Cursor ReadPhy2018Question(){
        SQLiteDatabase db = getReadableDatabase();
        String query= "Phy218Q"  ;
        Cursor cursor = db.rawQuery("SELECT * FROM "+MyTable+" WHERE Sub_Year_Category = '"+query+"' ORDER by ID Desc ",null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        return  cursor;
    }
    public Cursor ReadPhy2019Question(){
        SQLiteDatabase db = getReadableDatabase();
        String query= "Phy219Q"  ;
        Cursor cursor = db.rawQuery("SELECT * FROM "+MyTable+" WHERE Sub_Year_Category = '"+query+"' ORDER by ID Desc ",null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        return  cursor;
    }
    public Cursor ReadPhy2020Question(){
        SQLiteDatabase db = getReadableDatabase();
        String query= "Phy220Q"  ;
        Cursor cursor = db.rawQuery("SELECT * FROM "+MyTable+" WHERE Sub_Year_Category = '"+query+"' ORDER by ID Desc ",null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        return  cursor;
    }
    public Cursor ReadChem2015Question(){
        SQLiteDatabase db = getReadableDatabase();
        String query= "Chem215Q"  ;
        Cursor cursor = db.rawQuery("SELECT * FROM "+MyTable+" WHERE Sub_Year_Category = '"+query+"' ORDER by ID Desc ",null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        return  cursor;
    }
    public Cursor ReadChem2016Question(){
        SQLiteDatabase db = getReadableDatabase();
        String query= "Chem216Q"  ;
        Cursor cursor = db.rawQuery("SELECT * FROM "+MyTable+" WHERE Sub_Year_Category = '"+query+"' ORDER by ID Desc ",null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        return  cursor;
    }
    public Cursor ReadChem2017Question(){
        SQLiteDatabase db = getReadableDatabase();
        String query= "Chem217Q"  ;
        Cursor cursor = db.rawQuery("SELECT * FROM "+MyTable+" WHERE Sub_Year_Category = '"+query+"' ORDER by ID Desc ",null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        return  cursor;
    }
    public Cursor ReadChem2018Question(){
        SQLiteDatabase db = getReadableDatabase();
        String query= "Chem218Q"  ;
        Cursor cursor = db.rawQuery("SELECT * FROM "+MyTable+" WHERE Sub_Year_Category = '"+query+"' ORDER by ID Desc ",null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        return  cursor;
    }
    public Cursor ReadChem2019Question(){
        SQLiteDatabase db = getReadableDatabase();
        String query= "Chem219Q"  ;
        Cursor cursor = db.rawQuery("SELECT * FROM "+MyTable+" WHERE Sub_Year_Category = '"+query+"' ORDER by ID Desc ",null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        return  cursor;
    }
    public Cursor ReadChem2020Question(){
        SQLiteDatabase db = getReadableDatabase();
        String query= "Chem220Q"  ;
        Cursor cursor = db.rawQuery("SELECT * FROM "+MyTable+" WHERE Sub_Year_Category = '"+query+"' ORDER by ID Desc ",null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        return  cursor;
    }
    public Cursor ReadBio2015Question(){
        SQLiteDatabase db = getReadableDatabase();
        String query= "Bio215Q"  ;
        Cursor cursor = db.rawQuery("SELECT * FROM "+MyTable+" WHERE Sub_Year_Category = '"+query+"' ORDER by ID Desc ",null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        return  cursor;
    }
    public Cursor ReadBio2016Question(){
        SQLiteDatabase db = getReadableDatabase();
        String query= "Bio216Q"  ;
        Cursor cursor = db.rawQuery("SELECT * FROM "+MyTable+" WHERE Sub_Year_Category = '"+query+"' ORDER by ID Desc ",null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        return  cursor;
    }
    public Cursor ReadBio2017Question(){
        SQLiteDatabase db = getReadableDatabase();
        String query= "Bio217Q"  ;
        Cursor cursor = db.rawQuery("SELECT * FROM "+MyTable+" WHERE Sub_Year_Category = '"+query+"' ORDER by ID Desc ",null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        return  cursor;
    }
    public Cursor ReadBio2018Question(){
        SQLiteDatabase db = getReadableDatabase();
        String query= "Bio218Q"  ;
        Cursor cursor = db.rawQuery("SELECT * FROM "+MyTable+" WHERE Sub_Year_Category = '"+query+"' ORDER by ID Desc ",null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        return  cursor;
    }
    public Cursor ReadBio2019Question(){
        SQLiteDatabase db = getReadableDatabase();
        String query= "Bio219Q"  ;
        Cursor cursor = db.rawQuery("SELECT * FROM "+MyTable+" WHERE Sub_Year_Category = '"+query+"' ORDER by ID Desc ",null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        return  cursor;
    }
    public Cursor ReadBio2020Question(){
        SQLiteDatabase db = getReadableDatabase();
        String query= "Bio220Q"  ;
        Cursor cursor = db.rawQuery("SELECT * FROM "+MyTable+" WHERE Sub_Year_Category = '"+query+"' ORDER by ID Desc ",null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        return  cursor;
    }


}
