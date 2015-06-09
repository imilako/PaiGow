package br.com.halyson.materialdesign.activity;

/**
 * Created by Ivan on 9.6.2015..
 */
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.heinrichreimersoftware.materialdrawer.DrawerActivity;
import com.heinrichreimersoftware.materialdrawer.structure.DrawerItem;
import com.heinrichreimersoftware.materialdrawer.structure.DrawerProfile;
import com.heinrichreimersoftware.materialdrawer.theme.DrawerTheme;

import br.com.halyson.materialdesign.R;


public class MainActivity3 extends DrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        setDrawerTheme(
                new DrawerTheme(this)
                        .setBackgroundColorRes(R.color.background_material_dark)
                        .setTextColorPrimaryRes(R.color.primary_text_default_material_dark)
                        .setTextColorSecondaryRes(R.color.secondary_text_default_material_dark)
        );

        addItems(new DrawerItem()
                        .setTextPrimary(getString(R.string.lorem_ipsum_short))
                        .setTextSecondary(getString(R.string.lorem_ipsum_long))
                        .setDrawerTheme(
                                new DrawerTheme(getDrawerTheme())
                                        .setBackgroundColorRes(R.color.material_blue_grey_800)
                        ),
                new DrawerItem()
                        .setImage(getResources().getDrawable(R.drawable.ic_flag))
                        .setTextPrimary(getString(R.string.lorem_ipsum_short))
                        .setTextSecondary(getString(R.string.lorem_ipsum_long))
        );
        addProfile(new DrawerProfile()
                        .setId(1)
                        .setRoundedAvatar((BitmapDrawable) getResources().getDrawable(R.drawable.cat_2))
                        .setBackground(getResources().getDrawable(R.drawable.cat_wide_1))
                        .setName(getString(R.string.lorem_ipsum_short))
        );
        addProfile(new DrawerProfile()
                        .setId(2)
                        .setRoundedAvatar((BitmapDrawable) getResources().getDrawable(R.drawable.cat_1))
                        .setBackground(getResources().getDrawable(R.drawable.cat_wide_2))
                        .setName(getString(R.string.lorem_ipsum_short))
                        .setDescription(getString(R.string.lorem_ipsum_medium))
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_github:
                String url = "https://github.com/HeinrichReimer/material-drawer";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}