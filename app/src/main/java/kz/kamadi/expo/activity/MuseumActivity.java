package kz.kamadi.expo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import kz.kamadi.expo.R;
import kz.kamadi.expo.adapter.ItemAdapter;
import kz.kamadi.expo.helper.SimpleDividerItemDecoration;
import kz.kamadi.expo.model.Item;
import kz.kamadi.expo.model.Museum;

public class MuseumActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, ItemAdapter.OnItemClickListener {

    private static final String LOG_TAG = "MuseumActivity";
    @Bind(R.id.app_bar)
    Toolbar mToolbar;

    @Bind(R.id.main_drawer)
    NavigationView mDrawer;

    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @Bind(R.id.cardList)
    RecyclerView recyclerView;

    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museum);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        mDrawer.setNavigationItemSelectedListener(this);
        mDrawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout,
                mToolbar,
                R.string.drawer_open,
                R.string.drawer_close);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        ArrayList<Item> items = new ArrayList<>();
        items.addAll(Museum.getInstance().getMuseums());
        recyclerView.setAdapter(new ItemAdapter(this, items, this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));

    }


    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        return false;
    }

    @Override
    public void onItemClick(View view, int position) {
        Log.e(LOG_TAG, position + "");
        startActivity(new Intent(this, MuseumInfoActivity.class));
    }
}
