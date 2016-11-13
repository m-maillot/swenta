package fr.mmaillot.swenta;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.mmaillot.swenta.model.NewsModel;

/**
 * Adapter for main RecycleView to show all news
 */
class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private final Context mContext;
    private final List<NewsModel> mNews;

    static class ViewHolder extends RecyclerView.ViewHolder {

        View mView;

        @BindView(R.id.iv_picture)
        ImageView mPicture;

        @BindView(R.id.tv_title)
        TextView mTitle;

        ViewHolder(View pView) {
            super(pView);
            mView = pView;
            ButterKnife.bind(this, pView);
        }
    }

    NewsAdapter(Context pContext) {
        mContext = pContext;
        mNews = new ArrayList<>();
    }

    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final NewsModel news = mNews.get(position);
        holder.mView.setOnClickListener(pView -> NewsActivity.openNewsActivity(mContext, news));
        holder.mTitle.setText(news.getTitle());
        if (news.getPicture() != null && !"".equals(news.getPicture())) {
            Picasso.with(mContext).load(news.getPicture())
                    .fit().into(holder.mPicture);
        }
    }

    @Override
    public int getItemCount() {
        return mNews.size();
    }

    void replaceAll(List<NewsModel> pNews) {
        mNews.clear();
        mNews.addAll(pNews);
        notifyDataSetChanged();
    }
}
