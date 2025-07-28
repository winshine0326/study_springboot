package com.jojoldu.book.springboot.domain.posts;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor // 롬복의 어노테이션 같은 경우 Kotlin 등으로 전환 시 필요 없어지면 삭제 가능하기에 class와 멀리 둠.
@Entity // JPA 필수 어노테이션이기에 class와 가까이 둠.
public class Posts {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 500, nullable = false)
  private String title;

  @Column(columnDefinition = "TEXT", nullable = false)
  private String content;

  private String author;

  @Builder
  public Posts(String title, String content, String author) {
    this.title = title;
    this.content = content;
    this.author = author;
  }
}
