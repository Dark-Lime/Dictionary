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
    

    //the method to add to the trie tree using a for in loop to iterate over the string and add each character into a node object
    public void add(String string) throws IOException{
        
        var current = root;
    
        for (var ch : string.toCharArray()){
            if (current.getChild(ch) == null)
                //if the child is null add a new Node entry into the hash
                current.children.put(ch, new Node(ch));
            //move the current object down the trie for each ch
            current = current.getChild(ch);
            } 
        
        current.endOfWord = true;
        
        //Then it will create text document and labeled after the string that the user can input any text
        TxtFile txt = new TxtFile(string, false);
        Scanner str = new Scanner(System.in);
        str.close();
        System.out.println("What would you like to write for the word " + string + "?"); 
        txt.writeToFile(str.nextLine());
        }
        //using a for in loop I use the contains key to check for characters and if the there are no false and final character is the endOfWord then it is true
    public boolean contains(String string){
        
        if (string == null)
            return false;
        
        var current = root;        
        
        for (var ch : string.toCharArray()){
            
            if (!current.children.containsKey(ch))
                return false;
           
            current = current.getChild(ch);
            }
        //if the loop completes and the final hashmap has an endOfWord this will determine whether true or not
        return current.endOfWord;
            
        }

    //Here I am overloading the remove method to recursively traverse the trie all the way down to the last child
    public void remove(String string){
        if (string == null)
            return;
        //it starts at the root so the index is 0
        remove(root, string, 0);
    }
    //this is the remove method that will do all the heavy lifting
    private void remove(Node root, String string, int index){
        //this ends the recursion once we get to the last character
        if (index == string.length()){
            root.endOfWord = false;
            return;
        }
        var ch = string.charAt(index);
        
        var child = root.getChild(ch);
       
        if (child == null)
            return;
        //recursively call the remove method to remove each character down the trie and move down the trie by incrementing the index
        remove(child, string, index ++);

        //check to see if the child has any children and it is not the end of another word
        if (child.getChildren().length == 0 && !child.endOfWord)
           
            root.children.remove(ch);
    }
    
    //using recursion to display all the possible words from a string input that match the strings in the trie
    public List<String> findWords(String prefix){
        
        List<String> strings = new ArrayList<>();
        
        var lastNodes = lastNode(prefix);
        
        //use last node to get to the end of the words if it is in the trie then start the recursion from the index of that last node
        findWords(lastNodes, prefix, strings);
        
        return strings;
    }
    //traverse the trie to the end from the prefix
    private void findWords(Node root, String prefix, List<String> strings){
        if (root == null)
            return;

        if (root.endOfWord)
        strings.add(prefix);
        //for each node through recursion I continually add the next node character to the previous prefix making the new added prefix the current one once it is the end of the word add it the list
        for (var child : root.getChildren())
            findWords(child, prefix + child.value, strings);
    }
    //this method goes to the end of the trie iterating and making current = its child node
    private Node lastNode (String prefix){
        
        if (prefix == null)
            return null;
        
            var current = root;
        
            for (var ch : prefix.toCharArray()) {
                var child = current.getChild(ch);
            
                if (child == null)
                    return null;
            
                current = child;
            }
        //this will be the starting point for find words the match the prefix of the findwords method
        return current;
    }

    public void wordText(String string) throws IOException{

        ReadFile rf = new ReadFile(string);
        String[] aryLines = rf.OpenFile();
        for (String strings: aryLines) {
            System.out.println(strings);
        }
    }
}   
