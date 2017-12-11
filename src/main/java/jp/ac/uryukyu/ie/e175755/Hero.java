package jp.ac.uryukyu.ie.e175755;

/**
 * ヒーロークラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Hero extends LivingThing{
    int critical;
    /*String name;
    int hitPoint;
    int attack;
    boolean dead;

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name ヒーロー名
     * @param maximumHP ヒーローのHP
     * @param attack ヒーローの攻撃力
     */

    public Hero (String name, int maximumHP, int attack) {
        super(name,maximumHP,attack);
    }
    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     *
     */

    public void attack(LivingThing opponent) {
        int damage = (int) (Math.random() * opponent.getAttack());
        int critical = (int) (Math.random() * 10);
        if (isDead() != true) {
            if (damage==0){
                System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した！\n", getName(), opponent.getName(), damage);

            }else if(critical <= 4){
                System.out.printf("%sの攻撃！会心の一撃！！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage*2);
                opponent.wounded(damage*2);
            }
            else{
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
            opponent.wounded(damage);
            }
        }
    }

    public void wounded(int damage){
        String name = getName();
        setHitPoint(getHitPoint() - damage);
        if( getHitPoint() < 0 ) {
            setDead(true);
            System.out.printf("%sは道半ばで力尽きてしまった。\n", name);
        }
    }
}