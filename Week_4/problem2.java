class Text{
    private static final int MAX_WORDS = 20;  
    private String []words;
    private int []count_words;
    private static int word_counter = 0;
    public Text(){
        words = new String[MAX_WORDS];
        count_words = new int[MAX_WORDS];
    }
    boolean addWord(String new_word){
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
    public void printText(){
        for(int i=0;i<word_counter;i++){
            System.out.println("The word '" + words[i] + "' has " + count_words[i] + " appearances");
        }
    }
}
class TextClient {
    public static void main(String[] args) {
        Text text = new Text();
        text.addWord("hello");
        text.addWord("world");
        text.addWord("hello");
        text.addWord("java");
        text.addWord("programming");
        text.addWord("world");

        text.printText();

        text.addWord("test1");
        text.addWord("test2");
        text.addWord("test3");
        text.addWord("test4");
        text.addWord("test5");
        text.addWord("test6");
        text.addWord("test7");
        text.addWord("test8");
        text.addWord("test9");
        text.addWord("test10");
        text.addWord("test11");
        text.addWord("test12");
        text.addWord("test13");
        text.addWord("test14");
        text.addWord("test15");
        System.out.println(text.addWord("test16")); // Output: true
        System.out.println(text.addWord("test17")); // Output: false

    }
}