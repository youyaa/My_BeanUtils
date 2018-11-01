package listeningrain.cn.introspector.model;

/**
 * User:        sunqingfeng6
 * Date:        2018/10/30 18:35
 * Description:
 */
public class Circle2 {

    private  Integer X;
    private  Integer Y;
    private Integer A;
    private Integer G;


    public Integer getG() {
        return G;
    }

    public void setG(Integer g) {
        G = g;
    }

    public  Integer getX() {
        return X;
    }

    public  void setX(Integer x) {
        X = x;
    }

    public Integer getY() {
        return Y;
    }

    public void setY(Integer y) {
        Y = y;
    }

    public Integer getA() {
        return A;
    }

    public void setA(Integer a) {
        A = a;
    }

    @Override
    public String toString() {
        return "Circle2{" +
                "X=" + X +
                ", Y=" + Y +
                ", A=" + A +
                ", G=" + G +
                '}';
    }
}
