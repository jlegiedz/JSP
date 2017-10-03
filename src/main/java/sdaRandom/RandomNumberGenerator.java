package sdaRandom;

import java.util.Random;

/**
 * Created by RENT on 2017-09-29.
 */
public class RandomNumberGenerator {
    public static String drawLottoNumbers(){
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < 6 ; i++) {
            if(i!=0){
                sb.append(", ");
            }
            sb.append(random.nextInt(49)+1);
        }
        return  sb.toString();
    }
}
