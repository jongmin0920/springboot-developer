package me.jmlee.springdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.jmlee.springdeveloper.dao.Article;
import me.jmlee.springdeveloper.dto.ArticleCreationRequest;
import me.jmlee.springdeveloper.dto.ArticleResponse;
import me.jmlee.springdeveloper.dto.ArticleUpdateRequest;
import me.jmlee.springdeveloper.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BlogApiController {
    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(
            @RequestBody ArticleCreationRequest articleCreationRequest) {
        Article savedArticle = blogService.save(articleCreationRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
    }

    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles() {
        List<ArticleResponse> articles = blogService.findAll()
                .stream()
                .map(ArticleResponse::new)
                .toList();

        return ResponseEntity.ok(articles);
    }

    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse> getById(
            @PathVariable Long id) {
        Article article = blogService.getById(id);

        return ResponseEntity.ok(new ArticleResponse(article));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleNotFound(IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        blogService.deleteById(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse> updateArticle(
            @PathVariable Long id,
            @RequestBody ArticleUpdateRequest request) {
        Article updatedArticle = blogService.update(id, request);

        return ResponseEntity.ok(new ArticleResponse(updatedArticle));
    }
}
