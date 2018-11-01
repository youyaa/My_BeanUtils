package listeningrain.cn.introspector.model;

/**
 * User:        sunqingfeng6
 * Date:        2018/10/30 17:37
 * Description:
 */
public class Circle {

    private  Integer X;
    private  Integer Y;
    private Integer Z;
    private Integer G;

    public Circle(Integer x, Integer y, Integer z, Integer g) {
        X = x;
        Y = y;
        Z = z;
        G = g;
    }

    public Integer getX() {
        return X;
    }

    public void setX(Integer x) {
        X = x;
    }

    public Integer getY() {
        return Y;
    }

    public void setY(Integer y) {
        Y = y;
    }

    public Integer getZ() {
        return Z;
    }

    public void setZ(Integer z) {
        Z = z;
    }

    public Integer getG() {
        return G;
    }

    public void setG(Integer g) {
        G = g;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "X=" + X +
                ", Y=" + Y +
                ", Z=" + Z +
                ", G=" + G +
                '}';
    }
}
