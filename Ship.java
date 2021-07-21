package Final_0serise;
import java.util.Random;
public class Ship {

    /* クラス変数(残機) */
    public static int shipHp = 3;// 残存艦数

    /* メンバ変数(戦艦ステータス) */
    public int code = move();    // 座標コード生成
    public int hp = 3;           // 体力(耐久力)設定
    public String name;          // 名称

    /* コンストラクタ(戦艦名設定) */
    Ship(String name){
        this.name = name;
    }

    /* 爆撃座標コード・戦艦座標コード照合及び戦艦ステータス更新(引数:爆撃座標コード) */
    public void doa(int bom){
        
        if(this.hp > 0){ // 生存時のみ
    
            /* 命中時処理 */
            if(bom == this.code){ // 爆撃地点に自分がいるかどうか
                this.hp--;        // 体力減少
                if(this.hp > 0){  // 生存判定

                    /* 生存時処理 */
                    System.out.println(this.name+"：被弾したため移動する！");
                    this.code = move(); // 座標コード再生成(移動)

                    return;

                }else{

                    /* 撃沈時処理 */
                    System.out.println(this.name+"：被弾！致命的な損傷！");
                    Ship.shipHp--; // 残存艦数減少

                    return;

                }
                
            }

            /* 外れた場合の処理 */
            if( code == bom-10 || code == bom+10 ){     // X座標前後照合   
                System.out.println(this.name+"：波高し！");
            }else if(code == bom-1 || code == bom+1){   // Y座標左右照合
                System.out.println(this.name+"：波高し！");
            }else{
                System.out.println(this.name+"：危険なし！");
            }
        }
    }

    /* 生存状況及び残存体力(耐久力)出力処理 */
    public void showLife(){

        if(this.hp > 0){

            /* 生存時処理 */
            System.out.println(this.name+"：生存！残存耐久力"+this.hp+"！");

        }else{

            if(this.hp-- == 0){

                /* 沈没時処理 */
                System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
                System.out.println(this.name+"の船員A：誰か助けてくれ！このままじゃ沈没しちまうよ！");
                System.out.println(this.name+"の船員B：うわあああああああああああ！！！");
                System.out.println(this.name+"の船員C：おいＤ・・・おい・・・！起きろよＤ・・・！Ｄーーー！！");
                System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");

            }else{

                /* 沈没後処理 */
                System.out.println(this.name+"：・・・(完全に沈没したようだ)");
            }
            
        }
    }

    /* 座標コード生成処理 */
    public int move(){
        
        /* ランダムな二桁の数値(各桁1-5まで)生成 */
        Random ron = new Random();
        int code = ((ron.nextInt(4)+1)*10)+ron.nextInt(4)+1;

        /* 生成したコードが現在のコードだった場合再生成 */
        while(code == this.code){
            code = ((ron.nextInt(4)+1)*10)+ron.nextInt(4)+1;
        }

        return code;

    }
    
}
