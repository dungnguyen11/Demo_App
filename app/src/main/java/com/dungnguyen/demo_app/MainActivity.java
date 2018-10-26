package com.dungnguyen.demo_app;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    //Constant
    private final int HOME_FRAGMENT = 0;
    private final int DETAIL_FRAGMENT = 1;
    private final int SETTING_FRAGMENT = 2;

    //Layout
    private ImageButton mHomeButton;
    private ImageButton mDetailButton;
    private ImageButton mSettingButton;

    FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        initOnClick();
    }

    private void initUI() {
        mHomeButton = findViewById(R.id.homeButton);
        mDetailButton = findViewById(R.id.detailButton);
        mSettingButton = findViewById(R.id.settingButton);
    }

    private void initOnClick() {
        mHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayFragment(HOME_FRAGMENT);
            }
        });

        mDetailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayFragment(DETAIL_FRAGMENT);
            }
        });

        mSettingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayFragment(SETTING_FRAGMENT);
            }
        });
    }

    private void displayFragment(int whichFragment) {
        Fragment fragment = new Fragment();

        switch (whichFragment) {
            case HOME_FRAGMENT:
                fragment = HomeFragment.newInstance("", "");
                break;

            case DETAIL_FRAGMENT:
                fragment = DetailFragment.newInstance("", "");
                break;

            case SETTING_FRAGMENT:
                fragment = SettingFragment.newInstance("", "");
                break;

            default:
                return;
        }

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_layout, fragment);
        fragmentTransaction.isAddToBackStackAllowed();
        fragmentTransaction.commit();
    }
}
