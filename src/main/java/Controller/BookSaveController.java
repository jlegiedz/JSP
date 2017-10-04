package Controller;
import BookRepository.BookRepository;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sdaLibrary.Book;
import sdaLibrary.Nationality;
import sdaLibrary.User;

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
        return "redirect:/";
    }

    @RequestMapping(value="/rentBook", method = RequestMethod.POST)
    public String rentBook(@ModelAttribute("userForm") User user,
                           @ModelAttribute("userForm.bookId") String bookId){
        boolean valid = doValidation(user);
        if(!valid){
            return "redirect:/books/reservation?bookId="+ bookId +"&validationError=true";
        }
        //dodanie nowego uzytkownika i wypozyczenie ksiazki
        return "redirect:/books";
    }

    public boolean doValidation(User user){
       boolean valid;
        if(user.getNationality()== Nationality.PL && user.getPesel()!=""){
            valid = true;
        }
        else if(user.getNationality()!=Nationality.PL && user.getPassportNumber()!=""){
            valid = true;
        }
        else{
            valid=false;
        }
        return valid;

    }




}
