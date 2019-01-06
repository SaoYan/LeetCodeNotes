// Slution 1: O(N^2)
/*
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<Character>();
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            set.clear();
            set.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                if (!set.contains(s.charAt(j)))
                    set.add(s.charAt(j));
                else break;
            }
            if (maxLength < set.size())
                maxLength = set.size();
        }
        return maxLength;
    }
}
*/

// Solution 2: O(N)
/*
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<Character>();
        int i = 0, j = 0, maxLength = 0;
        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j)))
                set.add(s.charAt(j++));
            else
                set.remove(s.charAt(i++));
            if (maxLength < set.size())
                maxLength = set.size();
        }
        return maxLength;
    }
}
*/

// Solution 3: O(N); optimization of Solution 2
/*
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int i = 0, maxLength = 0;
        for (int j = 0; j < s.length(); j++) {
            if (!map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), j+1);
            }
            else {
                i = Math.max(i, map.get(s.charAt(j)));
                map.put(s.charAt(j), j+1);
            }
            maxLength = Math.max(maxLength, j + 1 - i);
        }
        return maxLength;
    }
}
*/

//Solution 4 : O(N); specialized for String; even faster than Solution 3
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int idx[] = new int[128];
        int i = 0, maxLength = 0;
        for (int j = 0; j < s.length(); j++) {
            if (idx[s.charAt(j)] == 0) {
                idx[s.charAt(j)] = j + 1;
            }
            else {
                i = Math.max(i, idx[s.charAt(j)]);
                idx[s.charAt(j)] = j + 1;
            }
            maxLength = Math.max(maxLength, j + 1 - i);
        }
        return maxLength;
    }
}
