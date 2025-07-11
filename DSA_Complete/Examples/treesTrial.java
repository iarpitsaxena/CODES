package Examples;

public class treesTrial {
    public static class BST{
        int value;
        BST left,right;

        public BST(int item) {
            this.value = item;
        }
    }
    static class BStree{
        BST root;
        void insert(int value){
            root = insertRec(root,value);
        }
        BST insertRec(BST  node, int value){
            if(root == null){
                node = new BST(value);
                return node;
            }
            if(value < node.value){
                insertRec(node.left,value);
            }
            if(value > node.value){
                insertRec(node.right,value);
            }
            return node;
        }

        void inOrder(){
            inOrderRec(root);
        }
        void inOrderRec(BST node){
            if(node != null){
                inOrderRec(node.left);
                System.out.println(node.value + " ");
                inOrderRec(node.right);
            }
        }
    }

    public class Main{
        public static void main(String[] args) {
            BStree bst = new BStree();
            bst.insert(50);
            bst.insert(40);

        }
    }
}
