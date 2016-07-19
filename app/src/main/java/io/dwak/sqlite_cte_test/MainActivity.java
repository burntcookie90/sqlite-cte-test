package io.dwak.sqlite_cte_test;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteDatabase db = FamilyOpenHelper.getInstance(this).getReadableDatabase();
        Cursor cursor = db.rawQuery(Family.SELECT_ALL, new String[0]);
        Family map = Family.MAPPER.map(cursor);
        Log.d("main", map.toString());
    }
}
