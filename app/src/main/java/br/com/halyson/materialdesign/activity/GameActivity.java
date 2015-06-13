package br.com.halyson.materialdesign.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.heinrichreimersoftware.materialdrawer.DrawerActivity;
import com.heinrichreimersoftware.materialdrawer.DrawerView;
import com.heinrichreimersoftware.materialdrawer.structure.DrawerItem;
import com.heinrichreimersoftware.materialdrawer.structure.DrawerProfile;

import java.util.concurrent.ExecutionException;

import br.com.halyson.materialdesign.R;
import br.com.halyson.materialdesign.fragment.SendToServer;
import br.com.halyson.materialdesign.gamefragments.AboutFragment;
import br.com.halyson.materialdesign.gamefragments.GameFragment;
import br.com.halyson.materialdesign.gamefragments.SettingsFragment;
import br.com.halyson.materialdesign.gamefragments.StoreFragment;

public class GameActivity extends DrawerActivity {

    private DrawerView drawer;

    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        //INSTANCIRANJE


        //Povrati cookie
        final String COOKIE;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                COOKIE = null;
            } else {
                COOKIE = extras.getString("cookie");
            }
        } else {
            COOKIE = (String) savedInstanceState.getSerializable("cookie");
        }
        //Toast.makeText(getApplicationContext(), "cookie = " + COOKIE, Toast.LENGTH_SHORT ).show();

        //Povrati username
        final String USERNAME;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                USERNAME = null;
            } else {
                USERNAME = extras.getString("username");
            }
        } else {
            USERNAME = (String) savedInstanceState.getSerializable("username");
        }

        //GET DATA FROM SERVER
        AsyncTask task = new SendToServer().execute("getdata", USERNAME, COOKIE);
        String message = null;
        try {
            message = task.get().toString();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        String[] splitano = message.split(",");
        //Toast.makeText(getApplicationContext(), "cookie = " + message, Toast.LENGTH_LONG ).show();
        Toast.makeText(getApplicationContext(), "balance = " + splitano[splitano.length-1], Toast.LENGTH_SHORT ).show();


        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawer = (DrawerView) findViewById(R.id.drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        //drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

        setSupportActionBar(toolbar);


        drawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close
        ) {

            public void onDrawerClosed(View view) {
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                invalidateOptionsMenu();
            }
        };

        drawerLayout.setStatusBarBackgroundColor(getResources().getColor(R.color.color_primary_dark));
        drawerLayout.setDrawerListener(drawerToggle);
        drawerLayout.closeDrawer(drawer);


        /*drawer.addItem(new DrawerItem()
                        .setTextPrimary(getString(R.string.lorem_ipsum_short))
                        .setTextSecondary(getString(R.string.lorem_ipsum_long))
        );*/
        drawer.addItem(new DrawerItem()
                        .setImage(getResources().getDrawable(R.drawable.game))
                                //.setTextPrimary(getString(R.string.lorem_ipsum_short))
                        .setTextPrimary("Game")
                                //.setTextSecondary(getString(R.string.lorem_ipsum_long))
                        //.setTextSecondary("Buy credit and more...")
        );

        drawer.addDivider();

        drawer.addItem(new DrawerItem()
                        .setImage(getResources().getDrawable(R.drawable.store))
                                //.setTextPrimary(getString(R.string.lorem_ipsum_short))
                        .setTextPrimary("Store")
                                //.setTextSecondary(getString(R.string.lorem_ipsum_long))
                        .setTextSecondary("Buy credit and more...")
        );

        drawer.addDivider();


        drawer.addItem(new DrawerItem()
                        .setImage(getResources().getDrawable(R.drawable.settings))
                                //.setTextPrimary(getString(R.string.lorem_ipsum_short))
                        .setTextPrimary("Settings")
                                //.setTextSecondary(getString(R.string.lorem_ipsum_long))
                        .setTextSecondary("Customise your PaiGow app!")
        );

        drawer.addDivider();

        drawer.addItem(new DrawerItem()
                        .setImage(getResources().getDrawable(R.drawable.info))
                                //.setTextPrimary(getString(R.string.lorem_ipsum_short))
                        .setTextPrimary("About")
                                //.setTextSecondary(getString(R.string.lorem_ipsum_long))
                        .setTextSecondary("Additional info andd rules!")
        );

        drawer.addDivider();


        drawer.selectItem(1);
        drawer.setOnItemClickListener(new DrawerItem.OnItemClickListener() {
            @Override
            public void onClick(DrawerItem item, long id, int position) {
                drawer.selectItem(position);
                //Toast.makeText(GameActivity.this, "Clicked item #" + position, Toast.LENGTH_SHORT).show();
                //Intent myIntent = new Intent(GameActivity.this, StoreActivity.class);
                //myIntent.putExtra("key", value); //Optional parameters
                //GameActivity.this.startActivity(myIntent);

                /*Toast.makeText(getApplicationContext(), "position = " + position,
                        Toast.LENGTH_SHORT ).show();*/

                Fragment fr = null;
                FragmentManager fm = getFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();

                if( position == 0 )  {
                    fr = new GameFragment();
                    fragmentTransaction.replace(R.id.fragment_place, fr);
                    fragmentTransaction.commit();

                } else if ( position == 2 ) {
                    fr = new StoreFragment();
                    fragmentTransaction.replace(R.id.fragment_place, fr);
                    fragmentTransaction.commit();

                } else if ( position == 4 ) {
                    fr = new SettingsFragment();
                    fragmentTransaction.replace(R.id.fragment_place, fr);
                    fragmentTransaction.commit();

                } else if ( position == 6 ) {
                    fr = new AboutFragment();
                    fragmentTransaction.replace(R.id.fragment_place, fr);
                    fragmentTransaction.commit();

                } else if ( position == 8 ) {
                    AsyncTask task = new SendToServer().execute("logout",USERNAME,COOKIE);
                    try {
                        String message = task.get().toString();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                    Intent myIntent = new Intent(GameActivity.this, HomeActivity.class);
                    GameActivity.this.startActivity(myIntent);
                    finish();
                }


                /*OSNOVNO PREBACIVANJE FRAGMENATA:
                Fragment fr = new StoreFragment();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_place, fr);
                fragmentTransaction.commit();*/
            }
        });


        drawer.addItem(new DrawerItem()
                        .setImage(getResources().getDrawable(R.drawable.logout))
                                //.setTextPrimary(getString(R.string.lorem_ipsum_short))
                        .setTextPrimary("Logout")
                //.setTextSecondary(getString(R.string.lorem_ipsum_long))
                //.setTextSecondary("Buy credit and more...")
        );

        /*drawer.addFixedItem(new DrawerItem()
                        .setRoundedImage((BitmapDrawable) getResources().getDrawable(R.drawable.cat_2), DrawerItem.SMALL_AVATAR)
                                //.setTextPrimary(getString(R.string.lorem_ipsum_short))
                        .setTextPrimary("Logout")
        );*/

        /*drawer.addFixedItem(new DrawerItem()
                        .setImage(getResources().getDrawable(R.drawable.ic_flag))
                        .setTextPrimary(getString(R.string.lorem_ipsum_short))
        );

        drawer.setOnFixedItemClickListener(new DrawerItem.OnItemClickListener() {
            @Override
            public void onClick(DrawerItem item, long id, int position) {
                drawer.selectFixedItem(position);
                Toast.makeText(GameActivity.this, "Clicked fixed item #" + position, Toast.LENGTH_SHORT).show();
            }
        });*/


        drawer.addProfile(new DrawerProfile()
                        .setId(1)
                                //.setRoundedAvatar((BitmapDrawable) getResources().getDrawable(R.drawable.cat_1))
                        .setBackground(getResources().getDrawable(R.drawable.drawer_background))
                        .setBackground(getResources().getDrawable(R.drawable.drawer_background))
                        //.setName("PaiGow")
                //.setName(getString(R.string.lorem_ipsum_short))
                //.setDescription(getString(R.string.lorem_ipsum_medium))
        );

        /*drawer.addProfile(new DrawerProfile()
                        .setId(2)
                        .setRoundedAvatar((BitmapDrawable) getResources().getDrawable(R.drawable.cat_2))
                        .setBackground(getResources().getDrawable(R.drawable.cat_wide_1))
                        .setName(getString(R.string.lorem_ipsum_short))
        );

        drawer.addProfile(new DrawerProfile()
                        .setId(3)
                        .setRoundedAvatar((BitmapDrawable) getResources().getDrawable(R.drawable.cat_1))
                        .setBackground(getResources().getDrawable(R.drawable.cat_wide_2))
                        .setName(getString(R.string.lorem_ipsum_short))
                        .setDescription(getString(R.string.lorem_ipsum_medium))
        );*/


        /*drawer.setOnProfileClickListener(new DrawerProfile.OnProfileClickListener() {
            @Override
            public void onClick(DrawerProfile profile, long id) {
                Toast.makeText(GameActivity.this, "Clicked profile *" + id, Toast.LENGTH_SHORT).show();
            }
        });
        drawer.setOnProfileSwitchListener(new DrawerProfile.OnProfileSwitchListener() {
            @Override
            public void onSwitch(DrawerProfile oldProfile, long oldId, DrawerProfile newProfile, long newId) {
                Toast.makeText(GameActivity.this, "Switched from profile *" + oldId + " to profile *" + newId, Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    public void openDrawerFrameLayout(View view) {
        //Intent intent = new Intent(this, MainActivity2.class);
       // startActivity(intent);
    }

    public void openDrawerActivity(View view) {
        //Intent intent = new Intent(this, MainActivity3.class);
        //startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        /*switch (item.getItemId()) {
            case R.id.action_github:
                String url = "https://github.com/HeinrichReimer/material-drawer";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                break;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }
}