package sdaLibrary;


public enum Element {
    INDEX("Strona glowna","/"),
    ADD_BOOKS("Dodawanie ksiazek","/books/add"),
    BOOKS_LIST("Lista ksiazek","/books"),
    BOOK_RESERVATION("Wypozyczanie ksiazek","/books/reservation"),
    REGISTRATION("Zarejestruj sie","/register"),
    LOGIN("Zaloguj sie","/login");

    private String elementName;
    private String url;

    Element(String elementName, String url) {
        this.elementName = elementName;
        this.url = url;
    }

    public String getElementName() {
        return elementName;
    }

    public String getUrl() {
        return url;
    }
}
