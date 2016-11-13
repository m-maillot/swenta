package fr.mmaillot.swenta;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.mmaillot.swenta.model.NewsModel;

/**
 * Activity to show news content
 */
public class NewsActivity extends BaseActivity {

    private static final String EXTRA_NEWS = BuildConfig.APPLICATION_ID + ".EXTRA_NEWS";

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbarLayout;

    @BindView(R.id.tv_content)
    TextView mContent;

    @BindView(R.id.iv_picture)
    ImageView mPicture;

    public static void openNewsActivity(Context pContext, NewsModel pNewsModel) {
        Intent intent = new Intent(pContext, NewsActivity.class);
        intent.putExtra(EXTRA_NEWS, pNewsModel);
        pContext.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        ButterKnife.bind(this);

        final NewsModel news = (NewsModel) getIntent().getSerializableExtra(EXTRA_NEWS);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mCollapsingToolbarLayout.setTitle(news.getTitle());

        mContent.setText(Html.fromHtml(news.getContent()));

        if (news.getPicture() != null && !"".equals(news.getPicture())) {
            Picasso.with(this).load(news.getPicture())
                    .fit().into(mPicture);
        }

    }
}
