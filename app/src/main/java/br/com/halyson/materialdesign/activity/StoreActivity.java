package br.com.halyson.materialdesign.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.BitmapDrawable;
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

import br.com.halyson.materialdesign.R;

public class StoreActivity extends DrawerActivity {

    private DrawerView drawer;

    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);


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


        drawer.addItem(new DrawerItem()
                        .setTextPrimary(getString(R.string.lorem_ipsum_short))
                        .setTextSecondary(getString(R.string.lorem_ipsum_long))
        );

        drawer.addItem(new DrawerItem()
                        .setImage(getResources().getDrawable(R.drawable.ic_mail))
                                //.setTextPrimary(getString(R.string.lorem_ipsum_short))
                        .setTextPrimary("Store")
                                //.setTextSecondary(getString(R.string.lorem_ipsum_long))
                        .setTextSecondary("Buy credit and more...")
        );

        drawer.addDivider();


        drawer.addItem(new DrawerItem()
                        .setImage(getResources().getDrawable(R.drawable.ic_mail))
                                //.setTextPrimary(getString(R.string.lorem_ipsum_short))
                        .setTextPrimary("Settings")
                                //.setTextSecondary(getString(R.string.lorem_ipsum_long))
                        .setTextSecondary("Customise your PaiGow app!")
        );

        drawer.addDivider();

        drawer.addItem(new DrawerItem()
                        .setImage(getResources().getDrawable(R.drawable.ic_mail))
                                //.setTextPrimary(getString(R.string.lorem_ipsum_short))
                        .setTextPrimary("About")
                                //.setTextSecondary(getString(R.string.lorem_ipsum_long))
                        .setTextSecondary("Additional info about us!")
        );

        drawer.addDivider();


        drawer.selectItem(2);
        drawer.setOnItemClickListener(new DrawerItem.OnItemClickListener() {
            @Override
            public void onClick(DrawerItem item, long id, int position) {
                drawer.selectItem(position);
                //Toast.makeText(StoreActivity.this, "Clicked item #" + position, Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(StoreActivity.this, GameActivity.class);
                //myIntent.putExtra("key", value); //Optional parameters
                StoreActivity.this.startActivity(myIntent);
            }
        });


        drawer.addFixedItem(new DrawerItem()
                        .setRoundedImage((BitmapDrawable) getResources().getDrawable(R.drawable.cat_2), DrawerItem.SMALL_AVATAR)
                                //.setTextPrimary(getString(R.string.lorem_ipsum_short))
                        .setTextPrimary("Logout")
        );

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
                        .setBackground(getResources().getDrawable(R.drawable.cat_wide_1))
                        .setBackground(getResources().getDrawable(R.drawable.cat_wide_1))
                        .setName("PaiGow")
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