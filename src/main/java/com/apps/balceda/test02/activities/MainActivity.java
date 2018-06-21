package com.apps.balceda.test02.activities;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.apps.balceda.test02.R;
import com.apps.balceda.test02.fragments.PendientesFragment;
import com.apps.balceda.test02.fragments.PrincipalFragment;
import com.apps.balceda.test02.fragments.SupermercadoFragment;
import com.apps.balceda.test02.fragments.VacacionesFragment;

public class MainActivity extends AppCompatActivity {

  Toolbar toolbar;
  NavigationView navigationView;
  DrawerLayout drawerLayout;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    navigationView = findViewById(R.id.navigationView);
    drawerLayout = findViewById(R.id.drawer);

    navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
      @Override
      public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.isChecked()) item.setChecked(false);
        else item.setChecked(true);

        drawerLayout.closeDrawers();

        switch (item.getItemId()) {
          case R.id.principal:
            setFragment(0);
            break;
          case R.id.supermercado:
            setFragment(1);
            break;
          case R.id.pendiente:
            setFragment(2);
            break;
          case R.id.vacaciones:
            setFragment(3);
            break;
        }

        return false;
      }
    });

    ActionBarDrawerToggle actionBarDrawerToggle =
      new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close) {
        @Override
        public void onDrawerOpened(View drawerView) {
          super.onDrawerOpened(drawerView);
        }

        @Override
        public void onDrawerClosed(View drawerView) {
          super.onDrawerClosed(drawerView);
        }
      };

    drawerLayout.addDrawerListener(actionBarDrawerToggle);
    actionBarDrawerToggle.syncState();

    setFragment(0);
  }

  public void setFragment(int pos) {
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction transaction = fragmentManager.beginTransaction();

    switch (pos) {
      case 0:
        PrincipalFragment principalFragment = new PrincipalFragment();
        transaction.replace(R.id.fragment, principalFragment);
        transaction.commit();
        Toast.makeText(getApplicationContext(), "Principal", Toast.LENGTH_LONG).show();
        break;
      case 1:
        SupermercadoFragment supermercadoFragment = new SupermercadoFragment();
        transaction.replace(R.id.fragment, supermercadoFragment);
        transaction.commit();
        Toast.makeText(getApplicationContext(), "Supermercado", Toast.LENGTH_LONG).show();
        break;
      case 2:
        PendientesFragment pendientesFragment = new PendientesFragment();
        transaction.replace(R.id.fragment, pendientesFragment);
        transaction.commit();
        Toast.makeText(getApplicationContext(), "Pendientes", Toast.LENGTH_LONG).show();
        break;
      case 3:
        VacacionesFragment vacacionesFragment = new VacacionesFragment();
        transaction.replace(R.id.fragment, vacacionesFragment);
        transaction.commit();
        Toast.makeText(getApplicationContext(), "Vacaciones", Toast.LENGTH_LONG).show();
        break;
    }
  }
}
