package br.com.livroandroid.carros.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.livroandroid.carros.R;
import br.com.livroandroid.carros.fragments.CarrosFragment;
import livroandroid.lib.activity.BaseActivity;

public class CarrosActivity extends br.com.livroandroid.carros.activity.BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carros);

        setUpToolbar();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String tipo = getString(getIntent().getIntExtra("tipo", 0));
        getSupportActionBar().setTitle(tipo);

        if (savedInstanceState == null){

            CarrosFragment frag = new CarrosFragment();
            frag.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.conteiner, frag).commit();
        }
    }
}
