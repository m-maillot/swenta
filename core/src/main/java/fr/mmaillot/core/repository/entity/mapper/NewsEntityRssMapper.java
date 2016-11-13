package fr.mmaillot.core.repository.entity.mapper;

import com.pkmmte.pkrss.Article;

import java.util.ArrayList;
import java.util.List;

import fr.mmaillot.core.repository.entity.NewsEntity;

/**
 * Mapper from {@link Article} to {@link NewsEntity}
 */
public class NewsEntityRssMapper {

    private NewsEntity transform(Article pArticle) {
        return new NewsEntity(pArticle.getTitle(), String.valueOf(pArticle.getImage()), pArticle.getDescription(), pArticle.getContent());
    }

    public List<NewsEntity> transform(List<Article> pArticles) {
        List<NewsEntity> newsEntities = new ArrayList<>(pArticles.size());
        for (Article article : pArticles) {
            if (article != null) {
                newsEntities.add(transform(article));
            }
        }

        return newsEntities;
    }
}
