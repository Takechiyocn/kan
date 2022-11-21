package concept;

/**
 * @ClassName Mod
 * @Description 取模取余
 * @Author moku
 * @Date 2022/11/22 1:56
 * @Version 1.0
 */
public class Mod {

    public static void main(String[] args) {
        // 1
        System.out.println("-7,4取模=" +Math.floorMod(-7,4));
        // -3
        System.out.println("-7,4取余=" +-7%4);
        // -1
        System.out.println("7,-4取模=" +Math.floorMod(7,-4));
        // 3
        System.out.println("7,-4取余=" +7%-4);
        // 3
        System.out.println("7,4取模=" +Math.floorMod(7,4));
        // -3
        System.out.println("-7,-4取余=" +-7%-4);
    }
}
