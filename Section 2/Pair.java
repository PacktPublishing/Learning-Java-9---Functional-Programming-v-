package Product3.GenericFunctions;

public class Pair<K, V> {
    private final K left;
    private final V right;

    public Pair(K left, V right) {
        this.left = left;
        this.right = right;
    }

    public K getLeft() {
        return this.left;
    }

    public V getRight() {
        return this.right;
    }
}
