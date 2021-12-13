package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Words {

    private final List<String> words = new ArrayList<>();

    public void addWord(String word) {
        if (word.contains(" ")) {
            throw new IllegalArgumentException("It should be one word!");
        } else if (!word.toLowerCase().equals(word)) {
            throw new IllegalArgumentException("Word should be lower case!");
        }
        words.add(word);
    }

    public boolean isThereAWordTwice() {
        List<String> finderList = new ArrayList<>();
        for (String item : words) {
            if (!finderList.contains(item)) {
                finderList.add(item);
            } else {
                return true;
            }
        }
        return false;
    }

    public List<String> getWords() {
        return words;
    }
}
