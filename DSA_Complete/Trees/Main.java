package Trees;

import java.util.Scanner;

/*
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(sc);
//        tree.display();
        tree.prettyDisplay();
    }
}
*/



/*
public class Main{
    public static void main(String[] args) {
        BST tree = new BST();
        int[] nums = {1,2,4,6,24,35,67,89};
//        Scanner sc = new Scanner(System.in);
        tree.populate(nums);
        tree.display();

    }
}*/


// for AVL

class Main {
    public static void main(String[] args) {
        AVL tree = new AVL();

        for(int i=0; i < 1000; i++) {
            tree.insert(i);
        }

        System.out.println(tree.height());
    }
}