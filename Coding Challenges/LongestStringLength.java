public class LongestStringLength{
    public static void main(String [] args){
        String [] words = {"tanjiro","The Fool","Atasuki","jiraya"};

        int maxLength=0;

        for(String word : words){
            if(word.length() > maxLength){
                maxLength=word.length();
            }
        }
        System.out.println("Length of the longest string : "+maxLength);
    }
}