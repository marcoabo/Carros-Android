package br.com.livroandroid.carros.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.View;

import br.com.livroandroid.carros.R;
import br.com.livroandroid.carros.adapter.TabsAdapter;
import livroandroid.lib.activity.BaseActivity;

public class MainActivity extends br.com.livroandroid.carros.activity.BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar();
        setUpNavDrawer();
        setUpPagerTabs();

        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                snack(view, "Exemplo de FAB.");
            }
        });
    }

    private void setUpPagerTabs() {

        final ViewPager viewPager = (ViewPager)findViewById(R.id.viewPager);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(new TabsAdapter(getContext(), getSupportFragmentManager()));

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        int cor = ContextCompat.getColor(getContext(), R.color.white);
        tabLayout.setTabTextColors(cor, cor);
    }
}
