package listeningrain.cn.introspector.utils;

import listeningrain.cn.introspector.model.Student;

import java.lang.reflect.Field;

/**
 * @Author: listeningrain
 * @Date: 2018-12-28 21:01
 * @Description: 使用反射实现对象间属性的复制
 */
public class ReflectUtils {

   public static void main(String[] args)throws Exception{
       Student soureStu = new Student();
       soureStu.setAge("1223");
       soureStu.setName("哈哈哈");
       Student targetStu = new Student();

       Class sourceClas = soureStu.getClass();
       Class targetClas = targetStu.getClass();

       //获取源对象的所有属性
       Field[] sourceFields = sourceClas.getDeclaredFields();

       System.out.println("targetStu复制前"+targetStu);

       for(Field field : sourceFields){
           if(!"class".equals(field.getName())){
               //获取源对象的属性值
               field.setAccessible(true);
               Object value =  field.get(soureStu);

               //获取对应的属性
               Field targetField = targetClas.getDeclaredField(field.getName());
               targetField.setAccessible(true);
               targetField.set(targetStu,value);
           }
       }

       System.out.println("targetStu复制后"+targetStu);
   }
}
