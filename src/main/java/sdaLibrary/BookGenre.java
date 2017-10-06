package sdaLibrary;

public enum BookGenre {
    EPOS("Epopeja"),DRAMA("Dramat"), THRILLER("Thriller"), COMEDY("Komedia"),STORY("Powiesc");

    private String friendlyName;

    BookGenre(String friendlyName){
        this.friendlyName = friendlyName;
    }

    public String getFriendlyName() {
        return friendlyName;
    }
}
