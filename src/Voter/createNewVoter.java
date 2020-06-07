package src.Voter;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Scanner;
import java.io.FileWriter; //used instead of Database to store temporary(voter's list) data 
//import Voter.Voter ;   //compile in parent directory of voter i.e in src otherwise error

class VoteEligibility extends Exception{
	public VoteEligibility(String s){
		super(s);
	}
}

class NewVoter{
	public static void getDiff(GregorianCalendar a,GregorianCalendar b) throws VoteEligibility{
        int diff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
            if (a.get(Calendar.MONTH) > b.get(Calendar.MONTH) || 
                   (a.get(Calendar.MONTH) == b.get(Calendar.MONTH) && a.get(Calendar.DATE) > b.get(Calendar.DATE))) {
                                    diff--;
                                }
        if(diff<18)
        	throw new VoteEligibility("under 18 years of age !\nnot eligible for application");
	}
	public static void main(String[] args) throws IOException{
		try(FileWriter out = new FileWriter("C:\\Users\\Tapan\\Documents\\NetBeansProjects\\EVM\\src\\voter.txt")){
			Scanner sc = new Scanner(System.in);
			int count=0;
			long uid;
			String s;
			GregorianCalendar g ;
			while(count<=1){
				//data should be read from aadhar database
				System.out.println("Get the User ID");
				uid=sc.nextLong();
				System.out.println("Get the Name");
				sc.nextLine();//avoid error of sc skipping new line
				s=sc.nextLine();
				System.out.println("Get the Dob(YYYY/MM/DD)");
				String dob = sc.nextLine();
				String[] date=dob.split("/",3);
				try{
				g = new GregorianCalendar(Integer.parseInt(date[0]),Integer.parseInt(date[1])-1,Integer.parseInt(date[2]));
                getDiff(g,new GregorianCalendar());
                }
                catch(VoteEligibility e){
                      System.out.println(e.getMessage());
                      count++;
                      continue;
                }
				Voter v = new Voter(uid,s,g);
				String output = v.getVoterId()+ " " + s + " " + dob ;
				out.write(output);
				out.write("\n");
				//voter id not written now!!
/* gets 2 strings at a time */
				++count;
			}
		}
		catch(IOException e){
			System.out.println("The system has detected some failure!");
		}
          

	}
}