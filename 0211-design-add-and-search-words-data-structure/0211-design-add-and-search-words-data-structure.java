class WordDictionary {

    class Node {
        Node[] children = new Node[26];
        boolean isEnd = false;
    }

    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node curr = root;

        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }

        curr.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int i, Node node) {
        if (node == null) return false;

        if (i == word.length()) return node.isEnd;

        char c = word.charAt(i);

        if (c == '.') {
            // try all possibilities
            for (Node child : node.children) {
                if (dfs(word, i + 1, child)) return true;
            }
            return false;
        } else {
            return dfs(word, i + 1, node.children[c - 'a']);
        }
    }
}