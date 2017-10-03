package sdaRandom;

import sdaLibrary.Author;
import sdaLibrary.Book;
import sdaLibrary.BookGenre;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by RENT on 2017-10-02.
 */
public class BookGenerator {

    private static final String[] COUNTRY_CODES = new String[]{"PL", "USA", "DE", "FR"};

    public static Book createBook(String title, String authorName, String authorSurname){
        Random random= new Random();
        Author author  =  new Author(authorName,
                authorSurname,
                COUNTRY_CODES[random.nextInt(COUNTRY_CODES.length)]);
        BookGenre[] values = BookGenre.values();
        Book book = new Book(title,
                generateIsbnNumber(random),
                random.nextInt(1500),
                author,
                values[random.nextInt(values.length)]);
        return book;
    }

    private static String generateIsbnNumber(Random random){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10 ; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    private static final String[] TITLES = new String[]{"Pan Tadeusz", "Zmrok", "Podstawy szydelkowania", "Zrob to sam","Basnie dla dzieci"};
    private static final String[] AUTHOR_NAMES = new String[]{"Jan", "Maria", "Katarzyna", "Wlodzimierz"};
    private static final String[] AUTHOR_SURNAMES = new String[]{"Kowalski", "Nowak", "Dybalski", "Szydlowski"};


    public static List<Book> listGenerator(int bookNumber){
        List<Book> list = new ArrayList<Book>();
        Random random = new Random();

        while(bookNumber > 0){
            list.add(BookGenerator.createBook(TITLES[random.nextInt(TITLES.length)],
                    AUTHOR_NAMES[random.nextInt(AUTHOR_NAMES.length)],
                    AUTHOR_SURNAMES[random.nextInt(AUTHOR_SURNAMES.length)]));
            bookNumber--;
        }
        return list;
    }
}
