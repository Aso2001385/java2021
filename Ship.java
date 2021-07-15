package Final_0serise;
import java.util.Random;
public class Ship {
    public int code = move();
    public int hp = 3;
    public String name;
    public boolean life = true;

    Ship(String name){
        this.name = name;
    }

    public void doa(int bom){

        if(this.life){
    
            if(bom == this.code){
                this.hp--;
                if(this.hp>0){
                    System.out.println(this.name+"：被弾したため移動する！");
                    this.code = move();
                    return;
                }else{
                    System.out.println(this.name+"：被弾！致命的な損傷！");
                    this.life = false;
                    return;
                }
                
            }

            if(code == bom-1 || code == bom+1){
                System.out.println(this.name+"：波高し！");
            }else if(code == bom-10 || code == bom+10){
                System.out.println(this.name+"：波高し！");
            }else{
                System.out.println(this.name+"：危険なし！");
            }
        }
    }

    public void showLife(){

        if(this.life){
            System.out.println(this.name+"：生存！残存耐久力"+this.hp+"！");
        }else{
            if(this.hp == 0){
                System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
                System.out.println(this.name+"の船員A：誰か助けてくれ！このままじゃ沈没しちまうよ！");
                System.out.println(this.name+"の船員B：うわあああああああああああ！！！");
                System.out.println(this.name+"の船員C：おいD・・・おい・・・！目・・・開けてくれよ・・・！！");
                System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
                hp--;
            }else{
                System.out.println(this.name+"：・・・(完全に沈没したようだ)");
            }
            
        }
    }

    public int move(){
        Random ron = new Random();
        int code = ((ron.nextInt(4))*10)+ron.nextInt(4);
        while(code == this.code){
            code = ((ron.nextInt(4))*10)+ron.nextInt(4);
        }
        return code;
    }
    
}
