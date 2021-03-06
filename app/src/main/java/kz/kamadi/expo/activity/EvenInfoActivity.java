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
import kz.kamadi.expo.R;
import kz.kamadi.expo.model.Event;

public class EvenInfoActivity extends AppCompatActivity {
    @Bind(R.id.collapse_toolbar)
    CollapsingToolbarLayout mCollapsingToolbarLayout;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.description)
    TextView description;

    @Bind(R.id.time)
    TextView time;

    @Bind(R.id.address)
    TextView address;

    @Bind(R.id.header)
    ImageView header;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_info);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        int position = getIntent().getIntExtra("position",0);
        Event event = Event.getEvents(this).get(position);
        header.setBackground(event.getBackground());
        description.setText(event.getDescription());
        address.setText(event.getAddress());
        time.setText(event.getTime());
        mCollapsingToolbarLayout.setTitle(event.getTitle());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
