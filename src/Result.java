//result declaration
/*
//Boilerplate class !!!! no need to maintain
import Candidate.Candidate;

public class Result{
	public static void main(String[] args) {
		//read data from database
		//no need for this just for testing........
		/*Candidate c[] = {new Candidate(1,"Tapan","Thiruvalla",1000),
						 new Candidate(2,"Sreejith","Attingal",1111),
						 new Candidate(3,"Sujith","Kannur",1223),
						 new Candidate(4,"Ambrose","Thiruvalla",111),
						 new Candidate(5,"Paul","Kannur",1222)};

                        */
		//read from database about unique constituencies

/*
		String[] cons = {"Thiruvalla","Kannur","Attingal"};

		long max[]=new long[cons.length];
		long secmax[] = new long[cons.length];

		for(int i=0;i<c.length;i++){
			for(int j=0;j<cons.length;j++){
			if (c[i].constituency == cons[j])
				if(c[i].votes>max[j])
					max[j]=c[i].votes;
				else if(c[i].votes<max[j] && c[i].votes>secmax[j])
					secmax[j]=c[i].votes;
		}
		}

		//declaring winner for each constituencies
		for(int j=0;j<cons.length;j++)
			for(int i=0;i<c.length;i++)
				if(c[i].votes == max[j])
					System.out.println("Winner:"+c[i].cname+" of "+c[i].constituency+" by "+(max[j]-secmax[j])+" votes ");
	}
}*/