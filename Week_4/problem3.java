class Acronymus{
    private static final int CAPACITY=20;
    private String[]words;
    private String []acronym;
    private static int counter = 0;
    public Acronymus()
    {
        words = new String[CAPACITY];
        acronym = new String[CAPACITY];
    }
    public boolean add(String new_word, String new_acronym){
        if(counter >= CAPACITY) return false;
        for(int i=0; i<counter; i++){
            if(words[i].equalsIgnoreCase(new_word)){
                acronym[i] = new_acronym;
                return true;
            }
        }
        words[counter] = new_word;
        acronym[counter] = new_acronym;
        counter++;
        return true;
    }
    public String getWord(String acr){
        for(int i=0; i<counter; i++){
            if(acronym [i].equalsIgnoreCase(acr)) return words[i];
        }
        return "XXXXX";
    }
}
class AcronymClient{
    public static void main(String []args){
        Acronymus ac = new Acronymus();
        ac.add("Banca nationala a romaniei", "bnr");
        ac.add("Banca comerciala romana", "bcr");
        ac.add("ministerul apararii interne", "mai");

        ac.add("Banca natoinala a romaniei", "bnr100");

        for(int i = 0; i < 17; i++){
            ac.add("abc" + (i+1), "abc" + (i+1));
        }

        System.out.println(ac.add("this should fail cause of capacity exceeded", "tsf"));

        System.out.println(ac.getWord("bnr"));
        System.out.println(ac.getWord("bcr"));
        System.out.println(ac.getWord("mai"));
        System.out.println(ac.getWord("abc15"));
        
    }
}