   import java.util.Comparator;
   public class HuffmanNode
   {
      String symbol;
		double probability;
      String code;
      HuffmanNode left;
      HuffmanNode right;
   
      HuffmanNode(String s, double p, HuffmanNode lt,  HuffmanNode rt)
      {
         symbol = s;
         probability = p;
         left = lt;
         right = rt; 
         code = "";
      }
      
       public static Comparator<HuffmanNode> HuffSymComparator = new Comparator<HuffmanNode>()
       {
         public int compare(HuffmanNode h1, HuffmanNode h2)
         {
	         String HuffSym1 = h1.symbol;
	         String HuffSym2 = h2.symbol;

	         return HuffSym1.compareTo(HuffSym2);
            }
       };
       
       public static Comparator<HuffmanNode> HuffPComparator = new Comparator<HuffmanNode>()
       {
         public int compare(HuffmanNode h1, HuffmanNode h2)
         {
            double p1 = h1.probability;
            double p2 = h2.probability;
            
            return (int)(10000*p1 - 10000*p2);
         }
       };
   
            
      /*@Override
      
      public int compareTo(HuffmanNode node)
      {
         return (int)(10000*this.probability - 10000*node.probability);
      }*/
}
