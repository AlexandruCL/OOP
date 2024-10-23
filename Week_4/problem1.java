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
}
class FolderClient {
    public static void main(String[] args) {
        Folder folder = new Folder();
        folder.addFile(new File("Hello, ", "file1"));
        folder.addFile(new File("World!", "file2"));
        System.out.println(folder.getContent());
    }
}