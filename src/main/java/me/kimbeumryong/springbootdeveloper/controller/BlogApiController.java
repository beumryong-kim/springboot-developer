package me.kimbeumryong.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.kimbeumryong.springbootdeveloper.domain.Article;
import me.kimbeumryong.springbootdeveloper.dto.AddArticleRequest;
import me.kimbeumryong.springbootdeveloper.dto.ArticleResponse;
import me.kimbeumryong.springbootdeveloper.dto.UpdateArticleRequest;
import me.kimbeumryong.springbootdeveloper.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@RestController // HTTP Response Body에 객체 데이터를 JSON 형식으로 반환하는 컨트롤러
public class BlogApiController {

    private final BlogService blogService;

    // HTTP 메서드가 POST일 때 전달받은 URL과 동일하면 메서드로 매핑
    @PostMapping("/api/articles")
    // @RequestBody로 요청 본문 값 매핑
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request, Principal principal) {
        Article savedArticle = blogService.save(request, principal.getName());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }

    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles() {
        List<ArticleResponse> articles = blogService.findAll()
                // findAll의 List<Article> 를 스트림(Stream)으로 변환
                .stream()
                // 각 Article 객체를 ArticleResponse 객체로 변환
                .map(ArticleResponse::new)
//                .map(article -> new ArticleResponse(article))
                // java 16 up
                .toList();
                // java 8~15 between
                // .collect(Collectors.toList());

        return ResponseEntity.ok()
                .body(articles);
    }

    // URL 경로에서 값 추출
    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable long id) {
        Article article = blogService.findById(id);

        return ResponseEntity.ok()
                .body(new ArticleResponse(article));
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id) {
        blogService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable long id,
         @RequestBody UpdateArticleRequest request) {
        Article updatedArticle = blogService.update(id, request);

        return ResponseEntity.ok()
                .body(updatedArticle);
    }
}