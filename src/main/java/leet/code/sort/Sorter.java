package leet.code.sort;

import java.util.Arrays;

import org.junit.Test;


/**
 *
 * @description: 排序算法
 * @author: jfm
 * @date: 2022/01/12 10:09
 **/
public class Sorter {

    // 冒泡排序
    // 思想：依次比较相邻的两个数，将比较小的数放在前面，比较大的数放在后面。
    //
    //　　　　(1)第一次比较：首先比较第一和第二个数，将小数放在前面，将大数放在后面。
    //
    //　　　　(2)比较第2和第3个数，将小数 放在前面，大数放在后面。
    //
    //　　　　......
    //
    //　　　　(3)如此继续，知道比较到最后的两个数，将小数放在前面，大数放在后面，重复步骤，直至全部排序完成
    //
    //　　　　(4)在上面一趟比较完成后，最后一个数一定是数组中最大的一个数，所以在比较第二趟的时候，最后一个数是不参加比较的。
    //
    //　　　　(5)在第二趟比较完成后，倒数第二个数也一定是数组中倒数第二大数，所以在第三趟的比较中，最后两个数是不参与比较的。
    //
    //　　　　(6)依次类推，每一趟比较次数减少依次
    //    由此可见：N个数字要排序完成，总共进行N-1趟排序，每i趟的排序次数为(N-i)次，所以可以用双重循环语句，外层控制循环多少趟，内层控制每一趟的循环次数
    public void bubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    @Test
    public void bubbling() {
        int[] arr = {10, 1, 35, 61, 89, 36, 55};
        bubble(arr);
        System.out.println(Arrays.toString(arr));
        insert(arr);
        System.out.println("insert" + Arrays.toString(arr));
        select(arr);
        System.out.println("select" + Arrays.toString(arr));
        merge(arr);
        System.out.println("merge" + Arrays.toString(arr));
    }


    // 插入排序
    //    我们将数组中的数据分为两个区间，已排序区间和未排序区间。初始已排序区间只有一个元素，就是数组的第一个元素。插入算法的核心思想是取未排序区间中的元素，在已排序区间中找到合适的插入位置将其插入，并保证已排序区间数据一直有序。重复这个过程，直到未排序区间中元素为空，算法结束。

    public void insert(int[] arr) {
        int tmp;
        int i;
        int j;
        for (i = 1; i < arr.length; i++) {
            tmp = arr[i];
            for (j = i - 1; j >= 0 && arr[j] > tmp; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = tmp;
        }

    }

    // 选择排序
    // 算法的实现思路有点类似插入排序，也分已排序区间和未排序区间。但是选择排序每次会从未排序区间中找到最小的元素，将其放到已排序区间的末尾。
    public void select(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j]>min){
                    swap(arr,min,i);
                }
            }
        }
    }

    // 归并排序
    // 归并排序的算法思想是：把数组从中间划分为两个子数组，一直递归地把子数组划分成更小的数组，直到子数组里面只有一个元素的时候开始排序。排序的方法就是按照大小顺序合并两个元素。接着依次按照递归的顺序返回，不断合并排好序的数组，直到把整个数组排好序。
    public void merge(int[] arr){
/*        int[] oragin = arr, temp = new int[arr.length];
        for (int cap = 1; cap < oragin.length; cap *= 2) {
            for (int i = 0; i < oragin.length; ) {
                int next = i + cap + cap;
                merge(oragin, temp, i, i + cap, next);
                i = next;
            }
            int[] o = oragin;
            oragin = temp;
            temp = o;
        }
        System.arraycopy(oragin, 0, arr, 0, arr.length);*/

        int[] temp = new int[arr.length];

    }
    public void merge(int[] src, int[] target, int from, int left, int right) {
        left = Math.min(src.length, left);
        right = Math.min(src.length, right);
        int p1 = from, p2 = left, i = from;
        for (; p1 < left && p2 < right; i++) {
            if (src[p1] < src[p2]) {
                target[i] = src[p1];
                p1++;
            } else {
                target[i] = src[p2];
                p2++;
            }
        }
        for (; p1 < left; i++) {
            target[i] = src[p1];
            p1++;
        }
        for (; p2 < right; i++) {
            target[i] = src[p2];
            p2++;
        }
    }



}
