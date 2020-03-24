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
    
    
