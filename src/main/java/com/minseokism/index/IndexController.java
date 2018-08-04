package com.minseokism.index;

import com.minseokism.post.Post;
import com.minseokism.post.PostRepository;
import com.minseokism.post.PostStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.data.domain.ExampleMatcher.matching;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final PostRepository postRepository;

    @GetMapping("/")
    public String home(@RequestParam(required = false) String q, Model model, @PageableDefault(size = 5, sort = "regDate", direction = Sort.Direction.DESC) Pageable pageable){
        Example<Post> post = Example.of(new Post(q, PostStatus.Y),
                matching()
                        .withMatcher("title", ExampleMatcher.GenericPropertyMatcher::contains));
        model.addAttribute("posts", postRepository.findAll(post, pageable));
        return "index";
    }
}

