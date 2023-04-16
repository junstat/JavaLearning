package Q0899.Q0843GuesstheWord.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

interface Master {
    public int guess(String word);
}

public class Solution {
    public void findSecretWord(String[] words, Master master) {
        Random random = new Random();
        List<String> wordList = new ArrayList<>();
        Collections.addAll(wordList, words);
        for (int i = 0; i < 30; i++) {
            int index = random.nextInt(wordList.size());
            int res = master.guess(wordList.get(index));
            if (res == 6) {
                return;
            }
            List<String> newList = new ArrayList<>();
            if (res != -1) {
                for (String str : wordList) {
                    if (!str.equals(wordList.get(index))) {
                        if (get(str, wordList.get(index), res)) {
                            newList.add(str);
                        }
                    }
                }
            }
            wordList = newList;
        }
    }

    public boolean get(String str1, String str2, int res) {
        int num = 0;
        for (int i = 0; i < 6; i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                num++;
            }
        }
        return num == res;
    }
}