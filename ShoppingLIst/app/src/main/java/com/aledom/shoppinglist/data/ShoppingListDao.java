package com.aledom.shoppinglist.data;

import androidx.lifecycle.*;
import androidx.room.*;

import com.aledom.shoppinglist.data.ShoppingList;
import com.aledom.shoppinglist.shoppinglists.ShoppingListForList;

import java.util.*;

@Dao
public interface ShoppingListDao {

    @Query("SELECT id, name FROM shopping_list")
    LiveData<List<ShoppingListForList>> getAll();

    @Query("SELECT id, name FROM shopping_list WHERE category IN(:categories)")
    LiveData<List<ShoppingListForList>> getShoppingListsByCategories(List<String> categories);

    @Insert(onConflict = OnConflictStrategy.IGNORE, entity = ShoppingList.class)
    void partialInsert(ShoppingListInsert shoppingList);

    @Insert(onConflict = OnConflictStrategy.IGNORE, entity = ShoppingList.class)
    void insertShoppingLists(List<ShoppingListInsert> lists);

}
