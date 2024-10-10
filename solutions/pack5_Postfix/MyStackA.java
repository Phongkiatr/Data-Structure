package solutions.pack5_Postfix;
public class MyStackA<T> {
    private int MAX_SIZE = 100;
    private Object [] stack = new Object[MAX_SIZE];
    protected int top = 0;

    public void push(T d) {
        if (!isFull())
            stack[top++] = d;
    }

    public T pop() {
        if (!isEmpty()) {
            return (T) stack[--top];
        }
        return null;
    }

    public T peek() {
        return (T) stack[top - 1];
    }

    public boolean isFull() {
        return top == MAX_SIZE;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("top->");
        for(int i = top - 1; i >= 0; i--) {
            sb.append("[");
            sb.append(stack[i]);
            sb.append("]->");
        }
            sb.append("bottom");
        return sb.toString();
    }
}