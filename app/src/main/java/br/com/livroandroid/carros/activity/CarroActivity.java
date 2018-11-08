package br.com.livroandroid.carros.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import br.com.livroandroid.carros.R;
import br.com.livroandroid.carros.domain.Carro;
import br.com.livroandroid.carros.fragments.CarroFragment;
import br.com.livroandroid.carros.fragments.CarrosFragment;

public class CarroActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_carro);
        setUpToolbar();

        Carro c = (Carro)getIntent().getParcelableExtra("carro");
        getSupportActionBar().setTitle(c.nome);

        ImageView appBarImg = findViewById(R.id.appBarImg);
        Picasso.with(getContext()).load(c.urlFoto).into(appBarImg);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (b == null){
            CarroFragment frag = new CarroFragment();
            frag.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.CarroFragment, frag).commit();
        }
    }
}
