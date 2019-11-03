package main;

import ctrl.CasherWorkController;

public class Main {
    public static int dummy = 0;

    public static void main(String[] args) {
        CasherWorkController casherWorkController = new CasherWorkController();

        //メイン処理は起点となるコントローラーを呼び出すだけにする。
        //業務的な処理は組み込まない。
        casherWorkController.execute();
        System.out.println();
        dummy++;

        casherWorkController.execute();
        System.out.println();
        dummy++;

        casherWorkController.execute();
        System.out.println();
        dummy++;

    }

}
