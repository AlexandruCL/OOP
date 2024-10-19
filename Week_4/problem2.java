class Text{
    private static final int MAX_WORDS = 20;  
    private String []words;
    private int []count_words;
    private static int word_counter = 0;
    public Text(){
        words = new String[MAX_WORDS];
        count_words = new int[MAX_WORDS];
    }
    boolean add_word(String new_word){
        if(word_counter >= MAX_WORDS) return false;
        for(int i=0;i<word_counter;i++){
            if(new_word.equals(words[i])){
                count_words[i]++;
                return true;
            }
        }
        words[word_counter] = new_word;
        count_words[word_counter] = 1;
        word_counter++;
        return true;
    }
    public void print_words(){
        for(int i=0;i<word_counter;i++){
            System.out.println("The word '" + words[i] + "' has " + count_words[i] + " appearances");
        }
    }
}
class TextClient{
    public static void main(String[] args){
        Text myText = new Text();
        myText.add_word("hello");
        myText.add_word("java");
        myText.add_word("hello");
        myText.add_word("upt");
        myText.print_words();
    }
}