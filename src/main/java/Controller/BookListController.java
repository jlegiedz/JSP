package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sdaLibrary.Book;
import sdaRandom.BookGenerator;
import java.util.List;

/**
 * Created by RENT on 2017-10-02.
 */
@Controller
public class BookListController {

    // po parametrze books wywola sie ta metoda
    @RequestMapping(value="/books")
    public ModelAndView getBooks(){
        ModelAndView model = new ModelAndView();
        List<Book> list = BookGenerator.listGenerator(3);

        //jak bedziesz sie odwolywal do parametru o nazwie list dostaniesz liste ksiazek:
        // to jest w jsp jako item
        model.addObject("list",list);

        // do tego modelu bedzie meic dostep booklist.jsp i ja wygeneruj
        // uzytkownik nie wie o jsp- uzytkownik wpisuje /books
        model.setViewName("bookController.jsp");
        return model;

    }


}
