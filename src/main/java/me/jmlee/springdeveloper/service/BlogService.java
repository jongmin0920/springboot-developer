package me.jmlee.springdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.jmlee.springdeveloper.dao.Article;
import me.jmlee.springdeveloper.dto.ArticleCreationRequest;
import me.jmlee.springdeveloper.dto.ArticleUpdateRequest;
import me.jmlee.springdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(ArticleCreationRequest articleCreationRequest) {
        return blogRepository.save(articleCreationRequest.toEntity());
    }

    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    public Article getById(Long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    public void deleteById(Long id) {
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(Long id, ArticleUpdateRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }
}
