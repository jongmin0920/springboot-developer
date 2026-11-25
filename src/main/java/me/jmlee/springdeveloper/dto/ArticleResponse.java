package me.jmlee.springdeveloper.dto;

import lombok.Getter;
import me.jmlee.springdeveloper.dao.Article;

@Getter
public class ArticleResponse {

    private final Long id;
    private final String title;
    private final String content;

    // 엔티티(Article) -> 응답 DTO 변환
    public ArticleResponse(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
