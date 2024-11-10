package com.ssafy.sandbox.articles.dto;

import com.ssafy.sandbox.articles.vo.Article;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class ArticlePostRequestDto {
    private List<Article> articles;
}
