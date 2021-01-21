package com.aledom.shoppinglist.data;

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

    @Nullable
    @ColumnInfo(name = "category")
    private final String mCategory;

    @ColumnInfo(name = "created_date", defaultValue = "CURRENT_TIMESTAMP")
    private final String mCreatedDate;

    @ColumnInfo(name = "last_updated", defaultValue = "CURRENT_TIMESTAMP")
    private final String mLastUpdated;

    public ShoppingList(@NonNull String id, @NonNull String name, @Nullable String category, String mCreatedDate, String mLastUpdated) {
        mId = id;
        mName = name;
        mCategory = category;
        this.mCreatedDate = mCreatedDate;
        this.mLastUpdated = mLastUpdated;
    }

    public String getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }
}
