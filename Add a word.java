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
    
