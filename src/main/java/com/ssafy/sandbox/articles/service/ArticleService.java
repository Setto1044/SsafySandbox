package com.ssafy.sandbox.articles.service;

import com.ssafy.sandbox.articles.dto.ArticleCursorPagingResponseDto;
import com.ssafy.sandbox.articles.dto.ArticleOffsetPagingResponseDto;
import com.ssafy.sandbox.articles.vo.Article;

import java.util.List;

public interface ArticleService {
    public ArticleOffsetPagingResponseDto getArticlesWithOffsetPaging(int page, int size);

    public ArticleCursorPagingResponseDto getArticlesWithCursorPaging(int lastId, int limit);

    void saveArticles(List<Article> articles);
}
