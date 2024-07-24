/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cabapplication;

/**
 *
 * @author DELL
 */
public class Taxi {
    
    String tid;
    boolean free;
    int freetime;
    int earning;
    char curloc;
    
    Taxi(String tid)
    {
        this.tid=tid;
        freetime=0;
        earning=0;
        curloc='A';
    }
    
    boolean isFree(int pt)
    {
        if(pt>=freetime)
        {
            return true;
        }
        return false;
    }

    
}
