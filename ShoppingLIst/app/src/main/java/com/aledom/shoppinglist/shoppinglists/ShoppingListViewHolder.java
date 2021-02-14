package com.aledom.shoppinglist.shoppinglists;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aledom.shoppinglist.R;
import com.aledom.shoppinglist.data.ShoppingList;

public class ShoppingListViewHolder extends RecyclerView.ViewHolder{
    private final TextView mNameText;
    private final CheckBox mFavoriteButton;

    public ShoppingListViewHolder(@NonNull View itemView) {
        super(itemView);
        mNameText = itemView.findViewById(R.id.name);
        mFavoriteButton = itemView.findViewById(R.id.favorite_button);

        // Setear eventos
        mFavoriteButton.setOnClickListener(this::manageEvents);
        itemView.setOnClickListener(this::manageEvents);
    }

    private void manageEvents(View view) {
        if (mItemListener != null) {
            ShoppingListForList clickedItem = mShoppingLists.get(getAdapterPosition());

            // Manejar evento de click en Favorito
            if (view.getId() == R.id.favorite_button) {
                mItemListener.onFavoriteIconClicked(clickedItem);
                return;
            }

            mItemListener.onClick(clickedItem);
        }
    }

    public void bind(ShoppingListForList item) {
        mNameText.setText(item.name);
        mFavoriteButton.setChecked(item.favorite);
    }
}
