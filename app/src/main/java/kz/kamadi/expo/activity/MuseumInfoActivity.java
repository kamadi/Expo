package kz.kamadi.expo.activity;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kz.kamadi.expo.R;

public class MuseumInfoActivity extends AppCompatActivity {
    //    @Bind(R.id.root_coordinator)
//    CoordinatorLayout mCoordinator;
    //Need this to set the title of the app bar
    @Bind(R.id.collapse_toolbar)
    CollapsingToolbarLayout mCollapsingToolbarLayout;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
////    @Bind(R.id.address)
//    TextView address;
//
////    @Bind(R.id.phone)
//    TextView phone;
//
////    @Bind(R.id.website)
//    TextView website;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museum_info);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mCollapsingToolbarLayout.setTitle(getResources().getString(R.string.museums));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @OnClick(R.id.address)
    public void showAddress() {

    }

    @OnClick(R.id.phone)
    public void call() {

    }

    @OnClick(R.id.website)
    public void openWeb() {

    }
}
