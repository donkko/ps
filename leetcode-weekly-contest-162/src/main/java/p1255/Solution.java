package p1255;

public class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int answer = 0;

        int[] usableLetters = new int[26];
        for (char letter: letters) {
            usableLetters[indexOf(letter)]++;
        }

        int numOfWords = words.length;
        int numOfCases = 1 << numOfWords;
        for (int c = 0; c < numOfCases; c++) {
            int scoreOfThisCase = 0;
            int[] necessaryLetters = new int[26];
            for (int idx = 0; idx < numOfWords; idx++) {
                if ((c & (1 << idx)) > 0) {
                    char[] word = words[idx].toCharArray();
                    for (char letter : word) {
                        necessaryLetters[indexOf(letter)]++;
                        scoreOfThisCase += score[indexOf(letter)];
                    }
                }
            }

            boolean canBeAnAnswer = true;
            for (int i = 0; i < 26; i++) {
                if (necessaryLetters[i] > usableLetters[i]) canBeAnAnswer = false;
            }

            if (canBeAnAnswer) {
                answer = Math.max(answer, scoreOfThisCase);
            }
        }

        return answer;
    }

    private int indexOf(char letter) {
        return (int) letter - (int) 'a';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = new String[] {"azb","ax","awb","ayb","bpppp"};
        char[] letters = new char[] {'z','a','w','x','y','b','p','p','p'};
        int[] score = new int[] {10,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,3,2,3,3};

        System.out.println(solution.maxScoreWords(words, letters, score));
    }
}
