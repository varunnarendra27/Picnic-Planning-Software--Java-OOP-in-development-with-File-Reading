import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CheeseStore extends PicnicItemStore
{
    //HashMap<String, List<String>> map = new HashMap<String, List<String>>();
    public CheeseStore()
    {
        this.map = new HashMap<String, List<String>>();
    }
    
    public CheeseStore(String fileName, int prefix)
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
    
    public CheeseStore(String fileName)
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
            return rand_element.substring(0, 1).toUpperCase() + rand_element.substring(1) + "(cheese)"; //same as PicnicItemStore but overriden to add the (cheese) identification to indicate that the list item is a cheese
        }
        else
        {
            return null;
        }
        
    
    
    
    
        
    }
}
