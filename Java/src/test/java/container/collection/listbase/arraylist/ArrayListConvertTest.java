package container.collection.listbase.arraylist;

import logic.container.collection.listbase.arraylist.ArrayConvert;

public class ArrayListConvertTest {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};
        ArrayConvert cvt = new ArrayConvert();
        cvt.arrayListConvert(arr);

        System.out.print("array[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.println(arr[i] + "]");
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
    }
}
