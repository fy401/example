package net.fengyu.serialize;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<DataModule> list = new ArrayList<DataModule>();

        for(int i=0;i<3;i++) {
            DataModule dataModule = new DataModule();
            dataModule.setId(i);
            dataModule.setName("hehe"+i);
            list.add(dataModule);
        }


        String jsonStr = JSONObject.toJSONString(list);

        System.out.println(jsonStr);
        TypeReference<List<DataModule>> list2 = new TypeReference<List<DataModule>>() {};
//        JSONObject.parseObject()
        List<DataModule> l2 = JSONObject.parseObject(jsonStr,list2.getType());

        l2.forEach(e -> {
            System.out.println(e.getId()+ "   " +e.getName());
        });
        //System.out.println(l2.get(0).getName());

    }
}
