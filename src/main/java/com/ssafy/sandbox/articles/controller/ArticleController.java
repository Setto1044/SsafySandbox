package com.ssafy.sandbox.articles.controller;

import com.ssafy.sandbox.articles.dto.ArticleCursorPagingResponseDto;
import com.ssafy.sandbox.articles.dto.ArticleOffsetPagingResponseDto;
import com.ssafy.sandbox.articles.dto.ArticlePostRequestDto;
import com.ssafy.sandbox.articles.service.ArticleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleService service;

    public ArticleController(ArticleService service) {
        this.service = service;
    }

    @GetMapping("/paging/offset")
    public ArticleOffsetPagingResponseDto getArticlesWithOffset(@RequestParam int size, @RequestParam int page) {
        return service.getArticlesWithOffsetPaging(page, size);
    }

    @GetMapping("/paging/cursor")
    public ArticleCursorPagingResponseDto getArticlesWithCursor(@RequestParam int size, @RequestParam int cursorId) {
        return service.getArticlesWithCursorPaging(cursorId, size);
    }

    @PostMapping("/make")
    public void addArticles(@RequestBody ArticlePostRequestDto dto) {
        service.saveArticles(dto.getArticles());
    }

}
