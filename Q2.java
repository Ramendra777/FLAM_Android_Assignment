class MyHashMap {
    private final int SIZE = 1009; // Prime number for fewer collisions
    private Entry[] buckets;

    public MyHashMap() {
        buckets = new Entry[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);
        Entry head = buckets[index];
        Entry curr = head;

        while (curr != null) {
            if (curr.key == key) {
                curr.value = value;
                return;
            }
            curr = curr.next;
        }

        Entry newNode = new Entry(key, value);
        newNode.next = head;
        buckets[index] = newNode;
    }

    public int get(int key) {
        int index = hash(key);
        Entry curr = buckets[index];
        while (curr != null) {
            if (curr.key == key) return curr.value;
            curr = curr.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        Entry curr = buckets[index], prev = null;
        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) {
                    buckets[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    private static class Entry {
        int key, value;
        Entry next;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

public class Q2 {
    public static void main(String[] args) {
        MyHashMap obj = new MyHashMap();

        obj.put(1, 10);
        obj.put(2, 20);
        System.out.println(obj.get(1)); // 10
        System.out.println(obj.get(3)); // -1

        obj.put(2, 30);
        System.out.println(obj.get(2)); // 30

        obj.remove(2);
        System.out.println(obj.get(2)); // -1
    }
}
