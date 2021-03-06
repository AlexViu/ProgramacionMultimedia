package com.aledom.shoppinglist;

import android.content.*;

import androidx.annotation.*;
import androidx.room.*;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.util.concurrent.*;


@Database(entities = {ShoppingList.class}, version = 1, exportSchema = false)
public abstract class ShoppingListDatabase extends RoomDatabase {

    // Exposición de DAOs
    public abstract ShoppingListDao shoppingListDao();

    private static final String DATABASE_NAME = "shopping-list-db";

    private static ShoppingListDatabase INSTANCE;

    private static final int THREADS = 4;

    public static final ExecutorService dbExecutor = Executors.newFixedThreadPool(THREADS);

    public static ShoppingListDatabase getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (ShoppingListDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(), ShoppingListDatabase.class,
                            DATABASE_NAME)
                            .addCallback(mRoomCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static final RoomDatabase.Callback mRoomCallback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            dbExecutor.execute(() -> {
                ShoppingListDao dao = INSTANCE.shoppingListDao();

                ShoppingList list1 = new ShoppingList("1", "Lista de ejemplo");
                ShoppingList list2 = new ShoppingList("2", "Banquete de Navidad");

                dao.insert(list1);
                dao.insert(list2);
            });
        }
    };
}
