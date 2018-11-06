package br.com.livroandroid.carros.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.livroandroid.carros.R;

public class BaseActivity extends livroandroid.lib.activity.BaseActivity {

    protected DrawerLayout drawerLayout;

    // Configura a Toolbar
    protected void setUpToolbar(){

        Toolbar toolbar = findViewById(R.id.toolbar);

        if (toolbar != null){
            setSupportActionBar(toolbar);
        }
    }

    // Configura a Nav Drawer
    protected void setUpNavDrawer(){

        final ActionBar actionBar = getSupportActionBar();

        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        actionBar.setDisplayHomeAsUpEnabled(true);
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        if (navigationView != null && drawerLayout != null){
            setNavViewValues(
                    navigationView,
                    R.string.nav_drawer_username,
                    R.string.nav_drawer_email,
                    R.mipmap.ic_launcher);

            navigationView.setNavigationItemSelectedListener(
                    new NavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                            menuItem.setCheckable(true);
                            drawerLayout.closeDrawers();
                            onNavDrawerItemSelected(menuItem);

                            return true;
                        }
                    }
            );
        }
    }

    private void onNavDrawerItemSelected(MenuItem menuItem) {

        switch (menuItem.getItemId()){

            case R.id.nav_item_carros_todos:
                toast("Clicou em carros");
                break;
            case R.id.nav_item_carros_classicos:
                Intent intent = new Intent(getContext(), CarrosActivity.class);
                intent.putExtra("tipo", R.string.classicos);
                startActivity(intent);
                break;
            case R.id.nav_item_carros_esportivos:
                intent = new Intent(getContext(), CarrosActivity.class);
                intent.putExtra("tipo", R.string.esportivos);
                startActivity(intent);
                break;
            case R.id.nav_item_carros_luxo:
                intent = new Intent(getContext(), CarrosActivity.class);
                intent.putExtra("tipo", R.string.luxo);
                startActivity(intent);
                break;
            case R.id.nav_item_site_livro:
                intent = new Intent(getContext(), SiteLivroActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_item_settings:
                toast("Clicou em configurações");
                break;
        }
    }

    private static void setNavViewValues(NavigationView navView, int nome, int email, int img) {

        View headerView = navView.getHeaderView(0);
        TextView tNome = headerView.findViewById(R.id.tNome);
        TextView tEmail = headerView.findViewById(R.id.tEmail);
        ImageView imgView = headerView.findViewById(R.id.img);

        tNome.setText(nome);
        tEmail.setText(email);
        imgView.setImageResource(img);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch(item.getItemId()){
            case android.R.id.home:
                if (drawerLayout != null) {
                    openDrawer();
                    return true;
                }
        }

        return super.onOptionsItemSelected(item);
    }

    protected void openDrawer() {
        if(drawerLayout != null){
            drawerLayout.openDrawer(GravityCompat.START);
        }
    }

    protected void closeDrawer(){
        if(drawerLayout != null){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
}
