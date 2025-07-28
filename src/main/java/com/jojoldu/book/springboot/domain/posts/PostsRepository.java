package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> { // 제네릭에 들어가는 내용 : <Entity 클래스, PK 타입>\
  // 아무것도 작성 안해도 기본적인 CRUD 메소드가 자동 생성(테크놀로지아..)
}
// Entity 클래스와 기본 Entity Repository는 함께 위치해야함.
