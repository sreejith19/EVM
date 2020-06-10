/*
This is used to store the polling percentage of each elections
and for polling each candidate
THIS IS JUST A BOILERPLATE PROGRAM NOT EXACT ONE
JUST INCLUDED SAMPLE OUTLINE
*/

/* Compile using javac -d . Poll.java
java src.Poll

*/
package poll;
import java.util.Scanner;


//Note:The Display functions are to be incorporated in frontend ,the below code is sample software only

//Sample Boilerplate Class for testing
// import Candidate.Candidate;

public class Poll{
	public static int no_of_voters;
	public static void incr_voters(){  //should be available across packages
		 ++no_of_voters;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Online Voting Portal,Stay Home Stay Safe");
		/* Verification of voters details are done in another program
		Only then they are allowed to access this application */

		/* Simailarly,details of verified candidates are allowed to publish */
		/*It is advised to be included in another program */

		System.out.println("Cast Your Vote");
		/* Displaying the details of the candidates */
		/*Now just sample */

		String[] cnames = {"Tapan Manu","Sreejith A","Sujith VI","NOTA"};
		int[] votes = {0,0,0,0};

		/* Here ,instead storing names as strings create a candidate object corresponding that */


		for (int i= 0;i<cnames.length;i++)
			System.out.println((i+1)+". "+cnames[i]);

		/* Better this program should be called by another running program in which each of the user gets a chance to increment
		his/her vote. We can use multithreaded programming also to achieve concurrency in polling */

		Scanner sc = new Scanner(System.in);

		//Loop to test for multiple voting

		for(int j=0;j<5;j++){
		incr_voters();
		int cast = sc.nextInt();
		/* I repeat,this is not the correct procedure candidate object should have votes attribute
		 and it should be increased */
		if(cast<=cnames.length)
			votes[cast-1]+=1;
		else{
			System.out.println("Invalid polling,Chance Over");
			votes[cnames.length-1]+=1;
		}
	}

	/* Real time status after voting  by 5 people */
		System.out.println("No of voters:"+no_of_voters);
		for (int i=0;i<cnames.length;i++)
			System.out.println(cnames[i]+"  "+votes[i]);

		/* Store the result to database */

	}
}