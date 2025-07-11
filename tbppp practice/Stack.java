
public class Stack {
    final int max = 1000;
    int[] stackArr = new int[max];
    int top;

    Stack() {
        top = -1;
    }

    void printStack() {
        for(int i = 0; i <= top; i++){
            System.out.println(stackArr[i]);
        }
    }

    void push(int num) {
        if (top < max) {
            stackArr[++top] = num;
        }
    }

    void pop() {
        if (top > 0) {
            top--;
        }
    }
}