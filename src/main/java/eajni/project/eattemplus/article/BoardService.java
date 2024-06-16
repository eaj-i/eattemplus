package eajni.project.eattemplus.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public Article save(ArticleRequest articleRequest){
        return boardRepository.save(articleRequest.toEntity());
    }

    public List<Article> readAll(){
        return boardRepository.findAll();
    }


    public Article readOne(long id){
        return boardRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not found"+id));
    }


}
