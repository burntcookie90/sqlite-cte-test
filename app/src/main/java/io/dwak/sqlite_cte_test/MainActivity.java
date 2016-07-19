package io.dwak.sqlite_cte_test;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import io.requery.android.database.sqlite.SQLiteDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteDatabase db = FamilyOpenHelper.getInstance(this).getReadableDatabase();
        Cursor cursor = db.rawQuery(Family.SELECT_ANCESTORS, new String[0]);
        while(cursor.moveToNext()){
            Log.d("main", Family.MAPPER.map(cursor).toString());
        }
        cursor.close();
        db.close();
    }
}
