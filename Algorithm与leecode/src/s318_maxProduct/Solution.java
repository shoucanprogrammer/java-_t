package s318_maxProduct;

class Solution {
    public int maxProduct(String[] words) {
        int n = words.length, idx = 0;
        int[] masks = new int[n];
        for (String w : words) {
            int t = 0;
            for (int i = 0; i < w.length(); i++) {
                int u = w.charAt(i) - 'a';
                t |= (1 << u);
            }
            masks[idx++] = t;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if ((masks[i] & masks[j]) == 0) ans = Math.max(ans, words[i].length() * words[j].length());
            }
        }
        return ans;
    }
}

