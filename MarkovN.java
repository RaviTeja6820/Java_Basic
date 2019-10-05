package RandomText;


/**
 * Write a description of MarkovN here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
public class MarkovN {
private String myText;
    private Random myRandom;
    private int n;
    public MarkovN(int num) {
        n=num;
        myRandom = new Random();
    }
    
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
    
    public void setTraining(String s){
        myText = s.trim();
    }
    public ArrayList<String> getFollows(String key){
        ArrayList<String> list = new ArrayList<String>();
        int index=0;
        //System.out.println(myText.length());
        while(index < myText.length()){
            int start = myText.indexOf(key,index);
            if(start==-1){
                break;
            }
            if(start + key.length() > myText.length()-1){
                break;
            }
            String next = myText.substring(start+key.length(),start+key.length()+1);
            list.add(next);
            index = start + key.length();
        }
        return list;
    }
    
    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-n);
        String key = myText.substring(index,index+n);
        sb.append(key);
        for(int k=0; k < numChars-n; k++){
            ArrayList<String> list = getFollows(key);
            if(list.size()==0)
            break;
            index = myRandom.nextInt(list.size());
            String next = list.get(index);
            sb.append(next);
            key = key.substring(1) + next;
        }
        
        return sb.toString();
    }
}
