package fr.mmaillot.core.cache;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.util.List;

import fr.mmaillot.core.repository.entity.NewsEntity;

/**
 * Class handle the cache in json
 */
public class NewsCache {

    private final FileManager mFileManager;
    private final File mCacheFile;

    public NewsCache(Context pContext) {
        mFileManager = new FileManager();
        mCacheFile = new File(pContext.getCacheDir(), "news.json");
    }

    public void save(List<NewsEntity> pEntities) {
        Gson gson = new Gson();
        mFileManager.writeToFile(mCacheFile, gson.toJson(pEntities));
    }

    public List<NewsEntity> load(Throwable pThrowable) {
        Gson gson = new Gson();
        String cache = mFileManager.readFileContent(mCacheFile);
        return gson.fromJson(cache, new TypeToken<List<NewsEntity>>() {
        }.getType());
    }
}
