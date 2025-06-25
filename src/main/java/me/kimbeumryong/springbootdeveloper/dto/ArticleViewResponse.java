package me.kimbeumryong.springbootdeveloper.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import me.kimbeumryong.springbootdeveloper.domain.Article;

import java.time.LocalDateTime;

/**
 * @author kimbeumryong
 * @Class ArticleViewResponse
 * @Description :
 * @since 4/3/25
 */
@NoArgsConstructor
@Getter
public class ArticleViewResponse {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private String author;

    public ArticleViewResponse(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.createdAt = article.getCreatedAt();
        this.author = article.getAuthor();
    }
}
