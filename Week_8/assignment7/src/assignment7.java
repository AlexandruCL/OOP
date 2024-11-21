public class assignment7 {
    public static void main(String[] args) {
        // Create some files
        File file1 = new File("File1 content");
        File file2 = new File("File2 content");
        File file3 = new File("File3 content");

        // Create folders
        Folder folder1 = new Folder();
        Folder folder2 = new Folder();
        Folder folder3 = new Folder();

        folder1.addItem(file1);
        folder1.addItem(file2);

        folder2.addItem(folder1);
        folder2.addItem(file3);

        folder2.addItem(file1);
        folder2.addItem(file2);

        folder3.addItem(folder1);
        folder3.addItem(file3);
        folder3.addItem(file2);
        folder3.addItem(folder2);

        System.out.println("Folder 1 Content:\n" + folder1.getContent() + "\n");
        System.out.println("Folder 2 Content:\n" + folder2.getContent() + "\n");
        System.out.println("Folder 3 Content:\n" + folder3.getContent() + "\n");
    }
}


interface Item{
    String getContent();
}

class File implements Item{
    private String information;

    public File(String information){

        this.information = information;
    }

    @Override
    public String getContent(){

        return this.information;
    }

}

class Folder implements Item{
    private Item[] entries;
    private int nrofEntries;

    public Folder(){
        this.entries = new Item[0];
        this.nrofEntries = 0;
    }

    void addItem(Item item){
        Item[] temp = new Item[nrofEntries + 1];
        System.arraycopy(entries, 0, temp, 0, nrofEntries);
        temp[nrofEntries] = item;
        this.entries = temp;
        nrofEntries++;
    }

    @Override
    public String getContent(){
        String content = "";

        for(Item item : entries){
            if(item instanceof Folder){
                content += "[ ";
                content += item.getContent();
                content += " ]";
            }
            else if(item instanceof File){
                content += item.getContent();
            }
            content += " ";
        }
        return content;
    }
}

