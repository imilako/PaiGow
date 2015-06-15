package br.com.halyson.materialdesign.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
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
import br.com.halyson.materialdesign.backend.Calculate;
import br.com.halyson.materialdesign.backend.Draw;
import br.com.halyson.materialdesign.backend.HouseWay;
import br.com.halyson.materialdesign.backend.HouseWay2;
import br.com.halyson.materialdesign.backend.Language;
import br.com.halyson.materialdesign.fragment.SendToServer;
import br.com.halyson.materialdesign.gamefragments.AboutFragment;
import br.com.halyson.materialdesign.gamefragments.GameFragment;
import br.com.halyson.materialdesign.gamefragments.SettingsFragment;
import br.com.halyson.materialdesign.gamefragments.StoreFragment;

public class GameActivity extends DrawerActivity {

    //private DrawerView drawer;

    //private ActionBarDrawerToggle drawerToggle;

    public String STS_COOKIE;
    public String STS_USERNAME;
    public int APP_LANGUAGE;
    public int TILESET;
    public int VOLUME;
    public int MUTE;
    public float BALANCE;
    public int[] player_hand = new int[4];
    public int[] dealer_hand = new int[4];

    public int[] getSettings () {
        int[] send = new int[4];
        send[0] = APP_LANGUAGE;
        send[1] = TILESET;
        send[2] = VOLUME;
        send[3] = MUTE;
        return send;
    }

    public void updateSettings (int langu, int tiles, int vol, int mut) {
        this.VOLUME = vol;
        this.MUTE = mut;
        this.TILESET = tiles;
        this.APP_LANGUAGE = langu;
    }

    private void setSTS(String cookie, String username, int language, int tileset, int volume, int mute, float balance) {
        STS_COOKIE = cookie;
        STS_USERNAME = username;
        APP_LANGUAGE = language;
        TILESET = tileset;
        VOLUME = volume;
        MUTE = mute;
        BALANCE = balance;
    }

    public void updateBalanceOnServer (float TO_ADD) {
        AsyncTask task = new SendToServer().execute("updatebalance", STS_USERNAME, STS_COOKIE, Float.toString(TO_ADD));
        String message = null;
        try {
            message = task.get().toString();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT ).show();
    }

    public void updateSettingsOnServer (int language, int tileset, int volume, int mute) {
        AsyncTask task = new SendToServer().execute("updatesettings", STS_USERNAME, STS_COOKIE, Integer.toString(language), Integer.toString(tileset), Integer.toString(volume), Integer.toString(mute));
        String message = null;
        try {
            message = task.get().toString();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public int getAPP_LANGUAGE () {
        return APP_LANGUAGE;
    }

    public int getTILESET () {
        return TILESET;
    }

    public void modify_PH (int index) {
        //String toaster = "";
        int temp = player_hand[index];
        for (int i = index; i > 0; i--) {
            player_hand[i] = player_hand[i-1];
        }
        player_hand[0] = temp;
        /*for (int j = 0; j < 4; j++) {
            toaster += Integer.toString(player_hand[j]);
        }
        Toast.makeText(getApplicationContext(), toaster, Toast.LENGTH_SHORT ).show();*/
    }

    public int[] requestDrawHand () {
        player_hand[0] = draw.getDomino();
        player_hand[1] = draw.getDomino();
        player_hand[2] = draw.getDomino();
        player_hand[3] = draw.getDomino();
        return player_hand;
    }

    public int[] requestDrawDealerHand () {
        HouseWay2 houseway = new HouseWay2();
        dealer_hand = houseway.arrangeTiles(draw.getDomino(), draw.getDomino(), draw.getDomino(), draw.getDomino());
        Toast.makeText(getApplicationContext(), "" + dealer_hand[0] + " " + dealer_hand[1] + " " + dealer_hand[2] + " " + dealer_hand[3] + " ", Toast.LENGTH_SHORT ).show();
        return dealer_hand;
    }

    public int[] getWinner() {
        Calculate calc = new Calculate();
        calc.setDealerHand(dealer_hand[0], dealer_hand[1], dealer_hand[2], dealer_hand[3]);
        calc.setPlayerHand(player_hand[0], player_hand[1], player_hand[2], player_hand[3]);
        int[] win = calc.getWinner();
        return win;
    }
    public void restart () {
        draw.reset();
        player_hand[0] = 0;
        player_hand[1] = 0;
        player_hand[2] = 0;
        player_hand[3] = 0;
        dealer_hand[0] = 0;
        dealer_hand[1] = 0;
        dealer_hand[2] = 0;
        dealer_hand[3] = 0;
    }

    public float getBALANCE () {
        return BALANCE;
    }

    public void updateBalance (float toAdd) {
        BALANCE += toAdd;
        updateBalanceOnServer(toAdd);
    }


    //INSTANCIRANJE
    //Calculate calc = new Calculate();
    //Domino domino = new Domino(TILESET);
    Language langob = new Language(APP_LANGUAGE);
    Draw draw = new Draw();
    //HouseWay houseway = new HouseWay();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*player_hand[0] = 1;
        player_hand[1] = 2;
        player_hand[2] = 3;
        player_hand[3] = 4;*/



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
        //Toast.makeText(getApplicationContext(), "balance = " + splitano[splitano.length-1], Toast.LENGTH_SHORT ).show();
        /*final int APP_LANGUAGE = Integer.parseInt(splitano[1]);
        final int TILESET = Integer.parseInt(splitano[2]);
        final int VOLUME = Integer.parseInt(splitano[3]);
        final int MUTE = Integer.parseInt(splitano[4]);
        final int BALANCE = Integer.parseInt(splitano[5]);*/

        //postavi globalne varijable
        setSTS(COOKIE,USERNAME,Integer.parseInt(splitano[1]),Integer.parseInt(splitano[2]),Integer.parseInt(splitano[3]),Integer.parseInt(splitano[4]),Float.parseFloat(splitano[5]));


        setContentView(R.layout.activity_store);

        //final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        //drawer = (DrawerView) findViewById(R.id.drawer);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //toolbar.setTitle("PaiGow");

        //drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        /*drawerToggle = new ActionBarDrawerToggle(
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
        };*/

        /*drawerLayout.setStatusBarBackgroundColor(getResources().getColor(R.color.color_primary_dark));
        drawerLayout.setDrawerListener(drawerToggle);
        drawerLayout.closeDrawer(drawer);*/


        /*drawer.addItem(new DrawerItem()
                        .setTextPrimary(getString(R.string.lorem_ipsum_short))
                        .setTextSecondary(getString(R.string.lorem_ipsum_long))
        );*/
        //langob.setLanguage(1);
        String drawer_game = langob.getLangString(0);
        String drawer_store = langob.getLangString(1);
        String drawer_store_1 = langob.getLangString(2);
        String drawer_settings = langob.getLangString(3);
        String drawer_settings_1 = langob.getLangString(4);
        String drawer_about = langob.getLangString(5);
        String drawer_about_1 = langob.getLangString(6);
        addItem(new DrawerItem()
                        .setImage(getResources().getDrawable(R.drawable.game))
                                //.setTextPrimary(getString(R.string.lorem_ipsum_short))
                                //.setTextPrimary(langob.getLangString(0))
                        .setTextPrimary(drawer_game)
                //.setTextSecondary(getString(R.string.lorem_ipsum_long))
                //.setTextSecondary("Buy credit and more...")
        );

        addDivider();
        addItem(new DrawerItem()
                        .setImage(getResources().getDrawable(R.drawable.store))
                                //.setTextPrimary(getString(R.string.lorem_ipsum_short))
                                //.setTextPrimary(langob.getLangString(1))
                        .setTextPrimary(drawer_store)
                                //.setTextSecondary(getString(R.string.lorem_ipsum_long))
                        .setTextSecondary(drawer_store_1)
        );

        addDivider();

        addItem(new DrawerItem()
                        .setImage(getResources().getDrawable(R.drawable.settings))
                                //.setTextPrimary(getString(R.string.lorem_ipsum_short))
                        .setTextPrimary(drawer_settings)
                                //.setTextSecondary(getString(R.string.lorem_ipsum_long))
                        .setTextSecondary(drawer_settings_1)
        );

        addDivider();

        addItem(new DrawerItem()
                        .setImage(getResources().getDrawable(R.drawable.info))
                                //.setTextPrimary(getString(R.string.lorem_ipsum_short))
                        .setTextPrimary(drawer_about)
                                //.setTextSecondary(getString(R.string.lorem_ipsum_long))
                        .setTextSecondary(drawer_about_1)
        );

        addDivider();


        selectItem(1);
        setOnItemClickListener(new DrawerItem.OnItemClickListener() {
            @Override
            public void onClick(DrawerItem item, long id, int position) {
                int current = getSelectedPosition();
                selectItem(position);
                //Toast.makeText(GameActivity.this, "Clicked item #" + position, Toast.LENGTH_SHORT).show();
                //Intent myIntent = new Intent(GameActivity.this, StoreActivity.class);
                //myIntent.putExtra("key", value); //Optional parameters
                //GameActivity.this.startActivity(myIntent);

                /*Toast.makeText(getApplicationContext(), "position = " + position,
                        Toast.LENGTH_SHORT ).show();*/

                if (current != position) {
                    Fragment fr = null;
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fm.beginTransaction();

                    if (position == 0) {
                        fr = new GameFragment();
                        fragmentTransaction.replace(R.id.fragment_place, fr);
                        fragmentTransaction.commit();

                    } else if (position == 2) {
                        fr = new StoreFragment();
                        fragmentTransaction.replace(R.id.fragment_place, fr);
                        fragmentTransaction.commit();

                    } else if (position == 4) {
                        fr = new SettingsFragment();
                        fragmentTransaction.replace(R.id.fragment_place, fr);
                        fragmentTransaction.commit();

                    } else if (position == 6) {
                        fr = new AboutFragment();
                        fragmentTransaction.replace(R.id.fragment_place, fr);
                        fragmentTransaction.commit();

                    } else if (position == 8) {
                        AsyncTask task = new SendToServer().execute("logout", USERNAME, COOKIE);
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
                }
                closeDrawer();

                /*OSNOVNO PREBACIVANJE FRAGMENATA:
                Fragment fr = new StoreFragment();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_place, fr);
                fragmentTransaction.commit();*/
            }
        });


        addItem(new DrawerItem()
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

        addProfile(new DrawerProfile()
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
        if (onOptionsItemSelected(item)) {
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
        //onConfigurationChanged(newConfig);
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        //drawerToggle.syncState();
    }
}