package BookRepository;
import sdaLibrary.Book;
import sdaRandom.RandomNumberGenerator;
import java.util.ArrayList;
import java.util.List;


public class BookRepository {

    private static List<Book> list = new ArrayList<>();

    public static void add(Book book){
        book.setId(RandomNumberGenerator.getNextSequence());
        list.add(book);
    }


    public static List<Book> getBookList(){
        return list;
    }

    public static Book getBookById(String id){
        if(id == null){
            return null;
        }
        Book result =
                list.stream()
                        .filter(book -> Integer.toString(book.getId()).equals(id)).findAny().orElse(null);
        return result;
    }
}
