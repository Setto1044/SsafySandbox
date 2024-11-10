package com.ssafy.sandbox.articles.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class ArticleOffsetPagingResponseDto {
    private int totalPage;
    private List<ArticleDto> articles;
}
