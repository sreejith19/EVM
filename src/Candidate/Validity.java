
package src.Candidate;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author Tapan
 */
public class Validity {
    public static boolean partyplace(String[] w,String[] list){
        //diff candidate with same party and cons are not allowed
        return !(w[w.length-3].equals(list[1]) && w[w.length-2].equals(list[2]));
        }
    public static boolean candidateparty(String[] w,String[] list){
        return ((w[w.length-2].equals(list[2]) && w[0].equals(list[0]))||
                !w[0].equals(list[0]));
    }
    public static int valid(String[] list) throws IOException{
        try{
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Tapan\\Documents\\NetBeansProjects\\EVM\\src\\candidate.txt"));
        String line;
        int valid=1;
        while((line=br.readLine())!=null){
            String[] w = line.split(" ",6);
            //should check all lines whether new candidate list is valid
            if(partyplace(w,list) && candidateparty(w,list))
                valid=1;
            else{
                System.out.println("not valid entry");
                return 0;
        }
        }
        return valid;
        }
        catch(IOException ie){
            System.out.println("cannot find");
        }
        return -1;  //error occurred!
    }
    
}
