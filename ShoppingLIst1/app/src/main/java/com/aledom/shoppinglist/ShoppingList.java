package com.aledom.shoppinglist;

import androidx.annotation.*;
import androidx.room.*;

@Entity(tableName = "shopping_list")
public class ShoppingList {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private final String mId;

    @NonNull
    @ColumnInfo(name = "name")
    private final String mName;

    public ShoppingList(@NonNull String id, @NonNull String name) {
        mId = id;
        mName = name;
    }

    public String getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }
}
