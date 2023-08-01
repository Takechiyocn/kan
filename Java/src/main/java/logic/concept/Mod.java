package logic.concept;

/**
 * @ClassName Mod
 * @Description 取模取余：取模和取余在计算的目标上是一致的，只是商的不同，导致结果不同
 *              1. 被除数、除数同号：结果相同
 *              2. 被除数、除数不同号：结果不同
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
