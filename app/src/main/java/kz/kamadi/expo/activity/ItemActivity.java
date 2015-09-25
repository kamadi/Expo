package kz.kamadi.expo.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
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

public class ItemActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, ItemAdapter.OnItemClickListener {

    private static final String LOG_TAG = "ItemActivity";
    @Bind(R.id.app_bar)
    Toolbar mToolbar;

    @Bind(R.id.main_drawer)
    NavigationView mDrawer;

    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @Bind(R.id.cardList)
    RecyclerView recyclerView;

    private ActionBarDrawerToggle mDrawerToggle;

    private int currentItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        mDrawer.setNavigationItemSelectedListener(this);
        mDrawer.setItemIconTintList(null);
        mDrawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout,
                mToolbar,
                R.string.drawer_open,
                R.string.drawer_close);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
        initRecyclerView();
        mToolbar.setTitle(Item.getInstance().getCurrentTitle(this));
    }

    private void initRecyclerView() {
        ArrayList<Item> items = Item.getInstance().getItems(this);
        recyclerView.setAdapter(new ItemAdapter(this, items, this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        Intent intent;
        switch (menuItem.getItemId()) {
            case R.id.event:
                intent = new Intent(this, MainActivity.class);
                intent.putExtra("tab", 0);
                startActivity(intent);
                break;
            case R.id.visit:
                intent = new Intent(this, MainActivity.class);
                intent.putExtra("tab", 1);
                startActivity(intent);
                break;
            case R.id.map:
                intent = new Intent(this, MainActivity.class);
                intent.putExtra("tab", 2);
                startActivity(intent);
                break;
            case R.id.guide:
                intent = new Intent(this, MainActivity.class);
                intent.putExtra("tab", 3);
                startActivity(intent);
                break;

            case R.id.news:
                break;

            case R.id.about:
                break;
        }
        return false;
    }

    @Override
    public void onItemClick(View view, int position) {
        Log.e(LOG_TAG, position + "");
        Intent intent = new Intent(this, ItemInfoActivity.class);
        intent.putExtra("position", position);
        startActivity(intent);

        String transitionName = getString(R.string.animation);

        ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(this, view, transitionName);
        startActivity(intent, transitionActivityOptions.toBundle());
    }


    private void hideDrawer() {
        mDrawerLayout.closeDrawer(GravityCompat.START);
    }
}
