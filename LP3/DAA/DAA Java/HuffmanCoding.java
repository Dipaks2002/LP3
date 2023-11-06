import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    int freq;
    char symbol;
    Node left;
    Node right;
    String huff;

    public Node(int freq, char symbol, Node left, Node right) {
        this.freq = freq;
        this.symbol = symbol;
        this.left = left;
        this.right = right;
        this.huff = ""; // Initialize huff as an empty string
    }

    @Override
    public int compareTo(Node nxt) {
        return Integer.compare(this.freq, nxt.freq);
    }
}

class Main {
    public static void printNodes(Node node, String val) {
        String newval = val + node.huff;

        if (node.left != null) {
            printNodes(node.left, newval);
        }
        if (node.right != null) {
            printNodes(node.right, newval);
        }

        if (node.left == null && node.right == null) {
            System.out.println(node.symbol + " -> " + newval);
        }
    }

    public static void main(String[] args) {
        char[] chars = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] freq = { 5, 9, 12, 13, 16, 45 };
        PriorityQueue<Node> nodes = new PriorityQueue<>();

        for (int i = 0; i < chars.length; i++) {
            nodes.add(new Node(freq[i], chars[i], null, null));
        }

        while (nodes.size() > 1) {
            Node left = nodes.poll();
            Node right = nodes.poll();
            left.huff = "0";
            right.huff = "1";

            Node newnode = new Node(left.freq + right.freq, (char) 0, left, right); // Use a placeholder character

            nodes.add(newnode);
        }

        printNodes(nodes.peek(), "");
    }
}
