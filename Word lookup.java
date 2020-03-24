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

   

