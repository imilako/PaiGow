package br.com.halyson.materialdesign.activity;

import android.content.Intent;
import android.os.Bundle;

import br.com.halyson.materialdesign.R;
import br.com.halyson.materialdesign.activity.api.BaseActivity;
import br.com.halyson.materialdesign.constants.FragmentNames;
import br.com.halyson.materialdesign.fragment.HomeFragment;


public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.screen_default_container, new HomeFragment(), FragmentNames.FRAGMENT_HOME_).commit();
        }


    }

    @Override
    protected int setLayoutResourceIdentifier() {
        return R.layout.screen_default;
    }

    @Override
    protected int getTitleToolBar() {
        return R.string.app_name;
    }

    /*@Override
    public void onBackPressed() {
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);
    }*/

}
