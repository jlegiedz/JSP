package Controller;
import BookRepository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sdaLibrary.Book;
import sdaLibrary.BookGenre;
import sdaLibrary.ModelAndViewWithMenu;
import sdaLibrary.Nationality;
import sdaRandom.BookGenerator;
import java.util.List;


@Controller
public class BookListController {

    @RequestMapping(value="/")
    public ModelAndView startPage(){
        ModelAndView model = new ModelAndViewWithMenu();
        model.setViewName("mainPage.jsp");
        return model;
    }
    // po parametrze books wywola sie ta metoda
    @RequestMapping(value="/books")
    public ModelAndView getBooks(){
        ModelAndView model = new ModelAndViewWithMenu();
        List<Book> list = BookRepository.getBookList();

        //jak bedziesz sie odwolywal do parametru o nazwie list dostaniesz liste ksiazek:
        // to jest w jsp jako item
        model.addObject("list",list);

        // do tego modelu bedzie mic dostep booklist.jsp i ja wygeneruj
        // uzytkownik nie wie o jsp- uzytkownik wpisuje /books
        model.setViewName("bookController.jsp");
        return model;

    }

    @RequestMapping(value="/books/add")
    public ModelAndView addBookPage(){
        ModelAndView model = new ModelAndViewWithMenu();
        model.addObject("genreList", BookGenre.values());
        model.setViewName("addBook.jsp");
        return model;
    }

    @RequestMapping(value="/books/reservation")
    public ModelAndView bookReservationPage(@RequestParam(name = "bookId") /*required= false */String id){
        ModelAndView model = new ModelAndViewWithMenu();
        model.addObject("book", BookRepository.getBook(id));
        model.addObject("nationalityList", Nationality.values());
        model.setViewName("reservation.jsp");
        return model;
    }







}
