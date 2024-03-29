package com.toMist.toMist.service;

import com.toMist.toMist.domain.type.SearchType;
import com.toMist.toMist.dto.ArticleDto;
import com.toMist.toMist.repository.ArticleRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class ArticleService {
  private final ArticleRepository articleRepository;

  @Transactional(readOnly = true)
  public List<ArticleDto> searchArticles(SearchType title, String keyword){
    return List.of();
  }

  @Transactional(readOnly = true)
  public ArticleDto searchArticle(long id){
    return null;
  }
}
