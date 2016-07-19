package io.dwak.sqlite_cte_test;

import android.content.Context;
import io.requery.android.database.sqlite.SQLiteDatabase;
import io.requery.android.database.sqlite.SQLiteOpenHelper;

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
        super(context, "Family.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Family.CREATE_TABLE);
        db.insert(Family.TABLE_NAME,
            null,
            Family.FACTORY
                .marshal()
                .name("Willard")
                .born(Calendar.getInstance().getTimeInMillis())
                .asContentValues());
        db.insert(Family.TABLE_NAME,
            null,
            Family.FACTORY
                .marshal()
                .name("Caroline")
                .born(Calendar.getInstance().getTimeInMillis())
                .asContentValues());
        db.insert(Family.TABLE_NAME,
            null,
            Family.FACTORY
                .marshal()
                .name("Will")
                .dad("Willard")
                .mom("Caroline")
                .born(Calendar.getInstance().getTimeInMillis())
                .asContentValues());
        db.insert(Family.TABLE_NAME,
            null,
            Family.FACTORY
                .marshal()
                .name("Jaden")
                .dad("Will")
                .mom("Jada")
                .born(Calendar.getInstance().getTimeInMillis())
                .asContentValues());
        db.insert(Family.TABLE_NAME,
            null,
            Family.FACTORY
                .marshal()
                .name("Willow")
                .dad("Will")
                .mom("Jada")
                .born(Calendar.getInstance().getTimeInMillis())
                .asContentValues());
        db.insert(Family.TABLE_NAME,
            null,
            Family.FACTORY
                .marshal()
                .name("Trey")
                .dad("Will")
                .mom("Sheree")
                .born(Calendar.getInstance().getTimeInMillis())
                .asContentValues());

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
