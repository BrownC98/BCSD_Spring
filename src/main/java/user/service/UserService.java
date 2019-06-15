package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.domain.LoginDTO;
import user.domain.UserVO;
import user.mapper.UserDAO;

import java.util.Date;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    //회원가입
    public void register(UserVO userVO) {
        userDAO.userRegister(userVO);
    }

    //로그인
    public UserVO login(LoginDTO loginDTO) throws Exception{
        return userDAO.login(loginDTO);
    }

    //자동 로그인
    public void keepLogin(String userId, String sessionId, Date SessionLimit) throws Exception{
        userDAO.keepLogin(userId, sessionId, SessionLimit);
    }


    public UserVO checkLoginBefore(String Cookie) throws Exception{
        return userDAO.checkLoginBefore(Cookie);
    }
}
