# HuffmanCoding
For this project, I have included two versions of the huffman coding algorith.  The first, HuffmanTree.java, simply encodes a given alphabet
using a standard binary Huffman tree.  The second, HuffmanTreeRary.java, prompts the user to enter a radix value for the huffman tree and then
encodes the given alphabet using an n-ary tree with the given radix.  Both also print out the entropy found for the given alphabet as well as the 
average codeword length (ACWL)

The input file must be labeled "ea.txt" and the format is as follows:
Each line contains a symbol of the given alphabet followed by a probability associated with that symbold based on the frequency of the letter
found used in the associated language of the alphabet.  The symbol and its given probability are separated by a commma.  For example, a line 
in the text file for the english alphabet would be: e, 0.127

Meaning that the probability of finding the letter "e" in the english language is rouughly 1 in 8 (I know, that's quite a lot).  
