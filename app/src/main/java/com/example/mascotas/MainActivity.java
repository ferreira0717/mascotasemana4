package com.example.mascotas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mascotas.db.BaseDatos;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private ImageView imageView3;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabhome);
        viewPager = findViewById(R.id.viewpagermain);

        toolbar = findViewById(R.id.toolbarcontacto);
        setSupportActionBar(toolbar);

        imageView3 = findViewById(R.id.icono3);


        if(toolbar != null){
            setSupportActionBar(toolbar);
        }

        setupViewPager();


    }

    private ArrayList<Fragment> agregarFragment(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new FragmentHome());
        fragments.add(new FragmentPerfil());

        return fragments;
    }

    public void setupViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, agregarFragment()));
        tabLayout.setupWithViewPager(viewPager);
        BaseDatos db = new BaseDatos(getApplicationContext());
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_page);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent i;
        switch (item.getItemId()){
            case R.id.opcion1:
                i = new Intent(this,Contacto.class);
                startActivity(i);
                break;
            case R.id.opcion2:
                i = new Intent(this,Acercade.class);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}