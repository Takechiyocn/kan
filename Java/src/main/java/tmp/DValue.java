/**
 * @ Author zhangsf
 * @CreateTime 2019/9/20 - 8:10 PM
 */
package tmp;

import java.util.Arrays;
import java.util.Scanner;


//        2
//        4
//        5 9 4 7
//        8
//        9 13 18 10 12 4 18 3
public class DValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //代表测试用例个数
        int T = sc.nextInt();
        int n;
        int output[][]=new int [T][2];
        for (int i = 0; i < T; i++) {
            //每一个测试用例的长度
            n = sc.nextInt();
            int count[]= new int[n];
            sc.nextLine();
            for (int j = 0; j < n; j++) {
                count[j]=sc.nextInt();
            }
            binaryMiun(count);
        }
    }
    public static int[][]  binaryMiun(int[] Arrint){
        //遍历数组求元素的总和sum
        int sum = sumArr(Arrint);
        //mid 为元素总和的一半
        int mid = sum/2;
        int suml = 0;//第一个小数组元素总和
        int sumr = 0;//第二个小数组元素的总和
        int[] l = new int[Arrint.length] ;//第一个小数组
        int[] r =  new int[Arrint.length] ;//第二个小数组

        int lcount = 0;
        int rcount = 0;
        int n = Arrint.length;
        for(int h= 0; h < n;) {
            int min = mid - Arrint[0];
            int j = 0;
            //找出离mid最近的元素
            for(int i=0;i<n;i++){
                int temp = mid - Arrint[i];
                if(temp<=mid){
                    min = temp;
                    //距离mid最近的元素的下标
                    j = i;
                }
            }
            //将取出的元素放在元素总和较小的数组
            if(suml <= sumr){
                l[lcount++]  = Arrint[j];
                suml += Arrint[j];
            }else{
                r[rcount++]  = Arrint[j];
                sumr += Arrint[j];
            }
            //将刚刚在原数组取出的元素删除，更新原数组
           /* for(int k= j ;k<n;k++){
             Arrint[k] = Arrint[k+1];
            }*/
            Arrint = delAnyPosition(Arrint,j);
            n--;
        }
        int[][] lr = {Arrays.copyOf(l,lcount),Arrays.copyOf(r,rcount)};
        return lr;
    }

    public static int[] delAnyPosition(int[] arr,int position){
        //不合法
        if(position >= arr.length || position < 0){
            return null;
        }
        //
        int[] res = new int[arr.length - 1];

        for(int i = 0;i<res.length;i++){
            if(i < position){
                res[i] = arr[i];
            }else{
                res[i] = arr[i + 1];
            }
        }
        return res;
    }

    /**
     * 数组求和
     * @param arr
     * @return
     */
    public static int sumArr(int[] arr){
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
        }
        return sum;
    }

}