package me.kimbeumryong.springbootdeveloper.repository;


import me.kimbeumryong.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
