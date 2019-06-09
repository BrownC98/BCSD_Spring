package article.repository;

import article.domain.ArticleVO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("articleDao")
public interface ArticleDAO {
    @Insert("INSERT INTO article(title, writer, content, regDate, viewCnt) " +
            "values(#{title}, #{writer}, #{content}, #{regDate}, #{viewCnt})")
    public void insertArticle(ArticleVO articleVO);

    @Update("UPDATE article SET title=#{title}, content=#{content} " +
            "WHERE articleNo = #{articleNo}")
    public void updateArticle(ArticleVO articleVO);

    @Delete("DELETE FROM article WHERE articleNo = #{articleNo}")
    public void deleteArticle(ArticleVO articleVO);

    @Select("SELECT * FROM article WHERE articleNo = #{articleNo}")
    public ArticleVO selectOne(ArticleVO articleVO);

    @Select("SELECT * FROM article")
    public List<ArticleVO> selectAll();

//    VO와 DB 컬럼 매핑구문 (굳이 필요한지는 모르겠음 -> mybatis 에서 자동화해주는지 모르겠음)
//    실험을 해봐야 알수있는 부분인듯 -> 안해주면 null 값이 나온다. 일단은 해주자
//    @Results(value = {
//            @Result(column = "boardId", property = "articleNo"),
//            @Result(column = "boardTitle", property = "title"),
//            @Result(column = "boardWriter", property = "writer"),
//            @Result(column = "boardContent", property = "content"),
//            @Result(column = "boardDate", property = "regDate"),
//            @Result(column = "boardCount", property = "viewCnt"),
//    })
}