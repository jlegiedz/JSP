package UserRepository;
import sdaLibrary.User;
import sdaRandom.RandomNumberGenerator;
import java.util.ArrayList;
import java.util.List;



public class UserRepository {

    private static List<User> userList = new ArrayList<>();

    public static void addUserToList(User user){
        // spr czy juz istneije
        user.setId(RandomNumberGenerator.getNextSequenceForUser());
        userList.add(user);
    }

    public static List<User> getUserList(){
        return userList;
    }

    public static User getUserById(String id){
        if(id==null){
            return null;
        }
        User result = userList.stream().
                    filter(user -> (Integer.toString(user.getId()).equals(id))).findAny().orElse(null);
        return result;

    }


}
