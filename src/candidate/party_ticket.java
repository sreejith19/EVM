package candidate;

import java.util.Scanner;
import java.io.FileWriter; 
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Calendar;
import poll.Valid;


class IOn{
    public static String getDate(String searchid) throws IOException{
    	try{
    	BufferedReader in = new BufferedReader(new FileReader("voter.txt"));
    	int flag=0;
    	String line;
    	while((line=in.readLine())!=null && !(searchid.equals(null)))  
           {  
               String[] lsplit =  line.split(" ",5);
               //System.out.println(lsplit[4]);
               if(lsplit[0].equals(searchid)){
               	 flag=1;
               	 return (lsplit[lsplit.length-2]);
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
        public static boolean isValidParty(String pname) throws IOException{
            try{
                //checking if party provided is registered party or not
                BufferedReader br = new BufferedReader(
                      new FileReader("party/party.txt"));
                String line ;
                while((line=br.readLine())!=null){
                    String name = line.split(" ",3)[1];
                    if(pname.equals(name)) //registered party
                        return true;
                }
            }
            catch(IOException e){
                System.out.println("error processing");
            }
            return false;
        }
	public static void main(String[] args) throws IOException{
		try(FileWriter out = new FileWriter("candidate.txt",true)){
			Scanner sc = new Scanner(System.in);
			int count=0;
			long cid=0;
			String vid,cons,party;
      String s = null;
			GregorianCalendar g;
			while(count<1){
				//data should be read from aadhar database
        System.out.println("get the candidate name");
        s = sc.nextLine();
				System.out.println("Get the VoterID");
				vid = sc.nextLine();
				System.out.println("Get the party");
				party=sc.nextLine();
                                /*there are cases in which candidates appear in 
                                constituencies other than they have voting id
                                */
				System.out.println("Get the constituency");
                                cons=sc.nextLine();
                                if(!isValidParty(party)){
                                    System.out.println("unregistered party,\n application rejected");
                                    count++;
                                    continue;
                                }
				try{
                                   String[] date;
				  try{
				     date = IOn.getDate(vid).split("/",4);
                                     
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
                /*try{
                  BufferedReader br = new BufferedReader(
                      new FileReader("C:\\Users\\Tapan\\Documents\\NetBeansProjects\\EVM\\src\\Candidate\\"
                              + "candidateid.txt"));
                     cid = Long.parseLong(br.readLine());
                     br.close();
                }   
                catch(IOException e){
                    System.out.println("file not found error");
                }
                */
                String[] strArray = new String[]{String.valueOf(vid).toLowerCase(),cons.toLowerCase(),
                                                       party.toLowerCase(),s.toLowerCase()};
                int validity = Validity.valid(strArray);
                if(validity==1 && Valid.validCons(cons)){
                Candidate cd = new Candidate(vid,cons,party);
				String output = cd.vid()+ " " + s + " " + cons + " " + party ;
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