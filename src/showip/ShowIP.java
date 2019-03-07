package showip;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
     
    public class ShowIP
    {
    	
       
        public ShowIP() throws IOException
        {
             
            System.out.println("Constructor called \n MD Harrington");
            
        }
        
        public void getExternalIpAddress() throws MalformedURLException, IOException 
        {
            URL whatismyip = null;
            BufferedReader in = null;
            String ip = null; 
            
                whatismyip = new URL("http://checkip.amazonaws.com");
                in = new BufferedReader(new InputStreamReader(
                whatismyip.openStream()));
                ip = in.readLine();      
           
           
            
            System.out.println("External Ip is : " + ip + "\n");
        }
                
        
        public static void main(String []args)throws Exception	
    	{
            
                        ShowIP myNetwork = new ShowIP();
                        myNetwork.getExternalIpAddress();
            
                                        
                        
                        
                        
                        
                        // Create operating system process useing arp command 
    			ProcessBuilder pb = new ProcessBuilder("arp","-a");  
                        List listSource = new ArrayList();
    			pb.redirectErrorStream();
    			// Starts a new process using the attributes of this process builder                            
    			Process p = pb.start();				
    				 
    			BufferedReader br = new BufferedReader (new InputStreamReader(p.getInputStream()));
     
    			// String out is used to store output of this command(process)
    			String out="";                                              		    	     
                       
    			while(true)
    			{
    				String l=null;
    				try 
    				{
    					l = br.readLine();
                                       
                                        
    				} 
    				catch (IOException ex) {}
    				if(l==null)
    					break;
    				out+=l + '\n' ;
    			}
     
    			// A compiled representation of a regular expression
                        String matcherpattern = ".*\\b\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\b" ;
    			Pattern pattern = Pattern.compile(matcherpattern); 
     
    			/* An engine that performs match operations on a character sequence by interpreting a Pattern */
    			Matcher match = pattern.matcher(out);			
     
    			out="";
    			String prev="",pLoc;
     
    			if(!(match.find()))        // In case no IP address Found in out
    				out="No IP found!";
     
    			else
    			{
     
    				/* Returns the input subsequence matched by the previous match in this case IP of our interface */
    				pLoc = match.group();  
                        
    				out+=pLoc+"\nOther Hosts'(In Same Network) IP addresses:\n";
    				while(match.find())	 
    				{
    					pLoc = match.group();	// Returns the IP of other hosts
    					out+=pLoc+"\n";
                                        listSource.add(pLoc);
                                        
    				}
    				try 
    				{
    					br.close();
    				} 
    				catch (IOException ex) {}
    			}
     
    			// Printing IP Addresses of all computers in our network
    			System.out.println(out);
                        // call Get Hostnames 
                        AllHostNames hostnames = new AllHostNames() ;
                        
                        // now get all the hostnames 
                        if(!listSource.isEmpty()){
                        hostnames.getAllHostNames(listSource);
                        }
                        
                        
                        
        }
    
}
