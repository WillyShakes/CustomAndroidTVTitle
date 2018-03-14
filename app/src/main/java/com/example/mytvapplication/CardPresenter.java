package com.example.mytvapplication;

import android.support.v17.leanback.widget.Presenter;
import android.view.ViewGroup;

/**
 * Created by 3NET01 on 14/03/2018.
 */

public class CardPresenter  extends Presenter {

    public CardPresenter() {
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new ViewHolder(new CardView(parent.getContext()));
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {
            ((CardView) viewHolder.view).bind((RandomUser.Result) item);
    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {

    }
}