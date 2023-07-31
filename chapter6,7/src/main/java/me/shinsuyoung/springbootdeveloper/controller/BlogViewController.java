package me.shinsuyoung.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.shinsuyoung.springbootdeveloper.domain.Article;
import me.shinsuyoung.springbootdeveloper.dto.ArticleListViewResponse;
//import me.shinsuyoung.springbootdeveloper.dto.ArticleViewResponse;
import me.shinsuyoung.springbootdeveloper.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BlogViewController {

    private final BlogService blogService;

    @GetMapping("/articles")
    public String getArticles(Model model) {
        List<ArticleListViewResponse> articles = blogService.finalAll()
                .stream()
                .map(ArticleListViewResponse::new)
                .toList();
        model.addAttribute("articles", articles);

        return "articleList";
    }
}
