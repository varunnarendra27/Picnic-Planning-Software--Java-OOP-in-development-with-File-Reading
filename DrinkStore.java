import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DrinkStore extends PicnicItemStore
{
    //HashMap<String, List<String>> map = new HashMap<String, List<String>>();
    public DrinkStore()
    {
        this.map = new HashMap<String, List<String>>();
    }
    
    public DrinkStore(String fileName, int prefix)
    {
        this.map = new HashMap<String, List<String>>();
        
        BufferedReader objReader = null;
        try {
        String strCurrentLine;

        objReader = new BufferedReader(new FileReader(fileName));

        while ((strCurrentLine = objReader.readLine()) != null) {

            for (int i = 0; i<prefix; i++)
            {
                put(strCurrentLine.substring(0,i).toLowerCase(), strCurrentLine);
            }
        }

        } catch (IOException e) {}
        
    }
    
    public DrinkStore(String fileName)
    {
        this.map = new HashMap<String, List<String>>();
        
        BufferedReader objReader = null;
        try {
        String strCurrentLine;

        objReader = new BufferedReader(new FileReader(fileName));

        while ((strCurrentLine = objReader.readLine()) != null) {

            //System.out.println(strCurrentLine);
            put(Character.toString(strCurrentLine.charAt(0)).toLowerCase(), strCurrentLine);
        }

        } catch (IOException e) {}
        
    }
    
    public String getRandomItem(String key)
        {
        
            if(this.map.containsKey(key)==true)
            {
                List<String>holder = new ArrayList<String>();
                Random rand = new Random();
                holder = map.get(key);
                int index = rand.nextInt(holder.size());
                String rand_element = holder.get(index);
                
                
                String[] split_array = rand_element.split(" ");
                int split_array_size = 0;
                
                
                //array is split based on spaces
                int alcohol_content =Integer.parseInt(split_array[split_array.length -1]); //last element in array created from split() will hold alcohol content
                if (alcohol_content > 11) //if statement used to add the correct identification based on alcohol content
                {
                    
                    return rand_element.substring(0, 1).toUpperCase() + rand_element.substring(1) + "(strong wine)";
                }
                else if (alcohol_content < 11 & alcohol_content > 0)
                {
                    return rand_element.substring(0, 1).toUpperCase() + rand_element.substring(1) + "(wine)";
                }
                else
                {
                    return rand_element.substring(0, 1).toUpperCase() + rand_element.substring(1) + "(soft drink)" ; 
                }
            }
            
            else
            {
                return null;
            }
            
            
            
            
        
        
        
            
        }
}
