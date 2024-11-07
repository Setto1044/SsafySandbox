package com.ssafy.sandbox.articles.controller;

import com.ssafy.sandbox.articles.dto.ArticleCursorPagingResponseDto;
import com.ssafy.sandbox.articles.dto.ArticleOffsetPagingResponseDto;
import com.ssafy.sandbox.articles.dto.ArticlePostRequestDto;
import com.ssafy.sandbox.articles.service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleService service;

    public ArticleController(ArticleService service) {
        this.service = service;
    }

    @GetMapping("/paging/offset")
    public ResponseEntity<ArticleOffsetPagingResponseDto> getArticlesWithOffset(@RequestParam int size, @RequestParam int page) {
        return ResponseEntity.ok(service.getArticlesWithOffsetPaging(page, size));
    }

    @GetMapping("/paging/cursor")
    public ResponseEntity<ArticleCursorPagingResponseDto> getArticlesWithCursor(@RequestParam int size, @RequestParam int cursorId) {
        return ResponseEntity.ok(service.getArticlesWithCursorPaging(cursorId, size));
    }

    @PostMapping("/make")
    public ResponseEntity<Void> addArticles(@RequestBody ArticlePostRequestDto dto) {
        service.saveArticles(dto.getArticles());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
