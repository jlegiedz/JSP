package BookRepository;

import sdaLibrary.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENT on 2017-10-03.
 */
public class BookRepository {

    private static List<Book> list = new ArrayList<>();

    public static void add(Book book){
        list.add(book);
    }

    private static List<Book> getBooks(){
        return list;
    }
}
