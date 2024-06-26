package com.toMist.toMist.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public record ArticleDto(
        LocalDateTime createdAt,
        String createdBy,
        String title,
        String content,
        String hashTag

) implements Serializable {
  public static ArticleDto of(LocalDateTime createdAt, String createdBy, String title, String content, String hashTag) {
    return new ArticleDto(createdAt, createdBy, title, content, hashTag);
  }
}
