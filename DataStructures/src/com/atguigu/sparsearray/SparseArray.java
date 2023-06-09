package com.atguigu.sparsearray;

/**
 * 稀疏数据
 *
 * @author zdhstart
 * @date 2022-08-2910:26
 */
public class SparseArray {
    //创建一个原始的二维数据11*11
    //0:表示没有棋子，1表示黑子 2表示白子
    public static void main(String[] args) {
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 2;
        //输出原始的二维数据
        System.out.println("原始的二维数据～～");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        //将二维数据 转 稀疏数组
        //1. 先遍历二维数据 得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }

        }

        //2.创建对应的稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        //遍历二维数组，将非0的值存放到sparseArr中
        int count = 0; //count用于记录是第几个非0数据
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        //输出稀疏数组的形式
        System.out.println();
        System.out.println("得到的稀疏数组为：");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);

        }
        System.out.println();

        //将稀疏数组 --》 恢复成 原始的二维数据
        /**
         * 1.先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数据，比如上面的 chessArr2 = int[11][11]
         * 2.在读取稀疏数组后的几行，并赋给 原始的二维数据 即可。
         */

        //1.先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数据，比如上面的 chessArr2 = int[11][11]

        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];

        //2.在读取稀疏数组后的几行(从第二行开始)，并赋给 原始的二维数据 即可。
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        //输出恢复后的二维数据
        System.out.println();
        System.out.println("恢复后的二维数据");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

    }

}

