package com.aledom.shoppinglist.data;

import android.content.*;
import androidx.lifecycle.*;

import com.aledom.shoppinglist.shoppinglists.ShoppingListForList;

import java.util.*;

public class ShoppingListRepository {

    private final ShoppingListDao mShoppingListDao;

    public ShoppingListRepository(Context context) {
        ShoppingListDatabase db = ShoppingListDatabase.getInstance(context);
        mShoppingListDao = db.shoppingListDao();
    }

    public LiveData<List<ShoppingListForList>> getShoppingLists() {
        return mShoppingListDao.getAll();
    }

    public LiveData<List<ShoppingListForList>> getShoppingListsWithCategories(List<String> categories) {
        return mShoppingListDao.getShoppingListsByCategories(categories);
    }

    public LiveData<ShoppingList> getShoppingList(String id){
        return mShoppingListDao.getShoppingList(id);
    }

    public void insert(ShoppingListInsert shoppingList) {
        ShoppingListDatabase.dbExecutor.execute(
                () -> mShoppingListDao.partialInsert(shoppingList)
        );
    }
}
