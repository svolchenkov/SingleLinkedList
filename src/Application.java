public class Application {

    private Node rootNode;

    public static void main(String[] args) {
        Application application = new Application();
        application.createList();
        application.printNodes(application.rootNode);
        application.revert(application.rootNode);
        application.printNodes(application.rootNode);
    }

    private void createList() {
        Node prevNode = new Node(0, null);
        rootNode = prevNode;
        Node node = null;
        for (int i = 1; i < 10; i++) {
            node = new Node(i, null);
            prevNode.setNextNode(node);
            prevNode = node;
        }
    }

    private void printNodes(Node node) {
        System.out.println("--------------------------------------");
        while (node != null) {
            System.out.println(node);
            node = node.getNextNode();
        }
    }

    private void revert (Node node) {
        Node prevNode = null;
        Node currNode = node;
        Node nextNode = node.getNextNode();
        currNode.setNextNode(null);

        while (null != nextNode) {
            prevNode = currNode;
            currNode = nextNode;
            nextNode = nextNode.getNextNode();
            currNode.setNextNode(prevNode);
        }
        rootNode = currNode;
    }
}

class Node {
    private int id;
    private Node nextNode;

    public Node(int id, Node nextNode) {
        this.id = id;
        this.nextNode = nextNode;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                '}';
    }
}