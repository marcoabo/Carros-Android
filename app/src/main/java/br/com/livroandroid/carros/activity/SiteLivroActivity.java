package br.com.livroandroid.carros.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.livroandroid.carros.R;
import livroandroid.lib.activity.BaseActivity;
import br.com.livroandroid.carros.fragments.SiteLivroFragment;

public class SiteLivroActivity extends br.com.livroandroid.carros.activity.BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site_livro);
        setUpToolbar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.site_do_livro);

        if (savedInstanceState == null){
            SiteLivroFragment frag = new SiteLivroFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.conteiner, frag).commit();
        }
    }
}
