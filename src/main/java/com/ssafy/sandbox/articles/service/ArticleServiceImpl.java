package com.ssafy.sandbox.articles.service;

import com.ssafy.sandbox.articles.dto.ArticleCursorPagingResponseDto;
import com.ssafy.sandbox.articles.dto.ArticleOffsetPagingResponseDto;
import com.ssafy.sandbox.articles.repository.ArticleRepository;
import com.ssafy.sandbox.articles.vo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository repository;

    public ArticleServiceImpl(ArticleRepository repository) {
        this.repository = repository;
    }

    @Override
    public ArticleOffsetPagingResponseDto getArticlesWithOffsetPaging(int page, int size) {
        // page - 1 로 0번째 인덱스부터 불러와야 첫 페이지 인덱스의 데이터부터 제공 가능
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Article> articlePage = repository.findAll(pageable);

        return new ArticleOffsetPagingResponseDto(
                articlePage.getTotalPages(),
                articlePage.getContent()
        );
    }

    @Override
    public ArticleCursorPagingResponseDto getArticlesWithCursorPaging(int cursorId, int size) {
        List<Article> articles = repository.findAllByIdGreaterThanEqualOrderByIdAsc(cursorId, PageRequest.of(0, size));

        int lastId = articles.isEmpty() ? cursorId : articles.get(articles.size() - 1).getId();

        return new ArticleCursorPagingResponseDto(lastId, articles);
    }

    @Override
    public void saveArticles(List<Article> articles) {
        repository.saveAll(articles);
    }
}
