package com.example.missi.pruebainterfaz;

import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, FragmentNotice.OnFragmentInteractionListener {
    private ArrayList<Heroes>heroes;
    private String filter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.heroes = generarHeroes();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             dialog();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        MainFragment fragment = new MainFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.mainView,fragment);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.nav_camera) {
            FragmentNotice fragmentNotice = new FragmentNotice();
            fragmentNotice.setHeroes(generarHeroes());
            getSupportFragmentManager().beginTransaction().replace(R.id.mainView,fragmentNotice).commit();

        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public ArrayList generarHeroes(){
        ArrayList<Heroes> heroes = new ArrayList<>();
        heroes.add(new Heroes("Abadon",4,0,9,"Green","BORROWED TIME",R.drawable.abaddon));
        heroes.add(new Heroes("Axe",7,2,11,"Red","BERSERKER CALL",R.drawable.axe));
        heroes.add(new Heroes("Beastmaster",5,0,12,"Red","CALL OF THE WILD",R.drawable.beastmaster));
        heroes.add(new Heroes("Bloodseeker",7,0,6,"Black","BLOOD BATH",R.drawable.bloodseeker));
        heroes.add(new Heroes("Bounty Hunter",7,0,7,"Black","JINADA",R.drawable.bounty_hunter));
        heroes.add(new Heroes("Bristleback",8,0,12,"Red","BARROOM BRAWLER",R.drawable.bristleback));
        heroes.add(new Heroes("Centaur Warrunner",4,0,14,"Red","RETURN",R.drawable.centaur_warrunner));
        heroes.add(new Heroes("Chen",4,0,9,"Green","HOLY PERSUASION",R.drawable.chen));
        heroes.add(new Heroes("Crystal Maiden",2,0,5,"Blue","ARCANE AURA",R.drawable.crystal_maiden));
        heroes.add(new Heroes("Dark Seer",5,0,9,"Green","SURGE",R.drawable.dark_seer));
        heroes.add(new Heroes("Debbi the Cunning",7,0,5,"Black","METICULOUS PLANNER",R.drawable.debbi));
        heroes.add(new Heroes("Drow Ranger",4,0,7,"Green","PRECISION AURA",R.drawable.drow_ranger));
        heroes.add(new Heroes("Earthshaker",2,0,7,"Blue","FISSURE",R.drawable.earthshaker));
        heroes.add(new Heroes("Echantress",4,0,8,"Green","NATURE'S ATTEND",R.drawable.enchantress));
        heroes.add(new Heroes("Farvhan the Dreamer",4,0,10,"Green","PACK LEADERSHIP",R.drawable.farvhan));



        return  heroes;
    }
    public void dialog(){
        final String colors [] = {"Black","Red","Blue","Green"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Filtro : ");
        String oldFilter = this.filter;
        this.filter = null;
        builder.setSingleChoiceItems( colors,-1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                filter = colors[which];
                if (filter != null ){
                    System.out.println("Hola");
                    ArrayList<Heroes>heroes = heroesWithFilter(filter);
                    FragmentNotice fragmentNotice = new FragmentNotice();
                    fragmentNotice.setHeroes(heroes);
                    getSupportFragmentManager().beginTransaction().replace(R.id.mainView,fragmentNotice).commit();
                }


            }
        });
        builder.show();



    }
    public ArrayList<Heroes> heroesWithFilter(String filter){
        ArrayList<Heroes> heroes = new ArrayList<>();
        for (int i = 0; i <this.heroes.size() ; i++) {
            if (this.heroes.get(i).getColor().equals(filter)){
                heroes.add(this.heroes.get(i));
            }
        }
        return heroes;
    }
    @Override
    public void onFragmentInteraction(Uri uri) {
    }
}
