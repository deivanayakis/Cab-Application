/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cabapplication;

/**
 *
 * @author DELL
 */
public class TaxiBooking {
    
    String bid;
    String tid;
    String cid;
    char pickup;
    char drop;
    int pt;
    int dt;
    int price;
    
    TaxiBooking(String bid, String tid,String cid,char pickup,char drop,int pt,int dt,int price)
    {
        this.bid=bid;
        this.tid=tid;
        this.cid=cid;
        this.pickup=pickup;
        this.drop=drop;
        this.pt=pt;
        this.dt=dt;
        this.price=price;
        
    }
    
    @Override
    public String toString()
    {
        return bid+" | "+cid+" | "+tid+" | "+pickup+" | "+drop+" | "+pt+" | "+dt+" | "+price+" | ";
    }
    
}
