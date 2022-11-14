package tmp;

import java.util.Scanner;

public class OpenLamp {
    public static void main(String[] args) {
        // n表示共有n盏灯
        int n, i, j;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[] number = new int[n + 10];
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n; j++) {
                //判断灯编号为人数的倍数
                if (i % j == 0) {
                    //如果灯是关着的,那么打开
                    if (number[i] == 0) {
                        number[i] = 1;
                    } else {
                        //如果灯是开着的,那么关闭
                        number[i] = 0;
                    }
                }
            }
        }
        for (i = 1; i <= n; i++) {
            //判断如果灯开着,那么输出所在的灯的编号
            if (number[i] == 1) {
                System.out.print(" " + i);
            }
        }
    }
}