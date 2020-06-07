
package src.Candidate;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author Tapan
 */
public class Validity {
    public static boolean partyPlace(String[] w,String[] list){
        //diff candidate with same party and cons are not allowed
        //System.out.println(w.length);
        return !(w[w.length-3].equals(list[1]) && w[w.length-2].equals(list[2]));
        }
    public static boolean candidateParty(String[] w,String[] list){
        return ((w[w.length-2].equals(list[2]) && w[0].equals(list[0]))||
                !w[0].equals(list[0]));
    }
    public static int valid(String[] list) throws IOException{
        try{
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Tapan\\Documents\\NetBeansProjects\\EVM\\src\\candidate.txt"));
        String line;
        int valid=1;
        while((line=br.readLine())!=null){
            //System.out.println(line);
            String[] w = line.split(" ",6);
            //System.out.println(w[0]);
            //should check all lines whether new candidate list is valid
            if(!(partyPlace(w,list) && candidateParty(w,list)))
                valid=0;
        }
        return valid;
        }
        catch(IOException ie){
            System.out.println("cannot find");
        }
        return -1;  //error occurred!
    }
    
}
