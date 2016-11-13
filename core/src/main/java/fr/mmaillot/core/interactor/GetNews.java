package fr.mmaillot.core.interactor;

import android.content.Context;

import java.util.List;

import fr.mmaillot.core.executor.PostExecutionThread;
import fr.mmaillot.core.executor.ThreadExecutor;
import fr.mmaillot.core.model.News;
import fr.mmaillot.core.repository.NewsRepository;
import io.reactivex.Single;

/**
 * Created by mmaillot on 11/11/16.
 */
public class GetNews extends UseCase<List<News>> {

    private final NewsRepository mNewsRepository;

    public GetNews(Context pContext, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        mNewsRepository = new NewsRepository(pContext);
    }

    @Override
    protected Single<List<News>> buildUseCaseObservable() {
        return mNewsRepository.news();
    }
}
