package article.service;

import article.domain.ArticleVO;
import article.repository.ArticleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleDAO articleDAO;

    public void create(ArticleVO articleVO) throws Exception{
        articleDAO.insertArticle(articleVO);
    }

    public ArticleVO getArticle(ArticleVO articleVO) throws Exception{
        return articleDAO.selectOne(articleVO);
    }

    public void update(ArticleVO articleVO) throws Exception{
        articleDAO.updateArticle(articleVO);
    }

    public void delete(ArticleVO articleVO) throws Exception {
        articleDAO.deleteArticle(articleVO);
    }

    public List<ArticleVO> listAll() throws Exception{
        return articleDAO.selectAll();
    }
}
