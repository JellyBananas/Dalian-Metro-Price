import java.util.HashMap;
import java.util.Map;

/**
 * Created by jellyBananas on 2016/9/3.
 */
public class Metro {
    double sum;
    int price;
    Map<String, String> station = new HashMap<>();
    Map<String, String> station2 = new HashMap<>();
    public void calculate(String s, String f){
        initLineOne();
        initLineTwo();
        if ((station.get(s)!=null&station.get(f)!=null)||(station2.get(s)!=null&station2.get(f)!=null)||(station.get(f)!=null&station.get(s)!=null)||(station.get(f)!=null&station.get(s)!=null)){
            //不需要换成
            if (station.get(s)!=null){
                //一号线
                s = station.get(s);
                f = station.get(f);
                sum = money(s,f);
            }
            else if (station2.get(s)!=null){
                //二号线
                s = station2.get(s);
                f = station2.get(f);
                sum = money(s,f);
            }
        }else {
            //需要换乘
            if (station.get(s)!=null){
                //一号线换二号线
                s = station.get(s);
                double sum1 = money(s,"15.3");
                f = station2.get(f);
                double sum2 = money("10",f);
                sum = sum1 + sum2;
            }
            else if (station2.get(s)!=null){
                //二号线换一号线
                s = station2.get(s);
                double sum1 = money(s,"10");
                f = station.get(f);
                double sum2 = money("15.3",f);
                sum = sum1 + sum2;
            }
        }
//        System.out.println(sum);
        if (sum<=6.0){
//            System.out.println("2RMB");
            price = 2;
        }
        else if (sum>6.0&&sum<=12.0){
//            System.out.println("3RMB");
            price = 3;
        }
        else if (sum>12.0&&sum<=18.0){
//            System.out.println("4RMB");
            price = 4;
        }
        else if (sum>18.0&&sum<=26.0){
//            System.out.println("5RMB");
            price = 5;
        }
        else if (sum>26.0&&sum<=34.0){
//            System.out.println("6RMB");
            price = 6;
        }
//        遍历
//        for (Map.Entry<String,String> entry:station.entrySet()
//             ) {
//            System.out.println(entry);
//        }
    }
    public void initLineOne(){
        station.put("姚家","0");
        station.put("大连北站","1.6");
        station.put("华北路","2.9");
        station.put("华南北","4.1");
        station.put("华南广场","5.4");
        station.put("千山路","6.6");
        station.put("松江路","7.8");
        station.put("东纬路","9.2");
        station.put("春柳","11.9");
        station.put("香工街","12.5");
        station.put("中长街","13.5");
        station.put("兴工街","14.4");
        station.put("西安路","15.3");
        station.put("富国街","16.5");
        station.put("会展中心","17.2");
    }
    public void initLineTwo(){
        station2.put("机场站","0");
        station2.put("虹港路","0.8");
        station2.put("虹绵路","1.9");
        station2.put("红旗西路","4.2");
        station2.put("湾家","5");
        station2.put("马栏广场","6.2");
        station2.put("辽师","7.1");
        station2.put("交通大学","7.9");
        station2.put("西安路","10");
        station2.put("联合路","11.1");
        station2.put("人民广场","12.5");
        station2.put("一二九街","13.6");
        station2.put("青泥洼桥","14.5");
        station2.put("友好广场","15.2");
        station2.put("中山广场","15.8");
        station2.put("港湾广场","17.3");
        station2.put("会议中心","18.7");
    }
    public double money(String s, String f){
        double ss = Double.valueOf(s).doubleValue();
        double ff = Double.valueOf(f).doubleValue();
        double result = Math.abs(ss-ff);
        return result;
    }
}
