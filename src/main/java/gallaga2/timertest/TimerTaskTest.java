package gallaga2.timertest;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTaskTest {

    private Timer timer;
    private TimerTask timerTask;

    public TimerTaskTest() {
        this.timer = new Timer();
        this.timerTask = new TimerTask() {
            @Override
            public void run() {
                printTimerTask();
            }
        };
        timer.schedule(timerTask, 0 ,2000);
    }

    private void printTimerTask() {
        System.out.println("printTimerTask");
    }

    public static void main(String[] args) {
        new TimerTaskTest();
        Scanner sc = new Scanner(System.in);
        while (true) {
            String input = sc.nextLine();
            System.out.println("입력된 값 : " + input);
        }
    }
}
