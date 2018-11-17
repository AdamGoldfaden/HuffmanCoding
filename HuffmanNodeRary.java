import java.util.ArrayList;
import java.util.Comparator;

public class HuffmanNodeRary
{
   String   symbol;
   double   probability;
   int      radix;
   String   code;
   ArrayList<HuffmanNodeRary> subnodes = new ArrayList<HuffmanNodeRary>();

   public HuffmanNodeRary(String s, double p, ArrayList<HuffmanNodeRary> subns)
   {
      symbol = s;
      probability = p;
      subnodes = subns;
      code = "";
   }
   
   public static Comparator<HuffmanNodeRary> HuffSymComparator = new Comparator<HuffmanNodeRary>()
       {
         public int compare(HuffmanNodeRary h1, HuffmanNodeRary h2)
         {
	         String HuffSym1 = h1.symbol;
	         String HuffSym2 = h2.symbol;

	         return HuffSym1.compareTo(HuffSym2);
         }
       };
       
       public static Comparator<HuffmanNodeRary> HuffPComparator = new Comparator<HuffmanNodeRary>()
       {
         public int compare(HuffmanNodeRary h1, HuffmanNodeRary h2)
         {
            double p1 = h1.probability;
            double p2 = h2.probability;
            
            return (int)(10000*p1 - 10000*p2);
         }
       };


 
}
