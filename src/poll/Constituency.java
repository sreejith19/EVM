//constituency class
//require a function to edit file entry for a specific constituency
//party_ticket&voter needs to be adjusted so that only valid constituencies are accepted as results

package poll;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

class Constituency
{
    //private static int no_of_constituency=0;
    private int id;
    private String name;
    private long population;
    
    public Constituency()
    {
        this("",0);
    }
    public Constituency(String name)
    {
        this(name,0);
    }
    public Constituency(String name , long population)
    {
        this.name=name;
        setID();
        this.population=population;
        writeToFile();
    }

    public void setID()
    {
        try{
            File f=new File("/home/user/Desktop/EVM-master/src/poll/id.txt");
            BufferedReader br=new BufferedReader(new FileReader(f));
            id=Integer.parseInt(br.readLine());
            //System.out.println(id);
            br.close();
            FileWriter fw=new FileWriter(f);
            fw.write(""+(id+1));
            fw.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    public void writeToFile()
    {
        try{
            File f=new File("/home/user/Desktop/EVM-master/src/poll/constituency.txt");
            FileWriter fw=new FileWriter(f,true);
            String str=id+" "+name+" "+population+"\n";
            fw.write(str);
            fw.close();
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String con;
        long pop;
        System.out.println("get the constituency name");
        con = sc.next();
        System.out.println("get the current population");
        pop = sc.nextLong();
new Constituency(con,pop);
    }
    public String getName()
    {
        return name;
    }
    public int getID()
    {
        return id;
    }
    public long getPopulation()
    {
        return population;
    }
}