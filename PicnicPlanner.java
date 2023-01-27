import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PicnicPlanner
{
    static String prefix = null;

    public static void main(String[] arg)
    {
        
        if (arg.length == 2) //indicates that if there are 2 elements in the array, then 2 arguments are given for Q4
        {
            prefix = arg[1];
        }
        
        List<String> picnic_planner = new ArrayList<String>();
    
        picnic_planner = generate(arg[0].toLowerCase());
        
        for (int i = 0; i<picnic_planner.size(); i++)
        {
            System.out.println(picnic_planner.get(i));
        }
    }
        
    public static List<String> generate(String input)
    {
        List<String> picnic_planner = new ArrayList<String>();
        
        if(prefix != null) //passing in prefix if the user wants a display like q4
        {
            
            PicnicItemStore picnic_item_store = new PicnicItemStore("fruits.txt", Integer.parseInt(prefix));
            CheeseStore cheese_store = new CheeseStore("cheeses.txt", Integer.parseInt(prefix));
            DrinkStore drink_store = new DrinkStore("drinks.txt", Integer.parseInt(prefix));
        
        }
        else
        {
            PicnicItemStore picnic_item_store = new PicnicItemStore("fruits.txt");
            CheeseStore cheese_store = new CheeseStore("cheeses.txt");
            DrinkStore drink_store = new DrinkStore("drinks.txt");
        }
        
        PicnicItemStore picnic_item_store = new PicnicItemStore("fruits.txt"); //instantiations of objects of Fruit, cheese and drinks
        CheeseStore cheese_store = new CheeseStore("cheeses.txt");
        DrinkStore drink_store = new DrinkStore("drinks.txt");
        int fruit_counter = 0;
        int cheese_counter = 0; //counters used to count how many of each item is in the list. Use to create a balanced meal
        
        for(int i = 0;i<input.length();i++) 
        {
            
            if (input.length()>0 & input.length() < 2)//if only 1 item, make it a fruit
            {
                //add_fruit(input, i);
                picnic_planner.add(picnic_item_store.getRandomItem(Character.toString(input.charAt(i))));
                fruit_counter += 1;
                //System.out.println(Character.toString(input.charAt(i)));
            }
            

            else if (input.length()>0 & input.length() < 3 )//if only 2 items, make it a fruit and cheese
            {   
                if (fruit_counter == 1)
                {
                    picnic_planner.add(cheese_store.getRandomItem(Character.toString(input.charAt(i))));
                    //add_cheese(input, i);
                    cheese_counter += 1;
                }
                else
                {
                    //add_fruit(input, i);
                    picnic_planner.add(picnic_item_store.getRandomItem(Character.toString(input.charAt(i))));
                    fruit_counter += 1;
                }
                
            }
            
            else if (input.length()>0 & input.length() < 4 )//if 3 item, make it a fruit, cheese and drink
            {   
                if (fruit_counter == 1 || fruit_counter == 2)
                {
                    picnic_planner.add(cheese_store.getRandomItem(Character.toString(input.charAt(i))));
                    //add_cheese(input, i);
                    cheese_counter += 1;
                }
                else if (fruit_counter == 0)
                {
                    //add_fruit(input, i);
                    picnic_planner.add(picnic_item_store.getRandomItem(Character.toString(input.charAt(i))));
                    fruit_counter += 1;
                }
                
                else if (fruit_counter == 1 & cheese_counter == 1 ||fruit_counter == 2 & cheese_counter == 1 )
                {
                    //add_fruit(input, i);
                    picnic_planner.add(drink_store.getRandomItem(Character.toString(input.charAt(i))));
                    fruit_counter += 1;
                }
                
                
            }
            
            
            
            else if (input.length()>4 ) //for items greater than 4, attempt to split items evenly, however in case of a remainder, add it to cheese
            {
            
                //take input and divide by 3
                //find closest factor of 3
                //the difference will be the extra cheese_counter
                
                
                int num_fruit_and_drink = input.length() / 3;
                
                int num_cheese = num_fruit_and_drink + (input.length() % 3);
                
                
                for (int d = 0; d<num_fruit_and_drink; d++)
                {
                    //add_fruit(input, i);
                    picnic_planner.add(picnic_item_store.getRandomItem(Character.toString(input.charAt(i))));
                    i += 1;
                    
                }
                
                for (int e = 0; e<num_fruit_and_drink; e++)
                {
                    picnic_planner.add(drink_store.getRandomItem(Character.toString(input.charAt(i))));
                    //add_drink(input, i);
                    i += 1;
                    
                }
                
                for (int f = 0; f<num_cheese; f++)
                {
                    picnic_planner.add(cheese_store.getRandomItem(Character.toString(input.charAt(i))));
                    //add_cheese(input, i);
                    i += 1;
                    
                }
                    
                
            }
        }
        return picnic_planner;
    }
    
//     public static void add_cheese(String input, int i)
//     {
//         picnic_planner.add(cheese_store.getRandomItem(Character.toString(input.charAt(i))));
//     }
    
//     public static void add_drink(String input, int i)
//     {
//         picnic_planner.add(drink_store.getRandomItem(Character.toString(input.charAt(i))));
//     }
    
//     public static void add_fruit(String input, int i)
//     {
//         picnic_planner.add(picnic_item_store.getRandomItem(Character.toString(input.charAt(i))));
//                 
//     }
}
