package kz.kamadi.expo.activity;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kz.kamadi.expo.R;
import kz.kamadi.expo.model.Item;

public class ItemInfoActivity extends AppCompatActivity {
    //    @Bind(R.id.root_coordinator)
//    CoordinatorLayout mCoordinator;
    //Need this to set the title of the app bar
    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbarLayout;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.address)
    TextView address;

    @Bind(R.id.phone)
    TextView phone;

    @Bind(R.id.website)
    TextView website;

    @Bind(R.id.description)
    TextView description;

    @Bind(R.id.header)
    ImageView header;

    private Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_info);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        item = Item.getInstance().getItems(this).get(getIntent().getIntExtra("position", 0));
        address.setText(item.getStreet() + "," + item.getBuilding());
        phone.setText(item.getPhone());
        website.setText(item.getWebsite());
        description.setText(item.getDescription());
        mCollapsingToolbarLayout.setTitle(item.getFullName());
        header.setImageDrawable(item.getImage());
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
