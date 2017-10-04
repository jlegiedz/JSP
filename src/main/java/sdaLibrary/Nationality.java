package sdaLibrary;

public enum Nationality {
    PL("Polish"),
    DE("German"),
    FR("French"),
    IT("Italian");


    private String userNationality;

    Nationality(String userNationality){
        this.userNationality=userNationality;
    }

    public String getUserNationality() {
        return userNationality;
    }
}
