package com.example.atividade_03;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer_layout);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment selectedFragment = null;

                if (menuItem.getItemId() == R.id.nav_primeiro_periodo) {
                    selectedFragment = new PrimeiroPFragment();
                }
                if (menuItem.getItemId() == R.id.nav_segundo_periodo) {
                    selectedFragment = new SegundoPFragment();
                }
                if (menuItem.getItemId() == R.id.nav_terceiro_periodo) {
                    selectedFragment = new TerceiroPFragment();
                }
                if (menuItem.getItemId() == R.id.nav_quarto_periodo) {
                    selectedFragment = new QuartoPFragment();
                }
                if (menuItem.getItemId() == R.id.nav_quinto_periodo) {
                    selectedFragment = new QuintoPFragment();
                }
                if (menuItem.getItemId() == R.id.nav_sexto_periodo) {
                    selectedFragment = new SextoPFragment();
                }

                if (selectedFragment != null) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.content_frame, selectedFragment)
                            .commit();
                }

                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content_frame, new PrimeiroPFragment())
                    .commit();
        }

    }
}