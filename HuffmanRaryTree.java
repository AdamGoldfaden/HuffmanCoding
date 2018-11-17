import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Collections;

public class HuffmanRaryTree 
{
   static double entropy = 0.0;
   static double acwl = 0.0;
   static int radix = 0;
   static ArrayList<HuffmanNodeRary> hnodes = new ArrayList<HuffmanNodeRary>();
   static int n = 0;
   
   public static void main(String[]args) throws FileNotFoundException
   {
      ArrayList<HuffmanNodeRary> tree = new ArrayList<HuffmanNodeRary>();
      
      File inputFile = new File("ea.txt");     
      Scanner inFile = new Scanner(inputFile);  
      inFile.useDelimiter("[^A-za-z0-9 ']+"); 
      
      Scanner k = new Scanner(System.in);
      System.out.println("Enter a radix:");
      radix = k.nextInt();
      k.close();
      
      while (inFile.hasNextLine())
      {
         String nextLine = inFile.nextLine();
         Scanner SandPScanner = new Scanner(nextLine);
         SandPScanner.useDelimiter(",");
         String c = SandPScanner.next();
         String pString = SandPScanner.next();
         double p = Double.parseDouble(pString);
         ArrayList<HuffmanNodeRary> empty = new ArrayList<HuffmanNodeRary>();
         HuffmanNodeRary hn = new HuffmanNodeRary(c, p, empty);
         tree.add(hn);
         entropy -= p*Math.log(p) / Math.log(2.0);
         SandPScanner.close();
         n++;
      }
      inFile.close();
     
      boolean first = true;
      while(tree.size() > 1)
      {
         Collections.sort(tree,HuffmanNodeRary.HuffPComparator);
         if(first)
         {
            HuffmanNodeRary newnode = new HuffmanNodeRary("blank",0,new ArrayList<HuffmanNodeRary>());
            double prob = 0;            
            for(int i = 0; i <(n-2)%(radix-1)+2;i++)
            {
               HuffmanNodeRary hn = tree.get(0);
               tree.remove(hn);
               newnode.subnodes.add(hn);
               prob += hn.probability;
            }
            newnode.probability = prob;
            tree.add(newnode);
            first = false;
         }
         
         else
         {
            double prob = 0;
            HuffmanNodeRary newnode = new HuffmanNodeRary("blank",0,new ArrayList<HuffmanNodeRary>());
            for(int i = 0; i < radix; i++)
            {
               HuffmanNodeRary hn = tree.get(0);
               tree.remove(hn);
               newnode.subnodes.add(hn);
               prob += hn.probability;
            }
            
            newnode.probability = prob;
            tree.add(newnode);
         }
         /*for(HuffmanNodeRary n : tree)
            System.out.println(n.symbol + ", " + n.probability);
         System.out.println("-------------------");*/
      }
      
      encode(tree.get(0));
      displayTree(tree.get(0));
      for(HuffmanNodeRary hn : hnodes)
         System.out.println(hn.symbol + ", " + hn.code);
      System.out.println();
      System.out.println("Entropy: " + entropy + ", " + "ACWL: " + acwl);
       
   }
   
   public static void encode(HuffmanNodeRary root)
   {
      if(!root.subnodes.isEmpty())
      {
         for(int i = 0; i < root.subnodes.size(); i++) {
            root.subnodes.get(i).code += (root.code + Integer.toString(i));
            encode(root.subnodes.get(i));
         }
      }
   }
   
   public static void displayTree(HuffmanNodeRary root)
   {
      
         if(root.subnodes.isEmpty()) {
            acwl += (root.probability * root.code.length());
            hnodes.add(root);
         }
         for(int i = 0; i < root.subnodes.size(); i++)
            displayTree(root.subnodes.get(i));
      
      Collections.sort(hnodes,HuffmanNodeRary.HuffSymComparator);
   }
}