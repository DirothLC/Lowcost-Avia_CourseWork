package kz.kstu.kutsinas.utils;

import java.util.List;

public class Reporter {
   public static void print(List<?> list){
       for(int i=0;i<list.size();i++){
           System.out.println(list.get(i));
       }
   }
}
