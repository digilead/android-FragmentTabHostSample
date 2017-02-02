package jp.digilead.fragmenttabhosttest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity implements FragmentTabHost.OnTabChangeListener
{
    private String currentTabId = "tab1";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutInflater layoutInflater = LayoutInflater.from(this);

        // find FragmentTabHost
        FragmentTabHost tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        tabHost.setup(this, getSupportFragmentManager(), R.id.container);

        // create TabSpec1
        TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("tab1");
        tabSpec1.setIndicator("tab1");
        tabHost.addTab(tabSpec1, TabFragment.class, null);

        // create TabSpec2
        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("tab2");
        tabSpec2.setIndicator("tab2");
        tabHost.addTab(tabSpec2, TabFragment.class, null);

        // create TabSpec3
        TabHost.TabSpec tabSpec3 = tabHost.newTabSpec("tab3");
        View view3 = layoutInflater.inflate(R.layout.layout_tab_menu, null);
        tabSpec3.setIndicator(view3);
        tabHost.addTab(tabSpec3, TabFragment.class, null);

        // create TabSpec4
        TabHost.TabSpec tabSpec4 = tabHost.newTabSpec("tab4");
        View view4 = layoutInflater.inflate(R.layout.layout_tab_menu, null);
        tabSpec4.setIndicator(view4);
        tabHost.addTab(tabSpec4, TabFragment.class, null);

        // set listener
        tabHost.setOnTabChangedListener(this);
    }

    @Override
    public void onTabChanged(String tabId)
    {
        Log.d("onTabChanged", "tabId: " + tabId);

        currentTabId = tabId;
    }

    public void onBackPressed()
    {
        Fragment currentTabFragment = getSupportFragmentManager().findFragmentByTag(currentTabId);

        boolean consumed = false;
        if (currentTabFragment != null && currentTabFragment instanceof OnBackPressedListener)
        {
            consumed = ((TabFragment) currentTabFragment).onBackPressed();
        }

        if (!consumed)
        {
            super.onBackPressed();
        }
    }

    interface OnBackPressedListener
    {
        boolean onBackPressed();
    }
}
