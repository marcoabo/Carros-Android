package br.com.livroandroid.carros.activity;

import android.os.Bundle;

import br.com.livroandroid.carros.R;
import livroandroid.lib.activity.BaseActivity;

public class MainActivity extends br.com.livroandroid.carros.activity.BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar();
        setUpNavDrawer();
    }
}
