class TreeNode{
    TreeNode[] charArray = new TreeNode[26];
    boolean endOfWord = false;

}
class PrefixTree {
    TreeNode head;
    public PrefixTree() {
        head = new TreeNode();
    }

    public void insert(String word) {
        TreeNode node = head;
        int idx = 0;

        if(node.charArray[word.charAt(idx)-'a']!= null){
            while(idx<word.length()){
                if(node.charArray[word.charAt(idx)-'a'] == null){
                    break;
                }
                node = node.charArray[word.charAt(idx)-'a'];
                idx++;
            }
        }
        while(idx<word.length()){
            node.charArray[word.charAt(idx)-'a'] = new TreeNode();
            node = node.charArray[word.charAt(idx)-'a'];
            idx++;
        }
        node.endOfWord = true;

    }

    public boolean search(String word) {
        TreeNode node = head;
        int idx = 0;
        while(idx<word.length()){
            if(node.charArray[word.charAt(idx)-'a'] == null){
                return false;
            }
            node = node.charArray[word.charAt(idx)-'a'];
            idx++;
        }
        return node.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TreeNode node = head;
        int idx = 0;
        while(idx<prefix.length()){
            if(node.charArray[prefix.charAt(idx)-'a'] == null){
                return false;
            }
            node = node.charArray[prefix.charAt(idx)-'a'];
            idx++;
        }
        return true;
    }
}
