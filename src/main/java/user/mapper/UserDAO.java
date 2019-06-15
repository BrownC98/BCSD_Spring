package user.mapper;

import user.domain.LoginDTO;
import user.domain.UserVO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface UserDAO {
    //회원가입
    @Insert("INSERT INTO user(userId, userPw, userName, userEmail) " +
            "VALUES(#{userId}, #{userPw}, #{userName}, #{userEmail})")
    public void userRegister(UserVO userVO);

    //로그인
    @Select("SELECT * FROM user WHERE userId = #{userId}")
    public UserVO login(LoginDTO loginDTO);

    //로그인 유지
    @Update("UPDATE user SET sessionKey = #{sessionKey}," +
                         " sessionLimit = #{sessionLimit}" +
            "WHERE userId = #{userId}")
    public void keepLogin(String userId, String sessionKey, Date sessionLimit);

    //쿠키값으로 세션키 찾기 즉, 세션키 검증
    @Select("SELECT * FROM user WHERE sessionKey = #{CookieKey}")
    public UserVO checkLoginBefore(String CookieKey);

}
