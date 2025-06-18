import java.util.List;
import java.util.ArrayList;

public class LinkedListDeque61B<T> implements Deque61B<T>  {

    public class Node {
        private Node nt;
        private Node prev;
        private T t;

        public Node(Node nt, Node prev, T t) {
            this.nt = nt;
            this.prev = prev;
            this.t = t;
        }
    }

    private int size;
    private Node first;

    public LinkedListDeque61B() {
        size = 0;
        first = new Node(null, null, null);
        first.nt = first;
        first.prev = first;
    }

    @Override
    public void addFirst(T x) {
        Node head = new Node(first.nt, first, x);
        first.nt.prev = head;
        first.nt = head;
        size = size + 1;
    }

    @Override
    public void addLast(T x) {
        Node tail = first.prev;
        Node addedNode = new Node(first, tail, x);
        first.prev = addedNode;
        tail.nt = addedNode;
        size = size + 1;
    }

    @Override
    public List<T> toList() {
        List<T> list = new ArrayList<>();
        Node now = first.nt;
        while (now != first) {
            list.add(now.t);
            now = now.nt;
        }
        return list;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T now = first.nt.t;
        first.nt = first.nt.nt;
        first.nt.prev = first;
        size--;
        return now;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T now = first.prev.t;
        first.prev = first.prev.prev;
        first.prev.nt = first;
        size--;
        return now;
    }

    @Override
    public T get(int index) {
        if (index < 0) {
            return null;
        }
        if (index >= size) {
            return null;
        } else {
            Node now = first.nt;
            for (int i = index; i > 0; i--) {
                now = now.nt;
            }
            return now.t;
        }
    }

    @Override
    public T getRecursive(int index) {
        if (index < 0) {
            return null;
        }
        if (index >= size) {
            return null;
        }
        return getRecursiveHelper(index, first.nt);

    }

    public T getRecursiveHelper(int index, Node now) {
        if (index == 0) {
            return now.t;
        }
        return getRecursiveHelper(index - 1, now.nt);
    }
}
