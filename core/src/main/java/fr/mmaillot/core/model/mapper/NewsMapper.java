package fr.mmaillot.core.model.mapper;

import java.util.ArrayList;
import java.util.List;

import fr.mmaillot.core.model.News;
import fr.mmaillot.core.repository.entity.NewsEntity;

/**
 * Mapper from {@link NewsEntity} to {@link News}
 */
public class NewsMapper {

    private News transform(NewsEntity pNewsEntity) {
        return new News(pNewsEntity.getTitle(), pNewsEntity.getPicture(), pNewsEntity.getSummary(), pNewsEntity.getContent());
    }

    public List<News> transform(List<NewsEntity> pNewsEntities) {
        List<News> news = new ArrayList<>(pNewsEntities.size());
        for (NewsEntity newsEntity : pNewsEntities) {
            if (newsEntity != null) {
                news.add(transform(newsEntity));
            }
        }
        return news;
    }
}
