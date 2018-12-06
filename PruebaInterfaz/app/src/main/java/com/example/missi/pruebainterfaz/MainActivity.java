package com.example.missi.pruebainterfaz;

import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
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
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, FragmentNotice.OnFragmentInteractionListener, RcVFragment.OnFragmentInteractionListener , FragmentData.OnFragmentInteractionListener{
    private ArrayList<Carta> cartas;
    private String filter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.cartas = generarCartas();
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
        getSupportFragmentManager().beginTransaction().add(R.id.mainView,fragment).commit();
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
            fragmentNotice.setHeroes(getHeroes());
            getSupportFragmentManager().beginTransaction().replace(R.id.mainView,fragmentNotice).commit();

        } else if (id == R.id.nav_gallery) {
            RcVFragment fragment = new RcVFragment();
            fragment.setCartas(cartas);
            fragment.setMainActivity(this);
            getSupportFragmentManager().beginTransaction().replace(R.id.mainView,fragment).commit();

        } else if (id == R.id.nav_slideshow) {
            MainFragment fragment = new MainFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.mainView,fragment).commit();

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public ArrayList generarCartas(){
        ArrayList<Carta> cartasLista = new ArrayList<>();
        cartasLista.add(new Heroe("Abadon",4,0,9,"Green","BORROWED TIME",R.drawable.abaddon));
        cartasLista.add(new Heroe("Axe",7,2,11,"Red","BERSERKER CALL",R.drawable.axe));
        cartasLista.add(new Heroe("Beastmaster",5,0,12,"Red","CALL OF THE WILD",R.drawable.beastmaster));
        cartasLista.add(new Heroe("Bloodseeker",7,0,6,"Black","BLOOD BATH",R.drawable.bloodseeker));
        cartasLista.add(new Heroe("Bounty Hunter",7,0,7,"Black","JINADA",R.drawable.bounty_hunter));
        cartasLista.add(new Heroe("Bristleback",8,0,12,"Red","BARROOM BRAWLER",R.drawable.bristleback));
        cartasLista.add(new Heroe("Centaur Warrunner",4,0,14,"Red","RETURN",R.drawable.centaur_warrunner));
        cartasLista.add(new Heroe("Chen",4,0,9,"Green","HOLY PERSUASION",R.drawable.chen));
        cartasLista.add(new Heroe("Crystal Maiden",2,0,5,"Blue","ARCANE AURA",R.drawable.crystal_maiden));
        cartasLista.add(new Heroe("Dark Seer",5,0,9,"Green","SURGE",R.drawable.dark_seer));
        cartasLista.add(new Heroe("Debbi the Cunning",7,0,5,"Black","METICULOUS PLANNER",R.drawable.debbi));
        cartasLista.add(new Heroe("Drow Ranger",4,0,7,"Green","PRECISION AURA",R.drawable.drow_ranger));
        cartasLista.add(new Heroe("Earthshaker",2,0,7,"Blue","FISSURE",R.drawable.earthshaker));
        cartasLista.add(new Heroe("Echantress",4,0,8,"Green","NATURE'S ATTEND",R.drawable.enchantress));
        cartasLista.add(new Heroe("Farvhan the Dreamer",4,0,10,"Green","PACK LEADERSHIP",R.drawable.farvhan));
        cartasLista.add(new Spell("Bolt of Damocles",R.drawable.bolt_of_damocles,"Blue",10,"Deal 20 damage to the enemy tower"));
        cartasLista.add(new Spell("Act of Defiance",R.drawable.act_of_defiance,"Green",5,"Silence a unit this round"));
        cartasLista.add(new Spell("Allseeing One's Favor",R.drawable.allseeing_ones_favor,"Green",5,"Silence a unit this round"));
        Collections.sort(cartasLista);
        return  cartasLista;
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
                    ArrayList<Heroe>heroes = heroesWithFilter(filter);
                    FragmentNotice fragmentNotice = new FragmentNotice();
                    fragmentNotice.setHeroes(heroes);
                    getSupportFragmentManager().beginTransaction().replace(R.id.mainView,fragmentNotice).commit();
                }


            }
        });
        builder.show();



    }
    public ArrayList<Heroe> heroesWithFilter(String filter){
        ArrayList<Heroe> heroes = new ArrayList<>();
        for (int i = 0; i <this.cartas.size() ; i++) {
            if (this.cartas.get(i).getColor().equals(filter)){
                heroes.add((Heroe) this.cartas.get(i));
            }
        }
        return heroes;
    }
    public ArrayList<Heroe>getHeroes(){
                ArrayList<Heroe> heroes = new ArrayList<>();
        for (int i = 0; i <this.cartas.size(); i++) {
            if (this.cartas.get(i).getClass() == Heroe.class){
                heroes.add((Heroe) this.cartas.get(i));
            }
        }



        return heroes;
    }
    public   void cargarFrament(Carta carta){
        FragmentData fragmentData = new FragmentData();
        fragmentData.setCarta(carta);
        getSupportFragmentManager().beginTransaction().replace(R.id.mainView,fragmentData).commit();
    }
    @Override
    public void onFragmentInteraction(Uri uri) {
    }
}
