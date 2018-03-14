package com.example.mytvapplication;

import android.content.Context;
import android.support.v17.leanback.widget.BaseCardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Created by 3NET01 on 14/03/2018.
 */

public class CardView extends BaseCardView {


    ImageView mPosterIV;


    TextView popularity;


    public CardView(Context context) {
        super(context);
        initLayout();
    }

    public CardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLayout();
    }

    public CardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLayout();
    }

    private void initLayout() {
        setFocusable(true);
        setFocusableInTouchMode(true);
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View v = inflater.inflate(getLayoutResource(), this);
        popularity = v.findViewById(R.id.popularity);
        mPosterIV = v.findViewById(R.id.poster_iv);
    }


    protected void bind(RandomUser.Result data) {
        Glide.with(getContext())
                .load(data.getPicture().getLarge())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(mPosterIV);
        popularity.setText(data.getName().getFirst());
    }

    public ImageView getPosterIV() {
        return mPosterIV;
    }

    protected int getLayoutResource() {
        return R.layout.card_view;
    }
}