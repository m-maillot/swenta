package fr.mmaillot.swenta.model.mapper;

import java.util.ArrayList;
import java.util.List;

import fr.mmaillot.core.model.News;
import fr.mmaillot.swenta.model.NewsModel;

/**
 * Mapper from {@link News} to {@link NewsModel}
 */
public class NewsModelMapper {

    private NewsModel transform(News pNews) {
        return new NewsModel(pNews.getTitle(), pNews.getPicture(), pNews.getSummary(), pNews.getContent());
    }

    public List<NewsModel> transform(List<News> pNews) {
        List<NewsModel> models = new ArrayList<>(pNews.size());
        for (News news : pNews) {
            if (news != null) {
                models.add(transform(news));
            }
        }
        return models;
    }
}
