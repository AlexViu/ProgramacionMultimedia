package com.aledom.matriculacionalumnos.data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.aledom.matriculacionalumnos.data.asignatura.Asignatura;
import com.aledom.matriculacionalumnos.data.asignatura.AsignaturaDao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Asignatura.class}, version = 1, exportSchema = false)
public abstract class MatriculacionDatabase extends RoomDatabase {

    public abstract AsignaturaDao AsignaturaDao();

    private static final String DATABASE_NAME = "Matriculacion-bd";

    private static MatriculacionDatabase INSTANCE;

    private static final int THREADS = 4;

    public static final ExecutorService dbExecutor = Executors.newFixedThreadPool(THREADS);

    public static MatriculacionDatabase getInstance(final Context context) {

        if (INSTANCE == null) {
            synchronized (MatriculacionDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(), MatriculacionDatabase.class,
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
                    AsignaturaDao dao = INSTANCE.AsignaturaDao();

                    List<Asignatura> lists = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        String id = UUID.randomUUID().toString();
                        lists.add(new Asignatura( "Lista " + (i+1)));
                    }

                    dao.insertAsignaturas(lists);
                });
            }
        };
}
