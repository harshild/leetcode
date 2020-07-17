/*
Given a list of reviews, a list of keywords and an integer k. Find the most popular k keywords in order of most to least frequently mentioned.

The comparison of strings is case-insensitive.
Multiple occurances of a keyword in a review should be considred as a single mention.
If keywords are mentioned an equal number of times in reviews, sort alphabetically.

Example 1:

Input:
k = 2
keywords = ["anacell", "cetracular", "betacellular"]
reviews = [
  "Anacell provides the best services in the city",
  "betacellular has awesome services",
  "Best services provided by anacell, everyone should use anacell",
]

Output:
["anacell", "betacellular"]

Explanation:
"anacell" is occuring in 2 different reviews and "betacellular" is only occuring in 1 review.
Example 2:

Input:
k = 2
keywords = ["anacell", "betacellular", "cetracular", "deltacellular", "eurocell"]
reviews = [
  "I love anacell Best services; Best services provided by anacell",
  "betacellular has great services",
  "deltacellular provides much better services than betacellular",
  "cetracular is worse than anacell",
  "Betacellular is better than deltacellular.",
]

Output:
["betacellular", "anacell"]

Explanation:
"betacellular" is occuring in 3 different reviews. "anacell" and "deltacellular" are occuring in 2 reviews, but "anacell" is lexicographically smaller.

*/

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class SixNineTwoVariant {
    @Test
    public void testImplIn1() {
        int k = 2;
        String[] keywords = {"anacell", "betacellular", "cetracular"};
        String[] reviews = {
                "Anacell provides the best services in the city",
                "betacellular has awesome services",
                "Best services provided by anacell, everyone should use anacell",
        };

        List<String> strings = solve(k,keywords,reviews);
        System.out.println(strings);
        Assert.assertEquals(2, strings.size());
    }

    @Test
    public void testImplIn2() {
        int k = 2;
        String[] keywords = {"anacell", "betacellular", "cetracular", "deltacellular", "eurocell"};
        String[] reviews = {
                "I love anacell Best services; Best services provided by anacell",
                "betacellular has great services",
                "deltacellular provides much better services than betacellular",
                "cetracular is worse than anacell",
                "Betacellular is better than deltacellular.",
        };

        List<String> strings = solve(k,keywords,reviews);
        System.out.println(strings);
        Assert.assertEquals(2, strings.size());
    }


    private static List<String> solve(int k, String[] keywords, String[] reviews) {
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : keywords) {
            for (String review: reviews){
                if (Arrays.asList(review.toLowerCase().split(" ")).contains(word.toLowerCase())) {
                    int count = 0;
                    if (wordCount.containsKey(word.toLowerCase())) {
                        count = wordCount.get(word.toLowerCase());
                    }
                    wordCount.put(word, count + 1);
                }
            }
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
