package aed;
import java.util.ArrayList;
import java.util.List;

public class TrieST<T> {
    private static int R = 256; // radix
    private Node root; // root of trie

    
    private static class Node{
        private Object val;
        private Node[] next = new Node[R];
    }

    public TrieST(){
        root = new Node();

    }
    
    public T get(String key) {
        Node x = get(root, key, 0);
        if (x == null) return null;
        
        return (T) x.val;
    }
    private Node get(Node x, String key, int d) { // Return value associated with key in the subtrie rooted at x.
        if (x == null) return null;
        if (d == key.length()) return x;
        char c = key.charAt(d); // Use dth key char to identify subtrie.
        return get(x.next[c], key, d+1);
    
    }
    
    public void put(String key, T val) { 
        root = put(root, key, val, 0);

    
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        int count = 0;
        if (x.val != null){
            count++;
        }
        for (int r = 0; r < R; r++) {
            count += size(x.next[r]);
        }
        return count;
    }


    private Node put(Node x, String key, T val, int d) { // Change value associated with key if in subtrie rooted at x.
        if (x == null) x = new Node();
        if (d == key.length()) { 
            x.val = val; 
            return x; 
        }
        char c = key.charAt(d); // Use dth key char to identify subtrie.
        x.next[c] = put(x.next[c], key, val, d+1);
        return x;
    } 

    public void delete(String key) { 
        root = delete(root, key, 0);

    }
    private Node delete(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length())
            x.val = null;
        else {
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c], key, d+1);
        }
        if (x.val != null) return x;
        for (char c = 0; c < R; c++)
            if (x.next[c] != null) return x;
        return null;
    }

    public boolean contains(String key) {
        return get(key) != null;
    }

    public Iterable<String> keys() {
        List<String> result = new ArrayList<>();
        collect(root, "", result);
        return result;
    }

    private void collect(Node x, String prefix, List<String> result) {
        if (x == null) return;
        if (x.val != null) result.add(prefix);
        for (char c = 0; c < R; c++) {
            collect(x.next[c], prefix + c, result);
        }
    }

    public Iterable<String> keysWithPrefix(String prefix) {
        List<String> result = new ArrayList<>();
        Node x = get(root, prefix, 0);
        collect(x, prefix, result);
        return result;
    }

    public String longestPrefixOf(String query) {
        int length = search(root, query, 0, 0);
        return query.substring(0, length);
    }

    private int search(Node x, String query, int d, int length) {
        if (x == null) return length;
        if (x.val != null) length = d;
        if (d == query.length()) return length;
        char c = query.charAt(d);
        return search(x.next[c], query, d + 1, length);
    }




}   