package com.example.mytvapplication;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by 3NET01 on 14/03/2018.
 */

public class VerticalGridActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            MyVerticalGridFragment fragment = new MyVerticalGridFragment();
            getFragmentManager().beginTransaction()
                    .replace(R.id.main_fragment, fragment)
                    .commit();
        }
    }
}
