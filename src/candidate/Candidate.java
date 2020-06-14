package candidate;
import voter.Voter;
public class Candidate extends Voter{
	private long cid;
	private String vid ;  //voter id of candidate == used for comparison
	private String cname;
	private String constituency;
	private long votes;
	private String party;
	public Candidate(String v,String constituency,String party){
        super();
		this.vid = v;
		this.constituency = constituency;
		this.votes = 0;
		this.party = party;
	}
    public long getCID(){
    	return cid;
    }
    public void incrCid(){
        ++cid;
    }
    public long getVotes(){
    	return votes;
    }
    public String cname(){
    	return cname;
    }
    public String cons(){
    	return constituency;
    }
    public String party(){
    	return party;
    }
    public String vid(){
    	return vid;
    }
}