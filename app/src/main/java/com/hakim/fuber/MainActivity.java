package com.hakim.fuber;

import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @Bind(R.id.left_drawer)
    ListView drawerList;

    private SimpleDraweeView avatar;
    private TextView nickname;

    private ActionBarDrawerToggle drawerToggle;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Fresco.initialize(this);
        initToolbar();
        initializeDrawer();
        initDrawerList();
        if (savedInstanceState == null) {
            selectItem(0);
        }
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void initializeDrawer() {
        drawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        drawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        drawerLayout.setDrawerListener(drawerToggle);

    }

    private void initDrawerList() {
        drawerList.setOnItemClickListener(new DrawerItemClickListener());
        View header = getLayoutInflater().inflate(R.layout.ll_drawer_header, drawerList, false);
        avatar = (SimpleDraweeView) header.findViewById(R.id.avatar);
        nickname = (TextView) header.findViewById(R.id.nickname);
        drawerList.addHeaderView(header,null,false);
//        View footer = getLayoutInflater().inflate(R.layout.ll_drawer_footer, drawerList, false);
//        drawerList.addFooterView(footer);
//        drawerList.setFooterDividersEnabled(true);

        String[] titles = getResources().getStringArray(R.array.drawer_items);
        TypedArray ta = getResources().obtainTypedArray(R.array.drawer_icons);
        int length = ta.length();
        int[] ids = new int[length];
        for (int i = 0; i < length; i++) {
            int id = ta.getResourceId(i, R.drawable.ic_launcher);
            ids[i] = id;
        }
        ta.recycle();
        DrawerItemAdapter adapter = new DrawerItemAdapter(titles, ids);
        drawerList.setAdapter(adapter);
    }

    private void selectItem(int position) {
        switchFragment(position);

        drawerList.setItemChecked(position, true);
        drawerLayout.closeDrawer(drawerList);
    }

    private void switchFragment(int position) {

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class DrawerItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    private class DrawerItemAdapter extends BaseAdapter {
        private String[] titles;
        private int[] icons;

        public DrawerItemAdapter(String[] titles, int[] icons) {
            this.titles = titles;
            this.icons = icons;
            if (titles.length != icons.length) {
                throw new IllegalStateException("The length of titles must be equal to icons's");
            }
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.ll_drawer_item, parent, false);
            }

            TextView item = (TextView) convertView;
            item.setCompoundDrawablesWithIntrinsicBounds(icons[position], 0, 0, 0);
            item.setText(titles[position]);
            return convertView;
        }
    }
}
