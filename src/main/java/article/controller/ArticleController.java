package article.controller;

import article.domain.ArticleVO;
import article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping(value = "/article")
public class ArticleController {
   @Autowired
   @Qualifier("articleService")
   private ArticleService articleService;
    //등록 페이지 이동
    @RequestMapping(value = "/write", method = RequestMethod.GET)
    public ModelAndView writeGet(ModelAndView mv){
        mv.setViewName("/article/write");
        return mv;
    }
    // 등록 처리
    @RequestMapping(value = "/write", method = RequestMethod.POST)
    public ModelAndView writePost(ModelAndView mv, ArticleVO articleVO,
                                  RedirectAttributes redirectAttributes) throws Exception {
        articleService.create(articleVO);
        redirectAttributes.addFlashAttribute("msg", "regSuccess");
        mv.setViewName("redirect:/article/list");
        return mv;
    }
    // 목록 페이지 이동
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list(ModelAndView modelAndView) throws Exception{
        modelAndView.addObject("articles", articleService.listAll());
        modelAndView.setViewName("/article/list");
        return modelAndView;
    }

    // 조회 페이지 이동
    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public ModelAndView read(ModelAndView modelAndView, ArticleVO articleVO) throws Exception{
        modelAndView.addObject("article", articleService.getArticle(articleVO));
        modelAndView.setViewName("/article/read");
        return modelAndView;
    }

    // 수정 페이지 이동
    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public ModelAndView modifyGet(ModelAndView modelAndView, ArticleVO articleVO) throws Exception{
        modelAndView.addObject("article", articleService.getArticle(articleVO));
        modelAndView.setViewName("/article/modify");
        return modelAndView;
    }

    // 수정 처리
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public ModelAndView modifyPost(ArticleVO articleVO, ModelAndView modelAndView,
                                   RedirectAttributes redirectAttributes) throws Exception{
        articleService.update(articleVO);
        redirectAttributes.addFlashAttribute("msg", "modSuccess");
        modelAndView.setViewName("redirect:/article/list");
        return modelAndView;
    }

    // 삭제 처리
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public ModelAndView remove(ModelAndView modelAndView, ArticleVO articleVO,
                                   RedirectAttributes redirectAttributes) throws Exception{
        articleService.delete(articleVO);
        redirectAttributes.addFlashAttribute("msg", "delSuccess");
        modelAndView.setViewName("redirect:/article/list");
        return modelAndView;
    }
}
