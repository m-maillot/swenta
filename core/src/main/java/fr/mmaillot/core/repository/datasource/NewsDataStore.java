package fr.mmaillot.core.repository.datasource;

import java.util.List;

import fr.mmaillot.core.repository.entity.NewsEntity;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Interface that represents a data store from where data is retrieved.
 */
interface NewsDataStore {

    /**
     * Get an {@link Observable} which will emit a List of {@link NewsEntity}.
     */
    Single<List<NewsEntity>> news();

}
