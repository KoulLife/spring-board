package com.toMist.toMist.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@ToString
@Table(
        indexes = {
                @Index(columnList = "title"),
                @Index(columnList = "hashtag"),
                @Index(columnList = "createdAt"),
                @Index(columnList = "createdBy")
        }
)
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Article {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Setter @Column(nullable = false) private String title;
  @Setter @Column(nullable = false, length = 1000) private String content;
  @Setter private String hashtag;

  @ToString.Exclude
  @OrderBy("id")
  @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
  private final Set<ArticleComment> articleComments = new LinkedHashSet<>();

  @CreatedDate private @Column(nullable = false) LocalDateTime createdAt;
  @CreatedBy private @Column(nullable = false, length = 100) String createdBy;
  @LastModifiedDate private @Column(nullable = false) LocalDateTime modifieddAt;
  @LastModifiedBy private @Column(nullable = false, length = 100) String modifiedBy;

  protected Article() {}

  private Article(String title, String content, String hashtag) {
    this.title = title;
    this.content = content;
    this.hashtag = hashtag;
  }

  public static Article of(String title, String content, String hashtag) {
    return new Article(title,content,hashtag);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Article article)) return false;
    return id != null && Objects.equals(id, article.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
