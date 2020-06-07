package src.Candidate;

import java.util.Scanner;
import java.io.FileWriter; 
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Calendar;


class IOn{
    public static String getDate(String searchid) throws IOException{
    	try{
    	BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Tapan\\Documents\\NetBeansProjects\\EVM\\src\\voter.txt"));
    	int flag=0;
    	String line;
    	while((line=in.readLine())!=null && !(searchid.equals(null)))  
           {  
               String[] lsplit =  line.split(" ",4);
               if(lsplit[0].equals(searchid)){
               	 flag=1;
               	 return (lsplit[lsplit.length-1]);
               }
           }  
           if(flag==0){
           	 System.out.println("no matching record");
           	 return null;
           }
            
        }
        catch(IOException e){
             System.out.println("error");
             return null;
    	}
    	return null;
    }
}

class CandidateEligibility extends Exception{
	public CandidateEligibility(String s){
		super(s);
	}
}

class Ticket {
	public static void getDiff(GregorianCalendar a,GregorianCalendar b) throws CandidateEligibility{
        int diff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
            if (a.get(Calendar.MONTH) > b.get(Calendar.MONTH) || 
                   (a.get(Calendar.MONTH) == b.get(Calendar.MONTH) && a.get(Calendar.DATE) > b.get(Calendar.DATE))) {
                                    diff--;
                                }
        if(diff<25)
        	throw new CandidateEligibility("under 25 years of age !\nnot eligible for application");
	}
	public static void main(String[] args) {
		try(FileWriter out = new FileWriter("C:\\Users\\Tapan\\Documents\\NetBeansProjects\\EVM\\src\\candidate.txt")){
			Scanner sc = new Scanner(System.in);
			int count=0;
			long cid;
			String vid,s,cons,party;
			GregorianCalendar g;
			while(count<=1){
				//data should be read from aadhar database
				System.out.println("Get the Candidate ID");
				cid=sc.nextLong();
				System.out.println("Get the Name");
				sc.nextLine();//avoid error of sc skipping new line
				s=sc.nextLine();
				System.out.println("Get the VoterID");
				vid = sc.nextLine();
				System.out.println("Get the party");
				party=sc.nextLine();
				System.out.println("Get the constituency");
                                cons=sc.nextLine();
                /*request for mechanism to check for valid application as 
                     1. Same candidate cannot participate for two diff parties at two diff places
                     2. No two candidates in same constituency under same party ticket
                */     
                                //same party and cons cannot appear more than once
                                //otherwise party should give candidate change option

				
				try{
                                   String[] date;
				  try{	
				     date = IOn.getDate(vid).split("/",3);
			         }
			      catch(NullPointerException np){
                      System.out.println("No voter ID! Ineligible to apply");
                      count++;
                      continue;
			    }
				g = new GregorianCalendar(Integer.parseInt(date[0]),Integer.parseInt(date[1])-1,Integer.parseInt(date[2]));
                getDiff(g,new GregorianCalendar());
                }
                catch(CandidateEligibility e){
                      System.out.println(e.getMessage());
                      count++;
                      continue;
                }
                String[] strArray = new String[]{String.valueOf(cid),cons,party};
                int validity = Validity.valid(strArray);
                if(validity==1){
                Candidate cd = new Candidate(cid,vid,s,cons,party);
				String output = cd.getCID()+ " " + s + " " + cons + " " + party + " "+ cd.vid();
				out.write(output);
				out.write("\n");
			
			}
                else{
                    System.out.println("invalid registration");
                }
                ++count;
                }
		}
		catch(IOException e){
			System.out.println("The system has detected some failure!");
		}
		
	}


}