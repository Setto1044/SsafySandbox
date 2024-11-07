package com.ssafy.sandbox.articles.dto;

import com.ssafy.sandbox.articles.vo.Article;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class ArticleDto {
    private int id;
    private String title;
    private Instant createdAt;

    private ArticleDto(int id, String title, Instant createdAt) {
        this.id = id;
        this.title = title;
        this.createdAt = createdAt;
    }

    public static ArticleDto of(Article article) {
        return new ArticleDto(article.getId(), article.getTitle(), article.getCreatedAt());
    }

}
