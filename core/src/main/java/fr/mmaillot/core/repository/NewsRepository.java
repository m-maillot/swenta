package fr.mmaillot.core.repository;

import android.content.Context;

import java.util.List;

import fr.mmaillot.core.cache.NewsCache;
import fr.mmaillot.core.model.News;
import fr.mmaillot.core.model.mapper.NewsMapper;
import fr.mmaillot.core.repository.datasource.RemoteNewsStore;
import io.reactivex.Single;

/**
 * Created by mmaillot on 11/13/16.
 */

public class NewsRepository {

    private final RemoteNewsStore mRemoteNewsStore;
    private final NewsCache mCache;
    private final NewsMapper mNewsMapper;

    public NewsRepository(Context pContext) {
        mRemoteNewsStore = new RemoteNewsStore();
        mCache = new NewsCache(pContext);
        mNewsMapper = new NewsMapper();
    }

    public Single<List<News>> news() {
        return mRemoteNewsStore.news()
                .doOnSuccess(mCache::save)
                .onErrorReturn(mCache::load)
                .map(mNewsMapper::transform);
    }
}
