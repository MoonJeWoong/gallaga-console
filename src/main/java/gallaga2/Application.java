package gallaga2;

import gallaga2.controller.Controller;

/**
 * 갤러그 프로그램
 */
public class Application {

    /**
     * 갤러그 프로그램 시작 메인 함수
     * @param args
     */
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.run();
    }
}
