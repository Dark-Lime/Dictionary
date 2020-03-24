public class TxtFile{
    
    private String name;
    //this decides whether the file starts over when it is opened so in a real program it would be true so it doesn't restart each time
    private boolean append_to_file = false;

    TxtFile(String fileName){
        name = fileName;
        }
    TxtFile(String fileName, boolean appendValue){
        name = fileName;
        append_to_file = appendValue;
    }
    //here /I created a few text object for the use to write text inside
    public void writeToFile(String textLine) throws IOException{
       FileWriter write = new FileWriter(name, append_to_file);

       PrintWriter printLine = new PrintWriter(write); 
       //The %s between double quotes means a string of characters of any length. The %n means a newline
       printLine.printf("%s"+"%n", textLine); 
       
       printLine.close();
        }
}
