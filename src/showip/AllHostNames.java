/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package showip;

/**
 *
 * @author Admin
 */
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;
 
/**
 * @author Crunchify.com
 */
 
public class AllHostNames {
 
    public void getAllHostNames(List list) {
 
        InetAddress ip;
        String hostname ;
        String myIp = "" ;
        Iterator iterator  ;
                       
        
             iterator= list.iterator();   
            
       
                System.out.println("Resolving Host name on network \nYou will be advised when all host names are resolved \n") ;
              
                        while(iterator.hasNext())
                            
                        {
                            
                         
                          myIp = (String)iterator.next() ;
                            
                         try { 
                    
                    
                               ip = InetAddress.getByName(myIp.trim());                            
                               hostname =ip.getHostName() ;
                                System.out.println("IP address : " + myIp +
                                        "\t"+"Current Hostname : " + hostname
                                );
                                
                                } catch (UnknownHostException e) {

                                       e.printStackTrace();
                                }
                        
                    } // end while
                
               System.out.println("\n All possible hostnames  for Ip's listed resolved") ;
                        
    } // end function
    
}

