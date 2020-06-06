/*
Voter class
*requires a function that decrements counter when db finds a repeated uid(voter not created)
*create a file named "counter.txt" with initial counter value(AAA0000000) in the same folder, copy path below in functions setVoterId() and getCounter()
*/

//Tapan's comment = counter working not incrementing...but randomly changing and no characters when getvoterid() called

package Voter;
import java.util.GregorianCalendar;
import java.io.*;


public class Voter
{
    private long uid;
    private String voter_id;
    private String name;
    private GregorianCalendar dob;
    
    public Voter()
    {
        setVoterId();           //voterid in file is updated even when db rejects the input uid (ie, when uid is repeated); a function to decrement this number back is requiredin such case
    }
    
    public Voter(long uid)      //not preferred due to potential errors ; it is suggested to use default constructor and call setter functions
    {
        this();
        this.uid=uid;
    }
    
    public Voter(long uid , String name ,GregorianCalendar dob)  //not preferred
    {
        this();
        setName(name);
        setDob(dob);
        setUid(uid);
        setVoterId();
    }
    
    public void setName(String name)
    {
        this.name=name;
    }
    
    public void setDob(GregorianCalendar dob)
    {
        this.dob=dob;
    }
    
    public void setUid(long uid)
    {
        this.uid=uid;
    }
    
    private void setVoterId()       // similar update function required for the decrement in case of repetition of uid
    {
        int x;
        voter_id=getCounter();
        System.out.println(voter_id);
        String s=voter_id;
        char c[]=new char[s.length()];
        for(int i=0;i<s.length();i++)
            c[i]=s.charAt(i);
        int num=0;
        for(int i=3;i<10;i++)
        {
            num=num*10+c[i]-48;
        }
        System.out.println(num);
        num=(num+1)%10000000;
        if(num==0)
        {
            if(c[2]=='Z')       //all voterids are of the form "XXXDDDDDDD": X:Capital letter(A-Z) D:digits(0-9)
            {
                if(c[1]=='Z')
                {
                    if(c[0]=='Z')
                    {
                        System.out.println("out of id patterns");
                    }
                    else
                    {
                        c[0]=(char)(c[0]+1);
                    }
                }
                else
                {
                    c[1]=(char)(c[1]+1);
                }
            }
            else
            {
                c[2]=(char)(c[2]+1);
            }
        }
        for(int i=9;i>2;i--)
        {
            try{
                c[i]=Integer.toString(num).charAt(9-i);
            }
            catch(StringIndexOutOfBoundsException e)
            {
                c[i]='0';
            }
        }
        try
        {
            FileWriter f=new FileWriter("counter.txt");      //substitute path of text file here
                f.write(c);
                f.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private String getCounter()
    {
        char c[]=new char[10];
        try
        {
            FileReader f=new FileReader("counter.txt");      //substitute path of text file here
            for(int i=0;i<10;i++)
            {
                c[i]=(char)(f.read());
            }
            f.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            return String.valueOf(c);
        }
    }
    
    private long getUid()
    {
        return uid;                                              // whether or not uid is to be returned is a question unanswered left for discussion; thus made private
    }
   public String getName()
   {
       return name;
   }
    public GregorianCalendar getDob()
   {
       return dob;
   }
    public String getVoterId()
   {
       return voter_id;
   }
}

//if this does not work try including a demo class with main to create classfile; note: given class is also public 