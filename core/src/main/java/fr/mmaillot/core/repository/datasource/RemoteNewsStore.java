package fr.mmaillot.core.repository.datasource;

import com.pkmmte.pkrss.Article;
import com.pkmmte.pkrss.parser.Parser;
import com.pkmmte.pkrss.parser.Rss2Parser;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.util.List;

import fr.mmaillot.core.repository.entity.NewsEntity;
import fr.mmaillot.core.repository.entity.mapper.NewsEntityRssMapper;
import io.reactivex.Single;

/**
 * Remote store to retrieve RSS news from Website
 */
public class RemoteNewsStore implements NewsDataStore {

    private final static String URL = "http://www.geekwire.com/feed/";
    private final NewsEntityRssMapper mNewsEntityRssMapper;
    // Reusable XML Parser
    private final Parser parser;
    private final OkHttpClient mHttpClient;

    public RemoteNewsStore() {
        mNewsEntityRssMapper = new NewsEntityRssMapper();
        parser = new Rss2Parser();
        mHttpClient = new OkHttpClient();
    }

    @Override
    public Single<List<NewsEntity>> news() {
        return Single.create(e -> {
            Request request = new Request.Builder()
                    .url(URL)
                    .build();

            Response response = mHttpClient.newCall(request).execute();
            List<Article> articles = parser.parse(response.body().string());
            if (articles != null) {
                e.onSuccess(mNewsEntityRssMapper.transform(articles));
            } else {
                e.onError(new Exception("Failed to load news from RSS"));
            }
        });
    }
}
