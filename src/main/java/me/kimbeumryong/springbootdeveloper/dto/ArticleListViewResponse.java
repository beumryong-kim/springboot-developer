package me.kimbeumryong.springbootdeveloper.dto;

import lombok.Getter;
import me.kimbeumryong.springbootdeveloper.domain.Article;

/**
 * @author kimbeumryong
 * @Class ArticleListViewResponse
 * @Description :
 * @since 4/3/25
 */
@Getter
public class ArticleListViewResponse {

    private final Long id;
    private final String title;
    private final String content;

    public ArticleListViewResponse(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
