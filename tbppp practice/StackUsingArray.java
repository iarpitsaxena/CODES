public class StackUsingArray {
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(10);
        s.printStack();
        s.push(20);
        s.printStack();

        s.pop();
        s.printStack();
    }
}