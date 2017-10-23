package me.anil.imageloader.modules.detail;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.anil.imageloader.BuildConfig;
import me.anil.imageloader.R;
import me.anil.imageloader.context.AppContext;
import me.anil.imageloader.repository.FeedResponse;
import me.anil.imageloader.repository.MetaData;

/**
 * The type Detail activity.
 */
public class DetailActivity extends AppCompatActivity {


    /**
     * The Toolbar.
     */
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    /**
     * The Simple drawee view.
     */
    /**
     * The Title text view.
     */
    @BindView(R.id.detail_title_textview)
    TextView titleTextView;
    /**
     * The Description text view.
     */
    @BindView(R.id.detail_description_textview)
    TextView descriptionTextView;

    @BindView(R.id.bodyImage)
    ImageView simpleDraweeViewBody;


    private static final String TAG = "DetailActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        AppContext.graph(this).inject(this);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        if (getIntent().getExtras() != null) {
            MetaData response = (FeedResponse) getIntent().getSerializableExtra("IMAGE_DATA");
            //populateData(response);
            response.getAuthor();
        }
    }

    private void populateData(FeedResponse response) {
        final String imageUriString = String.format(BuildConfig.HOST_API + "/%d" + "/%d?image=%d", 300, 600, response.id);
        Uri imageUri = Uri.parse(imageUriString);


        Picasso.with(this).load(imageUri).into(simpleDraweeViewBody);

        titleTextView.setText(String.format("Author\t:%s", response.author));
        descriptionTextView.setText(String.format("Format\t:%s", response.format));
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();

        }
        return super.onOptionsItemSelected(item);
    }
}
