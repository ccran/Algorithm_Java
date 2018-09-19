package Algorithm4th.List;

import java.util.Iterator;

/**
 * 可迭代的动态扩容泛型栈
 * @param <Item>
 */
public class ResizingArrayStack<Item> implements Iterable<Item>{
    private Item[] items;
    private int N;

    public ResizingArrayStack(int capacity) {
        items = (Item[]) new Object[capacity];
    }

    public void push(Item item) {
        if (N == items.length) resize(2 * N);
        items[N++] = item;
    }

    public Item pop() {
        Item res = items[--N];
        items[N] = null;
        if (N > 0 && N == items.length / 4) resize(items.length / 2);
        return res;
    }

    private void resize(int max) {
        Item[] tmp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            tmp[i] = items[i];
        }
        items = tmp;
    }


    @Override
    public Iterator<Item> iterator() {
        return new ReverseIteratorArray();
    }

    private class ReverseIteratorArray implements Iterator<Item>{
        private int i = N;

        @Override
        public boolean hasNext() {
            return i>0;
        }

        @Override
        public Item next() {
            return items[--i];
        }
    }

    public static void main(String[] args) {
        ResizingArrayStack<String> resizingArrayStack = new ResizingArrayStack<>(10);
        resizingArrayStack.push("123");resizingArrayStack.push("234");
        for(String item:resizingArrayStack){
            System.out.println(item);
        }
    }
}
