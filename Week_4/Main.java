class File
{
    private String name;
    private String info;


    public File(String name, String info)
    {
        this.name=name;
        this.info=info;
    }
    public String getContent1()
    {
        return this.name+ " " + this.info + " " + "\n";
    }
    @Override
    public boolean equals(Object o)
    {
        if(o instanceof File)
        {
            File other=(File) o;
            return this.name.equals(other.name);
        }
        return false;
    }
}
class Folder
{
    private File[] files= new File[0];
    private int no_of_files=0;

    public void addFile(File item)
    {
        for(int i=0;i<no_of_files;i++)
        {
            if(files[i].equals(item))
            {
                System.out.println("Item already exists");
                return;
            }
        }
        File[] temp=new File[no_of_files+1];
        System.arraycopy(files,0,temp,0,no_of_files);
        temp[no_of_files]=item;
        files=temp;
        no_of_files++;

    }
    public String getContent()
    {
        String content= "";
        for(File f:files)
        {
            if(f!=null)
                content+=f.getContent1();

        }
        return content;
    }

    public void remove2(File fileToRemove) {
        int deleteIndex = -1;
    
        // Find the index of the file to remove
        for (int i = 0; i < no_of_files; i++) {
            if (files[i].equals(fileToRemove)) {
                deleteIndex = i;
                break;
            }
        }
    
        // If file is found, shift elements to remove it from the array
        if (deleteIndex != -1) {
            for (int i = deleteIndex; i < no_of_files - 1; i++) {
                files[i] = files[i + 1];
            }
            // Set the last element to null after shifting
            files[no_of_files - 1] = null;
        } else {
            System.out.println("Searched file does not exist in the folder");
        }
    }
    public boolean containsFile(File searchFile)
    {
        for(File f: files)
        {
            if(f == null)
                return false;
            if(f.equals(searchFile))
                return true;
        }
        return false;

    }

}


public class Main {
    public static void main(String[] args) {
        File file1 = new File("File1", "This is the content of File 1.");
        File file2 = new File("File2", "This is the content of File 2.");
        File file3 = new File("File3", "This is the content of File 3.");
        File file4 = new File("File4", "This is the content of File 4.");

        Folder folder = new Folder();

        folder.addFile(file1);
        folder.addFile(file2);
        folder.addFile(file3);
        folder.addFile(file1); // Attempt to add a duplicate
        folder.addFile(file4);

        System.out.println("Folder content:\n" + folder.getContent());

        folder.remove2(file4);
        System.out.println("Folder content after removing File2:\n" + folder.getContent());

        System.out.println("Contains File1: " + folder.containsFile(file1));
        System.out.println("Contains File2: " + folder.containsFile(file2));
    }
}