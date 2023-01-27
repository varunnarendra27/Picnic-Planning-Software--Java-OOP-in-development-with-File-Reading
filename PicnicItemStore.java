import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class PicnicItemStore
{  
    HashMap<String, List<String>> map = new HashMap<String, List<String>>(); 
    int prefix;
    public PicnicItemStore()
    {
        this.map = new HashMap<String, List<String>>();
    }
    
    public PicnicItemStore(String fileName)
    {
        this.map = new HashMap<String, List<String>>(); //instatiating a hashmap to hold the key and values
        
        BufferedReader objReader = null;
        try 
        {
            String strCurrentLine;

            objReader = new BufferedReader(new FileReader(fileName)); //accessing text file of fruits and loading them into a variable
            
            while ((strCurrentLine = objReader.readLine()) != null) {

                //System.out.println(strCurrentLine);
                put(Character.toString(strCurrentLine.charAt(0)).toLowerCase(), strCurrentLine); //getting the first letter of variable and using it as a key for the whole variable
            
            
        }

        }
        catch (IOException e) {}
        
    }
    
    public PicnicItemStore(String fileName, int prefix) //different constructor used for Q4 (not completed)
    {
        this.map = new HashMap<String, List<String>>();
        this.prefix = prefix;
        BufferedReader objReader = null;
        try {
        String strCurrentLine;

        objReader = new BufferedReader(new FileReader(fileName));
        
        while ((strCurrentLine = objReader.readLine()) != null) {

            //attempting to use a nested for loop; loops through every element in variable holding value from txt file
            for (int i = 0; i<strCurrentLine.length(); i++)
            {
                
                if ((strCurrentLine.length()-1) - i < 2)//only allowing to add keys of prefix. prevents out of bounds error where the program searches for a prefix up to 3 letters on the last element of the word
                {
                    
                    
                    for (int d = i; d<prefix; d++)// attempting to add keys of the length of the prefix given based on the current index of the input
                    {
                        
                        put(strCurrentLine.substring(i,d).toLowerCase(), strCurrentLine);
                        System.out.println(strCurrentLine.substring(i,d).toLowerCase());
                        
                    }
                }
                else //in the of an out of bounds, it should just add the last letters
                {
                    
                    put(Character.toString(strCurrentLine.charAt(i)).toLowerCase(), strCurrentLine);
                }
            }
            
        }

        } catch (IOException e) {}
        
        
    }
    
    
    public boolean containsKey(String key) //checks whether the map contains a given string as a key;
    {
        return this.map.containsKey(key);
    }
    
    public void put(String key, String item) //looks up key in the map and returns a random picnic item (using the Random class) from the list of strings that key is mapped to. 
    {
        List<String>holder = new ArrayList<String>(); 
        
        if(this.map.containsKey(key)==true)
        {
            holder = this.map.get(key);
            holder.add(item);
            this.map.replace(key, holder);//holder is a variable that will hold the list of values from getting the containsKey
            //.replace() is used to update the holder to hold more values in the list without deleting previous values
        }
        else
        {
            holder.add(item); //if list does not have an item in the first place, it is added
            this.map.put(key,holder);
        }
    }
    public String getRandomItem(String key)
    {
        if(this.map.containsKey(key))
        {
            List<String>holder = new ArrayList<String>();
            Random rand = new Random(); //jave.util to get a random number
            holder = map.get(key);
            int index = rand.nextInt(holder.size()); //creating a variable that holds a random number thats within the size of the list
            String rand_element = holder.get(index); //holds the element in the index of the random number in the list
            return rand_element.substring(0, 1).toUpperCase() + rand_element.substring(1); 
        }
        else
        {
            return null;
        }        
    }
}

