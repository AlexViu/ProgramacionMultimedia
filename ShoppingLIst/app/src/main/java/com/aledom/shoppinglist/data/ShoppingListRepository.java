package com.aledom.shoppinglist.data;

import android.content.*;
import androidx.lifecycle.*;

import com.aledom.shoppinglist.shoppinglists.ShoppingListForList;

import java.util.*;

public class ShoppingListRepository {

    private final LiveData<List<ShoppingListForList>> mShoppingLists;
    private final ShoppingListDao mShoppingListDao;

    public ShoppingListRepository(Context context) {
        ShoppingListDatabase db = ShoppingListDatabase.getInstance(context);
        mShoppingListDao = db.shoppingListDao();
        mShoppingLists = mShoppingListDao.getAll();
    }

    public LiveData<List<ShoppingListForList>> getAllShoppingLists() {
        return mShoppingLists;
    }

    public void insert(ShoppingListInsert shoppingList) {
        ShoppingListDatabase.dbExecutor.execute(
                () -> mShoppingListDao.insert(shoppingList)
        );
    }


    public LiveData<List<ShoppingListForList>> getShoppingLists() {
        return mShoppingListDao.getAll();
    }

    public LiveData<List<ShoppingListForList>> getShoppingListsWithCategories(List<String> categories) {
        return mShoppingListDao.getShoppingListsByCategories(categories);
    }
}
