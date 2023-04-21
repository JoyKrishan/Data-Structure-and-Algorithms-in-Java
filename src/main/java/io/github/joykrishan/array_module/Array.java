package io.github.joykrishan.array_module;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Array {
    private int[] items;
    private int count;

    public Array(int length) {
        this.items = new int[length];
    }

    public int[] getItems(){
        return Arrays.copyOfRange(items, 0, count);
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }

    public void insert(int item) {
        if (count < items.length) { // space left in the array
            items[count] = item;
            count++;
        } else { // no space, grow the array
            int[] new_items = new int[(items.length+1) * 2]; // adding a plus 1 for edge case length = 0

            for (int i = 0; i < count; i++) { // copy the items to new array
                new_items[i] = items[i];
            }
            this.items = new_items; // assign the new address to class variable
            insert(item); // now insert the item
        }
    }

    public int indexOf(int item) { // linear search as the arr is not sorted
        for (int i = 0; i < count; i++) {
            if (items[i] == item) return i;
        }
        return -1;
    }

    public void removeAt(int idx) {
        if (idx < count) {
            if (idx == count - 1) { // check if the idx is of last item
                items[idx] = 0;
                count--;
            } else {
                int steps = count - idx + 1;
                for (int i = idx; i < count - 1; i++) {// swap positions
                    items[i] = items[i + 1];
                }
                removeAt(count - 1); // make the last index as
            }
        } else throw new IndexOutOfBoundsException("Index " + idx + " is out of bounds");
    }

    public void insertAt(int idx, int item) {
        if (idx < items.length) {
            if (idx < count) { // inserting in the middle
                for (int i = count - 1; i >= idx; i--) {
                    items[i + 1] = items[i];
                }
                items[idx] = item;
            } else { // inserting in the end
                insert(item);
            }
        } else throw new IndexOutOfBoundsException("Index " + idx + " out of bounds");
    }

    public int max() {
        int max = items[0];
        for (int i = 1; i < count; i++) {
            if (items[i] > max) {
                max = items[i];
            }
        }
        return max;
    }

    public void reverse() {
        int rightIdx = count - 1;
        int leftIdx = 0;
        while (leftIdx < rightIdx) {
            swap(leftIdx, rightIdx);
            leftIdx++;
            rightIdx--;
        }
    }

    private void swap(int leftIdx, int rightIdx) {
        int temp = items[rightIdx];
        items[rightIdx] = items[leftIdx];
        items[leftIdx] = temp;
    }

    public Array intersect(Integer[] arr2) {
        Set<Integer> arr2_set = new HashSet(Arrays.asList((arr2)));
        Array common_items = new Array(items.length);
        for (int i = 0; i < items.length; i++) { // O(n)
            if (arr2_set.contains(items[i])) { // O(1)
                common_items.insert(items[i]);
            }
        }
        return common_items;
    }
}