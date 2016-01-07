package basic;

import java.util.Random;

/**
 * Created by jai on 9/7/15.
 */
public class Heap {
    private int size;
    private int[] heap;

    public Heap(int size) {
        this.size = size;
        this.heap = new int[size+1];
    }

    public int parent(int index) {
        return index / 2;
    }

    public boolean hasLeft(int index) {
        return 2*index < size;
    }

    public boolean hasRight(int index) {
        return 2*index + 1 < size;
    }


    public int leftChild(int index) {
        return heap[2*index];
    }

    public int rightChild(int index) {
        return heap[2*index + 1];
    }

    public void heapify(int index) {
        int maxIndex = index, maxValue = heap[index];
        if(hasLeft(index)) {
            if (maxValue < leftChild(index)) {
                maxIndex = 2*index;
                maxValue = leftChild(index);
            }
        }
        if(hasRight(index)) {
            if (maxValue < rightChild(index)) {
                maxIndex = 2*index + 1;
                maxValue = rightChild(index);
            }
        }

        if(maxIndex != index) {
            heap[maxIndex] = heap[index];
            heap[index] = maxValue;
            heapify(maxIndex);
        }
    }

    public void buildHeap() {
        int n = size/2;
        while(n > 0) {
            heapify(n--);
        }
    }

    public void initHeap() {
        Random r = new Random(System.currentTimeMillis());
        for(int i = 1; i <= size; i++) {
            heap[i] = r.nextInt(30);
        }
    }

    public void printHeap() {
        int index = 1, i = 2;
        while(index <= size) {
            while(index < i) {
                System.out.print(heap[index++] + " ");
            }
            System.out.println();
            i = i<<1;
        }
    }

    public static void main(String[] args) {
        Random r = new Random(System.currentTimeMillis());
        Heap h = new Heap(15);
        h.initHeap();
        h.printHeap();
        h.buildHeap();
        h.printHeap();
    }


}
