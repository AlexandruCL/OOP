class File{
    private String information;
    private String name;
    public File(String information, String name){
        this.information = information;
        this.name = name;
    }
    public String getConet(){
        return information;
    }
    @Override
    public boolean equals(Object o){
        if(o instanceof File){
            File other = (File) o;
            return this.name.equals( other.name);
        }
        return false;
    }
}

class Folder{
    private File[] entries = new File[0];
    private int nrOfEntries = 0;    

    public void addFile(File item){
        for(int i=0; i<nrOfEntries;i++){
            if(entries[i].equals(item)){
                System.out.println("Item already exists");
                return;
            }
        }
        File[] tempEntries = new File[nrOfEntries + 1];
        System.arraycopy(entries, 0, tempEntries, 0, nrOfEntries);
        tempEntries[nrOfEntries] = item;
        entries = tempEntries;
        nrOfEntries++;
    }
    public String getContent(){
        String content="";
        for(File f : entries)
            content += f.getConet() + "\n";
        return content.trim();
    }
    public static void main(String [] args){
        File f1 = new File("I am the file number 1", "File");
        File f2 = new File("This is file number 2", "File 2");
        File f3 = new File("this is fwquifbnviwuenrf 3", "File 3");

        Folder folder = new Folder();
        folder.addFile(f1);
        folder.addFile(f2);
        folder.addFile(f3);
        
        String allContentString = folder.getContent();
        System.out.println(allContentString);

    }
}