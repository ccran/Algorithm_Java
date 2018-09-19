package Algorithm4th.List;

import java.util.Scanner;

public class FixedCapacityStackOfString<Item> {
    private Item[] a;
    private int N;

    public FixedCapacityStackOfString(int capacity) {
        a = (Item[]) new Object[capacity];
    }

    public void push(Item item) {
        a[N++] = item;
    }

    public Item pop() {
        return a[--N];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }


    public static void main(String[] args) {
        FixedCapacityStackOfString<String> fixedCapacityStackOfString =
                new FixedCapacityStackOfString(100);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String item = scanner.next();
            if (!item.equals("-")) {
                fixedCapacityStackOfString.push(item);
            } else if (!fixedCapacityStackOfString.isEmpty()) {
                System.out.print(fixedCapacityStackOfString.pop() + " ");
            }
        }
        System.out.println(("( " + fixedCapacityStackOfString.size() + " left on stack)"));
    }
}
