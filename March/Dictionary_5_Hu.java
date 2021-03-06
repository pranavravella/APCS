   //Name:     Date:
   import java.io.*;
   import java.util.*;
   public class Dictionary_5_Hu
   {
      public static void main(String[] args) throws Exception
      {
         try
         {
            System.setOut(new PrintStream(new FileOutputStream("dictionaryOutput.txt")));
         }
            catch(Exception e)
            {
            }
         Map<String, Set<String>> eng2spn = new TreeMap<String, Set<String>>();
         Scanner infile = new Scanner(new File("spanglish.txt"));
         while(infile.hasNext())
         {
            add(eng2spn, infile.next(), infile.next());
         }
         infile.close();
         System.out.println("ENGLISH TO SPANISH");
         display(eng2spn);
      
         Map<String, Set<String>> spn2eng = reverse(eng2spn);
         System.out.println();
         System.out.println("SPANISH TO ENGLISH");
         display(spn2eng);
      }
      public static void display(Map<String, Set<String>> m)
      {
         if(m != null)
         {
            Iterator<String> it = m.keySet().iterator();
            while(it.hasNext())
            {
               String temp = it.next();
               System.out.print(temp);
               System.out.print(" " + m.get(temp));
               System.out.println(); 
            }
         }
         else
         {}
      }
      public static void add(Map<String, Set<String>> dictionary, String word, String translation)
      {
         if(dictionary.isEmpty())
         {
            Set<String> set = new TreeSet<String>();
            set.add(translation);
            dictionary.put(word, set);
         }
         else if(!dictionary.containsKey(word))
         {
            Set<String> set = new TreeSet<String>();
            set.add(translation);
            dictionary.put(word, set);
         }
         else
         {
            Set<String> temp = dictionary.get(word);
            temp.add(translation);
         }
      }
      public static Map<String, Set<String>> reverse(Map<String, Set<String>> dictionary)
      {
         Map<String,Set<String>> map = new TreeMap<String, Set<String>>();
         for(String s: dictionary.keySet())
         {
            Set<String> arg = dictionary.get(s);
            for(String str: arg)
            {
               add(map, str, s);
            }
         }
         return map;
      }
   }