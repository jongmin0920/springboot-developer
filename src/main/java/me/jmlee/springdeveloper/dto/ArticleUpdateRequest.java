package me.jmlee.springdeveloper.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 글 수정 요청 본문: {"title": "...", "content": "..."}
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleUpdateRequest {
    private String title;
    private String content;
}
