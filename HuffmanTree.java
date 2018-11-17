import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Collections;

public class HuffmanTree 
{
   static double entropy = 0.0;
   static double acwl = 0.0;
   static ArrayList<HuffmanNode> hnodes = new ArrayList<HuffmanNode>();
   
   public static void main(String[]args) throws FileNotFoundException
   {
      ArrayList<HuffmanNode> tree = new ArrayList<HuffmanNode>();
      
      File inputFile = new File("ea.txt");     
      Scanner inFile = new Scanner(inputFile);  
      inFile.useDelimiter("[^A-za-z0-9 ']+"); 
      
      while (inFile.hasNextLine())
      {
         String nextLine = inFile.nextLine();
         Scanner SandPScanner = new Scanner(nextLine);
         SandPScanner.useDelimiter(",");
         String c = SandPScanner.next();
         String pString = SandPScanner.next();
         double p = Double.parseDouble(pString);
         HuffmanNode hn = new HuffmanNode(c, p, null, null);
         tree.add(hn);
         entropy -= p*Math.log(p) / Math.log(2.0);
         SandPScanner.close();
      }
      inFile.close();
      
      while(tree.size() > 1)
      {
         Collections.sort(tree,HuffmanNode.HuffPComparator);
         HuffmanNode hn1 = tree.get(0);
         tree.remove(hn1);
         HuffmanNode hn2 = tree.get(0);
         tree.remove(hn2);
         HuffmanNode node = new HuffmanNode("blank",hn1.probability + hn2.probability,hn1,hn2);
         tree.add(node);
         /*for(HuffmanNode n : tree)
            System.out.println(n.symbol + ", " + n.probability);
         System.out.println("-------------------");*/
      }
      
      encode(tree.get(0));
      displayTree(tree.get(0));
      for(HuffmanNode hn : hnodes)
         System.out.println(hn.symbol + ", " + hn.code);
      System.out.println();
      System.out.println("Entropy: " + entropy + ", " + "ACWL: " + acwl);
       
   }
   
   public static void encode(HuffmanNode root)
   {
      if(root.left != null && root.right != null)
      {
         root.left.code += (root.code + "0");
         root.right.code += (root.code + "1");
         encode(root.left);
         encode(root.right);
      }
   }
   
   public static void displayTree(HuffmanNode root)
   {
      if(root != null)
      {
         displayTree(root.left);
         if(root.left == null && root.right == null){
            acwl += (root.probability * root.code.length());
            hnodes.add(root);
         }
         displayTree(root.right);
      }
      Collections.sort(hnodes,HuffmanNode.HuffSymComparator);
   }
}