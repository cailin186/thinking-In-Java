package map;

import java.util.*;

/**
 * This program demonstrates the use of a map with key type String and value type Employee.
 * @version 1.12 2015-06-21
 * @author Cay Horstmann
 */
public class MapTest
{
   public static void main(String[] args)
   {
      Map<String,String> staff = new HashMap<>();
      staff.put("cailin","helllo");
      staff.forEach((k, v) -> 
         System.out.println("key=" + k + ", value=" + v));
   }
}