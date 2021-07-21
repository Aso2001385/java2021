package Final_0serise;
import java.util.*;
public class Battleship {
    public static void main(String[] args) {
        
        /* 初期設定 */
        Scanner sc = new Scanner(System.in);
        boolean endFlg = false;         // ループ用フラグ(残存艦数判断)
        Ship ship1 = new Ship("α号");   // Shipクラスのインスタンス生成(戦艦名設定)
        Ship ship2 = new Ship("β号");
        Ship ship3 = new Ship("γ号");

        /* ゲームタイトル出力 */
        System.out.println(": -- -- -- -- -- -- -- -- -- -- :");
        System.out.println(": -- -- One-sided BOMBING -- -- :");
        System.out.println(": -- -- -- -- -- -- -- -- -- -- :");

        /* ゲームループ(ターン制) */
        for(int i=1; !endFlg && i<50; i++){

            /* ターン開始時出力 */
            if(i<10){
                System.out.println(": -- -- --   "+i+"th turn  -- -- -- :"); // ターン数出力(一桁)
            }else{
                System.out.println(": -- -- --  "+i+"th turn  -- -- -- :"); // ターン数出力(二桁)
            }
            
            ship1.showLife(); // 残りhp,生存情報出力
            ship2.showLife();
            ship3.showLife();

            /* 爆撃地点設定 */
            System.out.println("X軸を入力してください(1-5)"); // X軸入力
            int x = sc.nextInt();

            /* X軸が指定の数値を超過した場合、もしくは指定の数値未満の場合 */
            while(x < 1 || x > 5){
                
                System.out.println("入力内容が間違っています！１から５の数字を入力してください！"); // 警告文出力
                System.out.println("X軸を入力してください(1-5)"); // X軸再入力
                x = sc.nextInt();
            
            }

            System.out.println("Y軸を入力してください(1-5)"); // Y軸入力
            int y = sc.nextInt();

            /* Y軸が指定の数値を超過した場合、もしくは指定の数値未満の場合 */
            while(y < 1 || y > 5){
                System.out.println("入力内容が間違っています！１から５の数字を入力してください！"); // 警告文出力
                System.out.println("Y軸を入力してください(1-5)"); // Y軸再入力
                y = sc.nextInt();
            }
            
            /* 爆撃処理 */
            System.out.println(" - - 爆撃を開始します - - "); // 爆撃合図
            int bom = (x*10)+y; // 爆撃地点の座標コード生成(X軸を10倍にしてY軸を足した二桁のコード)

            ship1.doa(bom); // 爆撃座標コードと戦艦座標コードの位置関係照合及びステータス更新
            ship2.doa(bom);
            ship3.doa(bom);

            endFlg = (Ship.shipHp == 0); // 全艦沈没でtrue

        }

        /* 戦艦全滅 or 50ターン経過後出力処理 */

        if(endFlg){
            System.out.println("------標的の全滅を確認しました------"); // 全滅パターン(勝利)
            System.out.println("------------ 戦闘 終了 -------------");
        }else{
            System.out.println("-----時間内の全滅に失敗しました-----"); // 生存パターン(敗北)
            System.out.println("------------ 戦闘 終了 -------------");
        }

        sc.close();

    }
}