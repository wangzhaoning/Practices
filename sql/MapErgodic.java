package sql;
import java.util.*;
public class MapErgodic
 {
    public static void main(String[] args )
    {
        Map<String,String> map= new HashMap<>();
        map.put("1","value1");
        map.put("2","value2");
        map.put("3","value3");
        //普遍使用，二次取值
        for(String key:map.keySet())
        {
            System.out.println("第一种： "+key+" "+map.get(key));
        }
        //Secend
        Iterator<Map.Entry<String,String>>it =map.entrySet().iterator();
        while (it.hasNext())
        {
            Map.Entry<String,String> entry =it.next();
            System.out.println("第二种： "+entry.getKey()+" "+entry.getValue());
        }
        //Thrid
        for(Map.Entry<String,String>entry:map.entrySet())
        {
            System.out.println("第三种： "+entry.getKey()+" "+entry.getValue());
        }
        //第四种
        for(String v:map.values())
        {
            System.out.println(v);
        }
    }
}
