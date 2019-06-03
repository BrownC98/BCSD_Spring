package article.repository;

import article.domain.ArticleVO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleDAO {
    @Insert("INSERT INTO board(boardId, boardTitle, boardWriter, boardContent, boardDate, boardCount) " +
            "values(SEQ_boardId.NEXTVAL, #{title}, #{writer}, #{content}, #{regDate}, #{viewCnt})")
    public void insertArticle(ArticleVO articleVO);

    @Update("UPDATE board SET boardTitle=#{title}, boardContent=#{content} " +
            "WHERE boardId = #{articleNo}")
    public void updateArticle(ArticleVO articleVO);

    @Delete("DELETE FROM board" +
            "WHERE boardId = #{articleNo}")
    public void deleteArticle(ArticleVO articleVO);

    @Select("SELECT * FROM board WHERE boardId = #{articleNo}")
    public ArticleVO selectOne(ArticleVO articleVO);

    @Select("SELECT * FROM board")
    public List<ArticleVO> selectAll();

//    VO와 DB 컬럼 매핑구문 (굳이 필요한지는 모르겠음 -> mybatis 에서 자동화해주는지 모르겠음)
//    실험을 해봐야 알수있는 부분인듯
//    @Results(value = {
//            @Result(column = "boardId", property = "articleNo"),
//            @Result(column = "boardTitle", property = "title"),
//            @Result(column = "boardWriter", property = "writer"),
//            @Result(column = "boardContent", property = "content"),
//            @Result(column = "boardDate", property = "regDate"),
//            @Result(column = "boardCount", property = "viewCnt"),
//    })
}