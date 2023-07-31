package me.shinsuyoung.springbootdeveloper.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.shinsuyoung.springbootdeveloper.domain.Article;
import me.shinsuyoung.springbootdeveloper.dto.AddArticleRequest;
import me.shinsuyoung.springbootdeveloper.dto.UpdateArticleRequest;
import me.shinsuyoung.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request){ // 글 저장
        return blogRepository.save(request.toEntity()); // AddArticleRequest클래스에 저장된 값들을 article 데이터 베이스에 저장함
    }

    public List<Article>finalAll(){ // 글 조회
        return blogRepository.findAll();

    }


    public void delete(long id){
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(Long id, UpdateArticleRequest request){
        Article article = blogRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not found: "+id));
        article.update(request.getTitle(), request.getContent());
        return article;
    }

}
