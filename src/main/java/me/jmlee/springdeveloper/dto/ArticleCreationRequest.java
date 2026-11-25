package me.jmlee.springdeveloper.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.jmlee.springdeveloper.dao.Article;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ArticleCreationRequest {
    private String title;
    private String content;
    public Article toEntity() {
        //return new Article(this.title, this.content)
        return Article.builder().title(this.title).content(this.content).build();
    }
}
