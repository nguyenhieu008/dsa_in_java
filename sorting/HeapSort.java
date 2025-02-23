package sorting;

import util.Utils;

public class HeapSort implements Sorting {
    public void sort(int[] arr) {
        sortWithDataStructure(arr);
    }

    private void sortWithDataStructure(int[] arr) {
        Heap heap = new Heap(arr, arr.length);

        while (heap.size > 0) {
            heap.removeMax();
        }
        Utils.printSortedList(heap.arr);
    }

    private void sortNoDataStructure(int[] arr) {
        int endNode = arr.length - 1;
        int lastBranch = (endNode - 1) / 2;

        for (int r = lastBranch; r >= 0; r--) {
            adjust(arr, r, endNode);
        }

        Utils.printList(arr);
        while (endNode > 0) {
            Utils.swap(arr, 0, endNode);
            endNode--;
            adjust(arr, 0, endNode);
        }

        Utils.printSortedList(arr);
    }

    private void adjust(int[] arr, int root, int endNode) {
        int r = root;
        int leftIndex = r * 2 + 1;
        int rightIndex = r * 2 + 2;

        while (leftIndex <= endNode) {
            int toSwap = leftIndex;
            if (rightIndex <= endNode && arr[toSwap] < arr[rightIndex]) {
                toSwap = rightIndex;
            }
            if (arr[r] >= arr[toSwap]) {
                break;
            }
            Utils.swap(arr, r, toSwap);
            r = toSwap;
            leftIndex = r * 2 + 1;
            rightIndex = r * 2 + 2;
        }
    }

    class Heap {
        int[] arr;
        int size;

        Heap(int[] arr, int size) {
            this.arr = arr;
            this.size = size;

            buildHeap();

            System.out.print("Initialized heap: ");
            Utils.printList(arr);
        }

        private void buildHeap() {
            for (int r = rootOf(size - 1); r >= 0; r--) {
                downHeap(r);
            }
        }

        void upHeap(int c) {
            int r = rootOf(c);
            while (r >= 0 && arr[c] > arr[r]) {
                Utils.swap(arr, c, r);
                c = r;
                r = rootOf(c);
            }
        }

        void downHeap(int c) {
            int r = c;
            int left = leftOf(r);

            while (left != -1) {
                int toSwap = left;
                int right = rightOf(r);

                if (right != -1 && arr[right] > arr[toSwap]) toSwap = right;

                if (arr[r] >= arr[toSwap]) return;

                Utils.swap(arr, r, toSwap);
                r = toSwap;
                left = leftOf(r);
            }
        }

        public int removeMax() {
            if (size == 0) return -1;

            int res = arr[0];
            Utils.swap(arr, 0, size - 1);
            size--;

            downHeap(0);

            Utils.printList(arr);
            return res;
        }

        private int rootOf(int c) {
            if (c == 0) return -1;
            return (c - 1) / 2;
        }

        private int leftOf(int r) {
            int leftIndex = r * 2 + 1;
            if (leftIndex < size) {
                return leftIndex;
            }
            return -1;
        }

        private int rightOf(int r) {
            int rightIndex = r * 2 + 2;
            if (rightIndex < size) {
                return rightIndex;
            }
            return -1;
        }
    }
}
