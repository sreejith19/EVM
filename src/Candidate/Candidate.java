
package src.Candidate;
import src.Voter.Voter;
public class Candidate extends Voter{
	private long cid;
	private String vid ;  //voter id of candidate
	private String cname;
	private String constituency;
	private long votes;
	private String party;
	public Candidate(long cid,String v,String cname,String constituency,String party){
		this.cid = cid;
		this.vid = v;
		this.cname = cname;
		this.constituency = constituency;
		this.votes = 0;
		this.party = party;
	}
    public long getCID(){
    	return cid;
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