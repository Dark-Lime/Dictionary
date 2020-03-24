public class ReadFile{

    private String name;

    ReadFile(String fileName){
        name = fileName;
    }
    //this method opens a text file and extracts all the text inside
    public String[] OpenFile() throws IOException{
        FileReader filereader = new FileReader(name);
        BufferedReader textReader = new BufferedReader(filereader);
        int numberOfLines = linesInText(name);
        String[] textData = new String[numberOfLines];

        for (int i = 0; i < numberOfLines; i++){
            textData[i] = textReader.readLine();
        }
        textReader.close();
        return textData;
    }
    //gets the text from a number of lines in a text file
    private int linesInText(String name) throws IOException{
        FileReader filereader = new FileReader(name);
        BufferedReader textReader = new BufferedReader(filereader);
        String textLine;
        int numberOfLines = 0;
        
        //this method reads text from a character-input stream from a separate library. It does buffering for reading characters, arrays, and lines.
        while ((textLine = textReader.readLine()) != null){
            numberOfLines++;
            }
        
        textReader.close();
        return numberOfLines;
    }
}
