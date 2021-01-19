package cn.jvtd.netty.demo.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda {

    Comparator<Integer> co = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(o1,o1);
        }
    };

    Comparator<Integer>  co2 = (x,y)->Integer.compare(x,y);

    public List<Integer> test(){
        List<Integer>  list = new ArrayList<>(10);
        list.add(11);
        list.add(112);
        list.add(113);
        list.add(114);
        list.add(115);
        list.add(116);
        List<Integer> list2 = new ArrayList<>(10);
        for(Integer listOne:list){
            if(listOne%3==0){
                list2.add(listOne);
            }
        }
        return list2;
    }

    public List<Integer> testL(){
        List<Integer>  list = new ArrayList<>(10);
        list.add(11);
        list.add(112);
        list.add(113);
        list.add(114);
        list.add(115);
        list.add(116);
        List<Integer> list2 = list.stream().filter((x)->x%3==1).collect(Collectors.toList());

        return list2;
    }


}
