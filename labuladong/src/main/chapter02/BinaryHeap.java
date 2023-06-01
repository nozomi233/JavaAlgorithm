package main.chapter02;

/**
 * @Author zhulang
 * @Date 2023-06-01
 **/
public class BinaryHeap<T extends Comparable<? super T>> {
    private T[] pq;
    // 当前 Priority Queue 中的元素个数
    private int N = 0;

    public BinaryHeap(int cap) {
        // 索引 0 不⽤，所以多分配⼀个空间
        pq = (T[]) new Comparable[cap + 1];
    }

    /* 返回当前队列中最⼤元素 */
    public T max() {
        return pq[1];
    }

    /* 插⼊元素 e */
    public void insert(T e) {
        N++;
        // 先把新元素加到最后
        pq[N] = e;
        // 然后让它上浮到正确的位置
        swim(N);
    }

    /* 删除并返回当前队列中最⼤元素 */
    public T delMax() {
        // 最大堆的堆顶就是最大元素
        T max = pq[1];
        // 把这个最大元素换到最后，删除之
        swap(1, N);
        pq[N] = null;
        N--;
        // 让 pq[1] 下沉到正确位置
        sink(1);
        return max;
    }

    /* 上浮第 k 个元素，以维护最⼤堆性质 */
    private void swim(int k) {
        // 如果浮到堆顶，就不能再上浮了
        while (k > 1 && less(parent(k), k)) {
            // 如果第 k 个元素⽐上层⼤
            // 将 k 换上去
            swap(parent(k), k);
            k = parent(k);
        }
    }

    /* 下沉第 k 个元素，以维护最⼤堆性质 */
    private void sink(int k) {
        // 如果沉到堆底，就沉不下去了
        while (left(k) <= N) {
            // 先假设左边节点较⼤
            int older = left(k);
            // 如果右边节点存在，⽐⼀下⼤⼩
            if (right(k) <= N && less(older, right(k))) {
                older = right(k);
            }
            // 结点 k ⽐俩孩⼦都⼤，就不必下沉了
            if (less(older, k)) {
                break;
            }
            // 否则，不符合最⼤堆的结构，下沉 k 结点
            swap(k, older);
            k = older;
        }
    }

    /* 交换数组的两个元素 */
    private void swap(int i, int j) {
        T temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    /* pq[i] 是否⽐ pq[j] ⼩？ */
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    /* 还有 left, right, parent 三个⽅法 */
    private int parent(int root) {
        return root / 2;
    }
    // 左孩子的索引
    private int left(int root) {
        return root * 2;
    }
    // 右孩子的索引
    private int right(int root) {
        return root * 2 + 1;
    }

}
