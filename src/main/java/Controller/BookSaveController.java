package Controller;
import BookRepository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sdaLibrary.Book;

@Controller
public class BookSaveController {
    // alias w formularzu addBook
    //@ModelAttr- odnosi sie do nazwy formularza
    @RequestMapping(value="/addBook",method = RequestMethod.POST)
    public String addBook(@ModelAttribute("bookForm") Book book){
        System.out.println(book.getTitle());
        System.out.println(book.getIsbn());
        System.out.println(book.getPageCount());
        System.out.println(book.getAuthor());
        System.out.println(book.getGenre());
        BookRepository.add(book);
        return "mainPage.jsp";
    }
}
