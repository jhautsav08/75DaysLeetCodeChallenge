class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    TrieNode root = new TrieNode();

    public List<String> findWords(char[][] board,
                                  String[] words) {

        List<String> ans = new ArrayList<>();

        // build trie
        for (String word : words) {
            insert(word);
        }

        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                dfs(board, r, c, root, ans);
            }
        }

        return ans;
    }

    public void insert(String word) {

        TrieNode node = root;

        for (char ch : word.toCharArray()) {

            int idx = ch - 'a';

            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }

            node = node.children[idx];
        }

        node.word = word;
    }

    public void dfs(char[][] board,
                    int r,
                    int c,
                    TrieNode node,
                    List<String> ans) {

        // boundary
        if (r < 0 || c < 0 ||
            r >= board.length ||
            c >= board[0].length) {
            return;
        }

        char ch = board[r][c];

        // visited or not in trie
        if (ch == '#' ||
            node.children[ch - 'a'] == null) {
            return;
        }

        node = node.children[ch - 'a'];

        // word found
        if (node.word != null) {

            ans.add(node.word);

            // avoid duplicates
            node.word = null;
        }

        // mark visited
        board[r][c] = '#';

        dfs(board, r + 1, c, node, ans);
        dfs(board, r - 1, c, node, ans);
        dfs(board, r, c + 1, node, ans);
        dfs(board, r, c - 1, node, ans);

        // restore
        board[r][c] = ch;
    }
}