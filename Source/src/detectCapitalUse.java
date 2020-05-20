/**
 * Create by swtywang on 2020-05-20 21:46
 */
public class detectCapitalUse {
    public boolean detectCapitalUse(String word) {
        if (word.length()==0){
            return false;
        }
        String UpperWord = word.toUpperCase();
        boolean isFirstUpperFlag = UpperWord.charAt(0) == word.charAt(0);
        int UpperCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == UpperWord.charAt(i)) {
                UpperCount++;
            }
        }
        if (UpperCount == 0 || UpperCount == word.length() || ((isFirstUpperFlag == true) && (UpperCount == 1)))
        {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "Sa";
        boolean result = new detectCapitalUse().detectCapitalUse(s);
        System.out.println(result);
    }
}
