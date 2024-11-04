package com.ssafy.sandbox.articles.repository;

import com.ssafy.sandbox.articles.vo.Article;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
    List<Article> findAllByIdGreaterThanEqualOrderByIdAsc(int lastId, Pageable pageable);
}
