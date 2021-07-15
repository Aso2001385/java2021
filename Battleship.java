package Final_0serise;
import java.util.*;
public class Battleship {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        boolean endFlg = false; 
        Ship ship1 = new Ship("α号");
        Ship ship2 = new Ship("β号");
        Ship ship3 = new Ship("γ号");

        for(int i=1; !endFlg && i<50; i++){
            System.out.println("---------["+i+"ターン目]---------");
            ship1.showLife();
            ship2.showLife();
            ship3.showLife();
            System.out.println("X軸を入力してください(1-5)");
            int x = sc.nextInt()-1;
            System.out.println("Y軸を入力してください(1-5)");
            int y = sc.nextInt()-1;
            System.out.println(" - - 爆撃を開始します - - ");
            int bom = (x*10)+y;
            ship1.doa(bom);
            ship2.doa(bom);
            ship3.doa(bom);
            endFlg = (!ship1.life && !ship2.life && !ship3.life);
        }

        if(endFlg){
            System.out.println("------標的の全滅を確認しました------");
            System.out.println("------------ 戦闘 終了 -------------");
        }else{
            System.out.println("-----時間内の残滅に失敗しました-----");
            System.out.println("------------ 戦闘 終了 -------------");
        }

        sc.close();

    }
}