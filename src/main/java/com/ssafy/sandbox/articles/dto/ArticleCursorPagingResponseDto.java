package com.ssafy.sandbox.articles.dto;

import com.ssafy.sandbox.articles.vo.Article;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class ArticleCursorPagingResponseDto {
    private int lastId;
    private List<Article> articles;
}
