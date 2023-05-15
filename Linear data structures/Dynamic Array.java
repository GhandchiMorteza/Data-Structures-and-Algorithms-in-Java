public class Array {
    private int[] items;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    public void insert(int item) {
        if (count == items.length) {
            int[] newItems = new int[count * 2];
            System.arraycopy(items, 0, newItems, 0, count);
            items = newItems;
        }
        items[count++] = item;
    }

    public void insertAt(int item, int index) {
        if (index < 0 || index > count)
            throw new IllegalArgumentException();
        if (count == items.length) {
            int[] newItems = new int[count * 2];
            System.arraycopy(items, 0, newItems, 0, count);
            items = newItems;
        }
        for (int i = count; i > index; i--) items[i] = items[i - 1];
        items[index] = item;
        count++;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();

        for (int i = index; i < count - 1; i++) items[i] = items[i + 1];
        items[--count] = 0;
    }

    public int indexOf(int item) {
        for (int i = 0; i < items.length; i++)
            if (items[i] == item)
                return i;
        return -1;
    }

    public int max() {
        int max = items[0];
        for (int i = 1; i < count; i++)
            if (items[i] > max)
                max = items[i];
        return max;
    }

    public Array intersect(Array arr2) {
        Array intersectArr = new Array(count / 2);
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < arr2.count; j++) {
                if (arr2.items[j] == items[i]) {
                    intersectArr.insert(items[i]);
                    break;
                }
            }
        }
        return intersectArr;
    }

    public void reverse() {
        int[] newItems = new int[items.length];
        for (int i = 0; i < count; i++) {
            newItems[i] = items[count - i - 1];
        }
        items = newItems;
    }

    public void print() {
        for (int i = 0; i < count; i++) System.out.println(items[i]);
    }

}
