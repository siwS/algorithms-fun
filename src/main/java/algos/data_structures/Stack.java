package algos.data_structures;


class StackFullException extends Exception
{
    public StackFullException(String s)
    {
        // Call constructor of parent Exception
        super(s);
    }
}

public class Stack<T>  {

    private T array[];
    private int top;

    public Stack(int size){
        array = (T[]) new Object[size];
        top = 0;
    }


    public void push(T element) throws StackFullException {
        if (isFull()) {
            throw new StackFullException("Stack is full.");
        }
        array[top] = element;
        top++;
    }


    public int size() {
        return top;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public T pop() {
        if (top == 0) {
            return null;
        }

        top--;
        return array[top];
    }

    public boolean isFull() {
        return top == array.length;
    }
}
