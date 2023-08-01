package logic.designstructure.behavior.b1chainofresponsibility;

/**
 * @ClassName ProfessionalProgrammer
 * @Description
 * @Author moku
 * @Date 2022/12/24 18:02
 * @Version 1.0
 */
public class ProfessionalProgrammer extends Programmer {
    @Override
    void handle(Bug bug) {
        if (bug.value > 50 && bug.value <= 100) {
            solve(bug);
        } else if (next != null){
            next.handle(bug);
        } else {
            try {
                throw new Exception("未找到合适人选！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void solve(Bug bug) {
        System.out.println("资深程序员解决了一个难度为[" + bug.value + "]的bug");
    }
}
