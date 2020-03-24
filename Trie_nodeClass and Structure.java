public class Trie{
    //this node class will hold characters, store the values and indicate the end of word to be used in later methods
    private class Node{
        
        private char value;
        
        private HashMap<Character,Node> children = new HashMap<>();
       
        private boolean endOfWord;

        //initialize the value in the Node object
        Node(char value){
            this.value = value;
            } 
        //this will return an array of nodes showing all children
        public Node[] getChildren(){
            
            return children.values().toArray(new Node[0]);
            }

        public Node getChild(char ch){
            return children.get(ch);
        }     
        }
    
    //Start of the trie. It is empty because tries are empty
    private Node root = new Node(' ');
}
    

   
