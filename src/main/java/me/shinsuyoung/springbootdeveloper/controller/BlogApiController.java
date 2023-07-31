package me.shinsuyoung.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.shinsuyoung.springbootdeveloper.domain.Article;
import me.shinsuyoung.springbootdeveloper.dto.AddArticleRequest;
import me.shinsuyoung.springbootdeveloper.dto.ArticleResponse;
import me.shinsuyoung.springbootdeveloper.dto.UpdateArticleRequest;
import me.shinsuyoung.springbootdeveloper.service.BlogService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BlogApiController {

    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request){

        Article savedArticle = blogService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);

    }


    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>>findAllArticles(){
        List<ArticleResponse> articles = blogService.finalAll()// 글 전체 조회하는 서비스 소속 메서드를 호출
                .stream()
                .map(ArticleResponse::new) // 응답용 객체로 파싱
                .toList();

        return ResponseEntity.ok()
                .body(articles); // 바디에 담아서 전송함
    }



    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id){
        blogService.delete(id);
        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article>updateArticle(@PathVariable long id,
                                                @RequestBody UpdateArticleRequest request){
        Article updatedArticle = blogService.update(id,request);

        return ResponseEntity.ok()
                .body(updatedArticle);
    }



}
