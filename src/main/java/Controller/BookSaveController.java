package Controller;
import BookRepository.BookRepository;
import UserRepository.UserRepository;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sdaLibrary.Book;
import sdaLibrary.ModelAndViewWithMenu;
import sdaLibrary.Nationality;
import sdaLibrary.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class BookSaveController {
    // alias w formularzu addBook
    //@ModelAttr- odnosi sie do nazwy formularza
    // :http://krams915.blogspot.com/2010/12/spring-3-mvc-using-modelattribute-in.html
    @RequestMapping(value="/addBook",method = RequestMethod.POST)
    public String addBook(@ModelAttribute("bookForm") Book book,
                          HttpServletRequest request /*post jest requestem */,
                          HttpServletResponse response){
        System.out.println(book.getTitle());
        System.out.println(book.getIsbn());
        System.out.println(book.getPageCount());
        System.out.println(book.getAuthor());
        System.out.println(book.getGenre());
        //wywolujac metode add ustawiam wartosc ID ksiazki w liscie i dodaje pozostale wart.pol ksiazki do listy
        BookRepository.add(book);
        Cookie cookieTitle = new Cookie("bookTitle", book.getTitle());
        cookieTitle.setMaxAge(30);
        Cookie cookiePageCount = new Cookie("bookPageCount", Integer.toString(book.getPageCount()));
        response.addCookie(cookieTitle);
        response.addCookie(cookiePageCount);
        return "redirect:/";
    }


//    @RequestMapping(value = "/rentBookByLoggedUser", method = RequestMethod.POST)
//    public String rentBookByLoggedUser(@ModelAttribute("bookId") Book book,
//                                       @ModelAttribute("userId") User user){
//        User user1 = UserRepository.getUserById(userId);
//        Book book1 =BookRepository.getBookById(bookId);
//        return "redirect:/";
//    }



    @RequestMapping(value="/rentBook", method = RequestMethod.POST)
    public String rentBook(@ModelAttribute("userForm") User user,
                           @ModelAttribute("bookId") String bookId,
                           HttpServletResponse response,
                           HttpServletRequest request){
        boolean valid = User.doValidation(user);
        if(!valid){
            return "redirect:/books/reservation?bookId="+ bookId +"&validationError=true";
        }
       UserRepository.addUserToList(user);
        //dodanie nowego uzytkownika i wypozyczenie ksiazki
        Cookie cookieId = new Cookie("userId", Integer.toString(user.getId()));
        cookieId.setMaxAge(40);
        response.addCookie(cookieId);
        return "redirect:/books";
    }






}
