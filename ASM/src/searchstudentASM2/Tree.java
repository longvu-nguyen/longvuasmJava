package searchstudentASM2;

public class Tree {
    Node root;

    public Tree() {
        root = null;
    }

    public void insert(Student student) {
        root = insertAt(root, student);
    }

    private Node insertAt(Node root, Student student) {
        if (root == null) {
            return new Node(student);
        }
        if (student.getId() < root.student.getId()) {
            root.left = insertAt(root.left, student);
        } else if (student.getId() > root.student.getId()) {
            root.right = insertAt(root.right, student);
        } else {
            throw new IllegalArgumentException("ID " + student.getId() + " đã tồn tại!");
        }
        return root;
    }
    public Student searchBST(int id) {
        return searchBST(root, id);
    }

    private Student searchBST(Node root, int id) {
        if (root == null || root.student.getId() == id) {
            return (root == null) ? null : root.student;
        }
        if (id < root.student.getId()) {
            return searchBST(root.left, id);
        }
        return searchBST(root.right, id);
    }
    public void inOrder() {
        if (root == null) {
            System.out.println("Cây rỗng.");
            return;
        }
        System.out.println("Duyệt In-order:");
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.student);
            inOrder(root.right);
        }
    }

    public void preOrder() {
        if (root == null) {
            System.out.println("Cây rỗng.");
            return;
        }
        System.out.println("Duyệt Pre-order:");
        preOrder(root);
        System.out.println();
    }

    private void preOrder(Node root) {
        if (root != null) {
            System.out.println(root.student);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void postOrder() {
        if (root == null) {
            System.out.println("Cây rỗng.");
            return;
        }
        System.out.println("Duyệt Post-order:");
        postOrder(root);
        System.out.println();
    }

    private void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.student);
        }
    }
}