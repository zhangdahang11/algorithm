package com.atguigu.sparsearray;

/**
 * ClassName: SparseArray1
 * Package: com.atguigu.sparsearray
 * Description:
 *
 * @Author zdhstart
 * @Create 2022/11/25 20:55
 * @Version 1.0
 */
public class SparseArrayTwo {
    public static void main(String[] args) {
        int[][] arr = new int[11][11];
        arr[1][2] = 1;
        arr[2][3] = 2;
        arr[4][5] = 2;
        /*for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }*/
        System.out.println("原始的二维数组");
        for (int[] row :
                arr) {
            for (int data :
                    row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    sum++;
                }
            }
        }
        //2.创建对应的稀疏数组
        int[][] arr1 = new int[sum + 1][3];
        //给稀疏数组赋值
        arr1[0][0] = 11;
        arr1[0][1] = 11;
        arr1[0][2] = sum;

        int count = 0;
        //遍历二维数组
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    count++;
                    arr1[count][0] = i;
                    arr1[count][1] = j;
                    arr1[count][2] = arr[i][j];
                }
            }
        }

        //输出稀疏数组
        System.out.println();
        System.out.println("得到的稀疏数组为～～～");
        for (int i = 0; i < arr1.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", arr1[i][0], arr1[i][1], arr1[i][2]);
        }
        System.out.println();

        System.out.println("二维");
        //变会二维数组
        int[][] arr2 = new int[arr1[0][0]][arr1[0][1]];

        for (int i = 1; i < arr1.length; i++) {
            arr2[arr1[i][0]][arr1[i][1]] = arr1[i][2];
        }

        for (int[] row :
                arr2) {
            for (int data :
                    row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

    }
}
