package com.aledom.shoppinglist.data;

import android.content.*;
import androidx.lifecycle.*;

import com.aledom.shoppinglist.data.ShoppingList;
import com.aledom.shoppinglist.data.ShoppingListDao;
import com.aledom.shoppinglist.data.ShoppingListDatabase;

import java.util.*;

public class ShoppingListRepository {

    private final LiveData<List<ShoppingList>> mShoppingLists;
    private final ShoppingListDao mShoppingListDao;

    public ShoppingListRepository(Context context) {
        ShoppingListDatabase db = ShoppingListDatabase.getInstance(context);
        mShoppingListDao = db.shoppingListDao();
        mShoppingLists = mShoppingListDao.getAll();
    }

    public LiveData<List<ShoppingList>> getAllShoppingLists() {
        return mShoppingLists;
    }

    public void insert(ShoppingList shoppingList) {
        ShoppingListDatabase.dbExecutor.execute(
                () -> mShoppingListDao.insert(shoppingList)
        );
    }


}
