package com.example.sparkapplication.sparkandroidapplication.LandingPage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sparkapplication.R;
import com.example.sparkapplication.sparkandroidapplication.Home.HomeFragment;
import com.example.sparkapplication.sparkandroidapplication.Space.SpaceFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class LandingActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    ImageView ivNavigationIcon,ivViewPointAndBadges;
    FloatingActionButton createPointANdBadges_floater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        //open points and badges dialog
        openPointAndBadgesDialog();
        //call all ids here
        drawerLayout = findViewById(R.id.my_drawer_layout);
        navigationView=findViewById(R.id.navigationView);
        ivNavigationIcon=findViewById(R.id.ivNavigationIcon);
        ivViewPointAndBadges=findViewById(R.id.ivViewPointAndBadges);
        ivViewPointAndBadges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPointAndBadgesDialog();
            }
        });
        createPointANdBadges_floater=(FloatingActionButton)findViewById(R.id.createPointANdBadges_floater);
        createPointANdBadges_floater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCreateNewDialog();
            }
        });
        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.replace(R.id.fragment_container, new HomeFragment());
        tx.commit();
        //call all functions here
        setDrawerLayout(navigationView);
        openNavigation();
    }
    public void openPointAndBadgesDialog(){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView= inflater.inflate(R.layout.cardview_pointandbadges, null);
        dialogBuilder.setView(dialogView);
        ImageView imsgCross=(ImageView)dialogView.findViewById(R.id.imgCross);
        AlertDialog alertDialog = dialogBuilder.create();
        imsgCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }
    public void setDrawerLayout(NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectDrawerItem(item);
                return true;
            }
        });
    }
    public void selectDrawerItem(MenuItem menuItem){
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        switch (menuItem.getItemId()){
            case R.id.nav_home:
                HomeFragment homeFragment=new HomeFragment();
                fragmentTransaction.replace(R.id.fragment_container,homeFragment).commit();
                break;
            case R.id.nav_space:
                SpaceFragment spaceFragment=new SpaceFragment();
                fragmentTransaction.replace(R.id.fragment_container,spaceFragment).commit();
                break;
            case R.id.nav_createNew:
                openCreateNewDialog();
                break;
            default:

        }

        drawerLayout.closeDrawers();
    }
    public void openNavigation(){
        ivNavigationIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionBarDrawerToggle=setupDrawerToggle();
                drawerLayout.addDrawerListener(actionBarDrawerToggle);
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }
    public void openCreateNewDialog(){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView= inflater.inflate(R.layout.cardview_create_new, null);
        dialogBuilder.setView(dialogView);
        AlertDialog alertDialog = dialogBuilder.create();
        TextView txtlblCancel=(TextView)dialogView.findViewById(R.id.txtlblCancel);
        txtlblCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
        ImageView imsgCross=(ImageView)dialogView.findViewById(R.id.imgCross);
        imsgCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }
    private ActionBarDrawerToggle setupDrawerToggle(){
        return new ActionBarDrawerToggle(this,drawerLayout,R.string.nav_open,R.string.nav_close);

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            actionBarDrawerToggle.syncState();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}