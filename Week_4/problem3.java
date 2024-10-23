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
    public boolean addWord(String new_word, String new_acronym){
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
class AcronymsClient {
    public static void main(String[] args) {
        Acronymus acronyms = new Acronymus();
        acronyms.addWord("HyperText Markup Language", "HTML");
        acronyms.addWord("Cascading Style Sheets", "CSS");
        acronyms.addWord("JavaScript", "JS");

        System.out.println(acronyms.getWord("HTML")); // Output: HyperText Markup Language
        System.out.println(acronyms.getWord("CSS"));  // Output: Cascading Style Sheets
        System.out.println(acronyms.getWord("JS"));   // Output: JavaScript
        System.out.println(acronyms.getWord("PHP"));  // Output: XXXX
    }
}