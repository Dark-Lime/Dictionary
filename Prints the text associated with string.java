 public void wordText(String string) throws IOException{

        ReadFile rf = new ReadFile(string);
        String[] aryLines = rf.OpenFile();
        for (String strings: aryLines) {
            System.out.println(strings);
        }
    }
