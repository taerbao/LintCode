import java.util.*;

public class WordBreakII {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        // write your code here
        Map<String, List<String>> memo = new HashMap<>();

        return wordBreakHelper(s,wordDict,memo);
    }

    private List<String> wordBreakHelper(String s, Set<String> wordDict, Map<String, List<String>> memo) {
        if (memo.containsKey(s))
            return memo.get(s);

        List<String> result = new ArrayList<>();
        if (wordDict.contains(s))
            result.add(s);

        for (int i = 1; i < s.length(); i++) {
            String word = s.substring(0, i);
            if (!wordDict.contains(word))
                continue;
            List<String> partResult = wordBreakHelper(s.substring(i), wordDict, memo);
            for (String temp : partResult) {
                result.add(word + " " + temp);
            }
        }
        memo.put(s, result);
        return result;
    }

}
