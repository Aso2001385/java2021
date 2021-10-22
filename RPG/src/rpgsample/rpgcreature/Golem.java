package rpgsample.rpgcreature;
import java.util.Random;
/**
 * ゴーレムクラス
 */
public class Golem extends Monster{

    /**
     * スライムクラスのコンストラクタ
     */
    public Golem(){
        super("ゴーレム",100);
    }

    /**
     * 攻撃メソッド
     * @param opponent：攻撃相手
     */
    @Override
    public void attack(Creature opponent) {
        
        Random r = new Random();
        
        int damage = r.nextInt(10)+5;

        if(r.nextInt(100)<5){
            damage = 30;
        }
        
        System.out.printf("%sの攻撃！\n",getName());
        
        opponent.damaged(damage);
        
        displayMessage(opponent,damage);
        
    }
    
}
