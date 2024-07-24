/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cabapplication;

/**
 *
 * @author DELL
 */
import java.util.*;

public class CabApplication {

    
    static int id=0;
    static int n=6;
    public static void main(String[] args) {
        
        
        Scanner in = new Scanner(System.in);
        List<Taxi> t = new ArrayList<>();
        List<TaxiBooking> tb = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            t.add(new Taxi("T"+(i+1)));
        }
        while(true)
        {
            
            System.out.println("Enter details to book the cab");
            String bid="B"+(++id),cid="C"+(id);
            char pp,dp;
            int pt;
            System.out.print("Pickup Point : ");
            pp=in.next().charAt(0);
            System.out.print("Drop Point : ");
            dp=in.next().charAt(0);
            System.out.print("Pickup time : ");
            pt=in.nextInt();
            String tid="";
            int earn=Integer.MAX_VALUE;
            for(int i=0;i<n;i++)
            {
                if(t.get(i).curloc==pp  && t.get(i).isFree(pt))
                {
                    if(t.get(i).earning<earn)
                    {
                        tid=t.get(i).tid;
                        earn=t.get(i).earning;
                    }
                }
                
            }
            if(tid.length()==0)
            {
                char ppp=pp,npp=pp;
                do
                {
                    npp=(char) (npp+1);
                    ppp=(char) (ppp-1);
                    earn=Integer.MAX_VALUE;
                    for(int i=0;i<n;i++)
                    {
                        if(npp<='F' && t.get(i).curloc==npp  && t.get(i).isFree(pt))
                        {
                            if(t.get(i).earning<earn)
                            {
                                tid=t.get(i).tid;
                                earn=t.get(i).earning;
                            }
                        }
                        if(npp>='A' && t.get(i).curloc==ppp  && t.get(i).isFree(pt))
                        {
                            if(t.get(i).earning<earn)
                            {
                                tid=t.get(i).tid;
                                earn=t.get(i).earning;
                            }
                        }
                    }
                    if(tid.length()!=0)
                    {
                        break;
                    }     
                }while(npp<='F' || ppp>='A');
                if(tid.length()==0)
                {
                    System.out.println("No Taxi At this time!!");
                }
                
            }
            
            if(tid.length()!=0)
            {
                 tb.add(new TaxiBooking(bid,tid,cid,pp,dp,pt,droptime(pp,dp,pt),calculateAmount(pp,dp)));
            
                System.out.println("Taxi "+tid+ " is alloted!!");
                int ind=getTaxi(tid,t);
                t.get(ind).freetime=droptime(pp,dp,pt);
                t.get(ind).earning+=calculateAmount(pp,dp);  
                t.get(ind).curloc=dp;
            }
            
            System.out.println(tb.toString());
            
            System.out.println("Do you want to exit (Y-1/N-0)");
            int exit=in.nextInt();
            if(exit==1)
            {
                System.out.println("Thank you ! Come again!");
                break;
            }
        }
    }
    
    public static int calculateAmount(char pp,char dp)
    {
        int totaldist=Math.abs(dp-pp)*15;
        int amount=100;
        totaldist-=5;
        while(totaldist-->0)
        {
            amount+=10;
        }
        return amount;
    }
    
    public static int droptime(char pp,char dp,int pt)
    {
        return (pt+Math.abs(dp-pp))%24;
    }
    
    public static int getTaxi(String tid,List<Taxi> t)
    {
        for(int i=0;i<n;i++)
        {
            if(tid.equals(t.get(i).tid))
            {
                return i;
            }
        }
        return 0;
    }
    
    
}
