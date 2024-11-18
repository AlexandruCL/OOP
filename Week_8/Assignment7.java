interface Item{
    public String getContent();
}

class File implements Item{
    private String information;

    public File (String information){
        this.information = information;
    }

    @Override
    public String getContent(){
        return this.information;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof File){
            File other = (File) o;
            return other.getContent().equals(this.getContent());
        }
        return false;
    }
}

class Folder implements Item{
    private Item[] entries;
    private int numberOfEntries;

    public Folder(){
        entries = new Item[0];
        numberOfEntries = 0;
    }

    void addItem(Item item){
        if(item instanceof File){
            for(Item i : entries){
                if(i instanceof File && i.equals(item)){
                    System.out.println("Item is already stored");
                    return;
                }
            }
        }
        if(item instanceof Folder){
            for(Item i : entries){
                if(i instanceof Folder && i.equals(item)){
                    System.out.println("Item is already stored");
                    return;
                }
            }
        }
        Item[] temp = new Item[numberOfEntries + 1];
        System.arraycopy(entries, 0, temp, 0, numberOfEntries);
        temp[numberOfEntries] = item;
        entries = temp;
        numberOfEntries++;
    }

    @Override
    public String getContent(){
        String content="";

        for(Item i:entries){


            //Content of the folders contained by the current folder will be enclosed in square brackets
            if(i instanceof Folder){
                content +="[ ";
                content += i.getContent();
                content +="]";
            }
            else{
                content += i.getContent();
            }
            content += " ";
        }
        return content;
    }
    @Override
    public boolean equals(Object o){
        if(o instanceof Folder){
            Folder other = (Folder) o;
            return other.getContent().equals(this.getContent());
        }
        return false;
    }
}
public class Assignment7 {
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

        // folder2.addItem(folder1);
        // folder2.addItem(file3);

        //if folder 2 has this content, it should not be added to folder 3
        folder2.addItem(file1);
        folder2.addItem(file2); 

        folder3.addItem(folder1);
        folder3.addItem(file3);
        folder3.addItem(file2);
        folder3.addItem(folder2); //should print item is already stored

        System.out.println("Folder 1 Content:\n" + folder1.getContent() + "\n");
        System.out.println("Folder 2 Content:\n" + folder2.getContent() + "\n");
        System.out.println("Folder 3 Content:\n" + folder3.getContent() + "\n");
    }
}
