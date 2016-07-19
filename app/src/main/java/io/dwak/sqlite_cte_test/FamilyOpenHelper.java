package io.dwak.sqlite_cte_test;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Calendar;

public final class FamilyOpenHelper extends SQLiteOpenHelper {
    private static FamilyOpenHelper INSTANCE;

    public static FamilyOpenHelper getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new FamilyOpenHelper(context);
        }
        return INSTANCE;
    }

    public FamilyOpenHelper(Context context) {
        super(context, null, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Family.CREATE_TABLE);
        db.insert(Family.TABLE_NAME,
            null,
            Family.FACTORY
                .marshal()
                .dad("dad")
                .mom("mom")
                .born(Calendar.getInstance().getTimeInMillis())
                .died(Calendar.getInstance().getTimeInMillis())
                .asContentValues());

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
