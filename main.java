/**
 * Created by jellyBananas on 2016/9/3.
 */
public class main {
    public static void main(String[] args) {
        Metro metro = new Metro();
        metro.calculate("大连北站","西安路");
        System.out.println(metro.price);
        metro.calculate("机场站", "中山广场");
        System.out.println(metro.price);
        metro.calculate("机场站","大连北站");
        System.out.println(metro.price);
    }
}
