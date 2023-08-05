package me.shinsuyoung.springbootdeveloper.repository;

import me.shinsuyoung.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {

    // JpaRepository 클래스를 상속 받을때 엔티티 Article과 엔티티의 PK타입 longdf dlstnfh sjgdma
}
