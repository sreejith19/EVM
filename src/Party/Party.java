package src.Party;

import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
/**
 *
 * @author Tapan
 */
public class Party {
    private long pid;
    private String partyname;
    private long seats;
    Party(long pid,String partyname){
        this.pid = pid;
        //instead of party symbol we use pid
        this.partyname = partyname;
        this.seats = 0;
    }
    public long getPid(){
        return pid;
    }
    public String getPartyName(){
        return partyname;
    }
    public long getSeats(){
        return seats;
    }
    public void incrSeat(){
        ++seats;
    }
    public static String addParty(String partyname,Party p)throws IOException{
        long id=0;
        boolean status = false;
          try{
              BufferedReader br = new BufferedReader(
                      new FileReader("C:\\Users\\Tapan\\Documents\\NetBeansProjects\\EVM\\src\\Party\\"
                              + "partyid_counter.txt"));
              id = Long.parseLong(br.readLine());
              p = new Party(id,partyname);
              status = true;
              br.close();
          }
          catch(IOException e){
              System.out.println("File not Found!");
          }
          try{
              FileWriter w = new FileWriter("C:\\Users\\Tapan\\Documents\\NetBeansProjects\\EVM\\src\\Party\\"
                              + "partyid_counter.txt");
              w.write(String.valueOf(id+1)); 
              w.close();
          }
          catch(IOException ie){
              System.out.println("File not Found!");
          }
          if(status)
              return id + " " + partyname + " " + "0";
          else
              return null;
    }
    public static void main(String[] args) throws IOException{
       System.out.println("Welcome to party registration console");
       try(FileWriter out = 
               new FileWriter("C:\\Users\\Tapan\\Documents\\NetBeansProjects\\EVM\\src\\Party\\party.txt",true))
       {
            Scanner sc = new Scanner(System.in);
            String s ;
            Party p=null;
            System.out.println("get party name");
            s = sc.nextLine();
            String result = addParty(s,p);
            if(result!=null){
                out.write(result);
                out.write("\n");
            }
       }
       catch(IOException e){
           System.out.println("error");
       }
}
}
