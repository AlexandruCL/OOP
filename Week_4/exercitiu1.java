class File{
    private String data;
    private String name;
    public File(String data, String name){
        this.data = data;
        this.name = name;
    }
    public String getContent(){
        return data;
    }
    @Override
    public boolean equals(Object o){
        if(o instanceof File){
            File other = (File) o;
            return this.name.equals(other.name);
        }
        return false;
    }
}

class Directory{
    File[] files = new File[0];
    private int entries = 0;
    public void add(File item){
        for(int i=1; i<entries; i++){
            if(files[i].equals(item)){
                System.out.println("Item already exists");
                return;
            }
        }
    File[] tempFiles = new File[entries + 1];
    System.arraycopy(files, 0, tempFiles, 0 ,entries);
    tempFiles[entries] = item;
    files = tempFiles;
    entries++;
    }
    public String getContent(){
        String content = "";
        for(File f : files)
            content += f.getContent() + "\n";
        return content.trim();
    }
}

class FolderMain{
    public static void main(String[] args){
        Directory folder = new Directory();
        folder.add(new File("Hello, ", "file1"));
        folder.add(new File("World!", "file2"));
        System.out.println(folder.getContent());
    }
}