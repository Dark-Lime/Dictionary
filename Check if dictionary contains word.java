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
