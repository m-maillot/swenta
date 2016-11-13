package fr.mmaillot.swenta;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.malinskiy.superrecyclerview.SuperRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.mmaillot.core.interactor.GetNews;
import fr.mmaillot.core.model.News;
import fr.mmaillot.swenta.model.mapper.NewsModelMapper;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

/**
 * Main activity show list of news
 */
public class MainActivity extends BaseActivity implements SingleObserver<List<News>>, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.rv_news)
    protected SuperRecyclerView mRecyclerView;

    private NewsAdapter mAdapter = null;
    private RecyclerView.LayoutManager mLayoutManager;

    private GetNews mGetNewsUseCase;

    private final NewsModelMapper mMapper = new NewsModelMapper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new NewsAdapter(this);

        mGetNewsUseCase = new GetNews(this, getApp().getJobExecutor(), getApp().getUIExecutor());

        mGetNewsUseCase.execute(this);

        mRecyclerView.setRefreshListener(this);
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onSuccess(List<News> value) {
        if (mRecyclerView.getAdapter() == null) {
            mRecyclerView.setAdapter(mAdapter);
        }
        mAdapter.replaceAll(mMapper.transform(value));
    }

    @Override
    public void onError(Throwable e) {
        Toast.makeText(this, "Failed to retrieve data", Toast.LENGTH_SHORT).show();
        if (mRecyclerView.getAdapter() == null) {
            mRecyclerView.setAdapter(mAdapter);
        }
    }

    @Override
    public void onRefresh() {
        mGetNewsUseCase.execute(this);
    }
}
