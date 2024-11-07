package com.ssafy.sandbox.articles.service;

import com.ssafy.sandbox.articles.dto.ArticleCursorPagingResponseDto;
import com.ssafy.sandbox.articles.dto.ArticleDto;
import com.ssafy.sandbox.articles.dto.ArticleOffsetPagingResponseDto;
import com.ssafy.sandbox.articles.repository.ArticleRepository;
import com.ssafy.sandbox.articles.vo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository repository;

    public ArticleServiceImpl(ArticleRepository repository) {
        this.repository = repository;
    }

    @Override
    public ArticleOffsetPagingResponseDto getArticlesWithOffsetPaging(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Article> articlePage = repository.findAll(pageable);

        List<ArticleDto> articleDtos = articlePage.getContent().stream()
                .map(ArticleDto::of)
                .collect(Collectors.toList());

        return new ArticleOffsetPagingResponseDto(
                articlePage.getTotalPages(),
                articleDtos
        );
    }

    @Override
    public ArticleCursorPagingResponseDto getArticlesWithCursorPaging(int cursorId, int size) {
        List<Article> articles = repository.findAllByIdGreaterThanOrderByCreatedAtAsc(cursorId, PageRequest.of(0, size));

        int lastId = articles.isEmpty() ? cursorId : articles.get(articles.size() - 1).getId();

        List<ArticleDto> articleDtos = articles.stream()
                .map(ArticleDto::of)
                .collect(Collectors.toList());

        return new ArticleCursorPagingResponseDto(lastId, articleDtos);
    }

    @Override
    public void saveArticles(List<Article> articles) {
        repository.saveAll(articles);
    }
}
