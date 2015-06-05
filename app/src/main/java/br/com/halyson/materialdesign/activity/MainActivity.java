package br.com.halyson.materialdesign.activity;

import android.os.Bundle;

import br.com.halyson.materialdesign.R;
import br.com.halyson.materialdesign.activity.api.BaseActivity;
import br.com.halyson.materialdesign.constants.FragmentNames;
import br.com.halyson.materialdesign.fragment.HomeFragment;
import br.com.halyson.materialdesign.fragment.HomeFragmentMain;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.screen_default_container, new HomeFragmentMain(), FragmentNames.FRAGMENT_HOME_MAIN_).commit();
        }


    }

    @Override
    protected int setLayoutResourceIdentifier() {
        return R.layout.screen_default_main;
    }

    @Override
    protected int getTitleToolBar() {
        return R.string.app_name;
    }

    @Override
    public void onResume () {
        super.onResume();
    }

    @Override
    public void onPause () {
        super.onPause();
    }

}
