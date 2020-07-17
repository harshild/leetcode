/*
Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.

Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
with the number of occurrence being 4, 3, 2 and 1 respectively.

*/

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class SixNineTwo {
    @Test
    public void testImplIn1() {
        String [] input = {"i", "love", "leetcode", "i", "love", "coding"};
        List<String> strings = topKFrequent(input, 2);
        System.out.println(strings);
        Assert.assertEquals(2, strings.size());
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            int count = 0;
            if(wordCount.containsKey(word.toLowerCase())){
                count = wordCount.get(word.toLowerCase());
            }
            wordCount.put(word,count +1);
        }

        ArrayList<String> wordsList = new ArrayList<>(wordCount.keySet());
        wordsList.sort((o1, o2) -> {
            int compare = wordCount.get(o2).compareTo(wordCount.get(o1));
            if (compare != 0) {
                return compare;
            } else {
                return o1.compareTo(o2);
            }
        });
        return wordsList.subList(0,k);
    }
}
