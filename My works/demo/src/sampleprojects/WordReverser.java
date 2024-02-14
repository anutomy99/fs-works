package sampleprojects;

public class WordReverser {
    public static void reverseWordsInSentence(String sentance){
        if (sentance == null){
           System.out.println("Invalid");
        }
        if(sentance.equals("")){
           System.out.println("");
        }
        StringBuilder reversedSentance = new StringBuilder();
        for (String word : sentance.split(" ")){
            StringBuilder reversedWord = new StringBuilder(word).reverse();
            reversedSentance.append(reversedWord).append(" ");
        }
        System.out.println( reversedSentance.toString().trim());
    }
    public static void main(String[] args) {
      String sentance = "Hello";
      reverseWordsInSentence(sentance);
    }
}
