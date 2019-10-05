package RandomText;


/**
 * Write a description of Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
public class Tester {
public void runMarkovOne() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        MarkovOne markov = new MarkovOne();
        markov.setTraining(st);
        System.out.println(markov.getFollows("he").size()+"\n");
        //System.out.println(markov.getFollows("e"));
        //System.out.println(markov.getFollows("es"));
    }
}
