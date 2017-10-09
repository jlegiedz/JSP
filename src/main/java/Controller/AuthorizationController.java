package Controller;

import UserRepository.UserRepository;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sdaLibrary.BookGenre;
import sdaLibrary.ModelAndViewWithMenu;
import sdaLibrary.Nationality;
import sdaLibrary.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class AuthorizationController {

    // nie interesuje go sesja, interesuje ja tylko czy jest zalogowany
    @RequestMapping(value = "/anonymous")
    public ModelAndView anonymousPage() {
        ModelAndView model = new ModelAndViewWithMenu();
        model.addObject("loggedUser", "anonymous");
        model.setViewName("anonymous.jsp");
        return model;
    }

    @RequestMapping(value = "/login")
    public ModelAndView login() {
        ModelAndView model = new ModelAndViewWithMenu();
        model.setViewName("login.jsp");
        return model;
    }

    @RequestMapping(value = "/loginUser", method = RequestMethod.POST )
    public String loginUser(HttpServletRequest request,
                            @ModelAttribute("login") String login,
                            @ModelAttribute("password") String password) {
       boolean registered = UserRepository.isUserRegistered("login");
        if(registered == true){

        }

    }

    //request zawiera to co uzytkownik poda w formularzu lub ciasteczka,
    // lub np informacja o danych z sesji- te dane sa opakowane w obiekt requesta
    // protokol http jest bezstanowy wiec zeby moc zasymulowac stan - by pamietal cos,
    // trzeba je zapisac w sesji i gdzies przechowywac


    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/";
    }

    // adres z przegladarki- tu wypluj efekt

    @RequestMapping(value = "/register")
    public ModelAndView registerPage() {
        ModelAndView model = new ModelAndViewWithMenu();
        model.addObject("nationalityList", Nationality.values());
        model.setViewName("register.jsp");
        return model;
    }



    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public String rentBook(@ModelAttribute("userForm") User user,
                           @ModelAttribute("login") String login,
                           @ModelAttribute("password") String password,
                           HttpServletResponse response,
                           HttpServletRequest request) {
        boolean valid = User.doValidation(user);

        if ((!valid)) {
            return "redirect:/";
        }
        if((login.isEmpty() || password.isEmpty())){
            return "redirect:/";
        }
        HttpSession session = request.getSession();
        // dodajemy do sesji, poki jest otwarta to bedzie miala w sobie ten atrybut
        if (session != null)
            session.setAttribute("userLogin", login);
        UserRepository.addUserToList(user);
        return "redirect:/authenticated";

    }



    @RequestMapping(value = "authenticated")
    public ModelAndView authenticatedPage(HttpServletRequest request,
                                          HttpServletResponse response) {
        ModelAndView model = new ModelAndViewWithMenu();
        HttpSession session = request.getSession(false);
        if (session != null) {
            String userLogin = (String) session.getAttribute("userLogin");
            if (userLogin != null) {
                model.addObject("loggedUser", userLogin);
            } else {
                model.setViewName("error.jsp");
                return model;
            }
        } else {
            model.setViewName("error.jsp");
            return model;
        }
        model.setViewName("mainPage.jsp");
        return model;
    }


}
