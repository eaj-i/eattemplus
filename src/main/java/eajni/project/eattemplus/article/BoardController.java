package eajni.project.eattemplus.article;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> saveArticle(@RequestBody ArticleRequest articleRequest){
        Article newArticle = boardService.save(articleRequest);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newArticle);
    }

    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> getAll(){
        List<ArticleResponse> articles = boardService.readAll()
                .stream()
                .map(ArticleResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(articles);
    }

    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse> getOne(@PathVariable long id){
        Article article = boardService.readOne(id);

        return ResponseEntity.ok()
                .body(new ArticleResponse(article));
    }



}
