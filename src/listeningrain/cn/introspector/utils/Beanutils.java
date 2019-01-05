package listeningrain.cn.introspector.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * User:        listeningrain
 * Date:        2018/10/30 17:27
 * Description:  重复造轮子系列之BeanUtils
 */
public class Beanutils {

    //将source中变量的值拷贝到target中（同名属性）
    public static void copyProperties (Object source, Object target){
        PropertyDescriptor target_propertyDescriptor = null;
        BeanInfo targetBeanInfo = null;
        try{
            //获取目标对象的对象信息
            targetBeanInfo = Introspector.getBeanInfo(target.getClass());
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            //获取源对象的对象信息
            BeanInfo beanInfo = Introspector.getBeanInfo(source.getClass());
            //从对象信息中获取所有属性的属性描述器
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            //遍历源对象的属性描述器
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors){
                //忽略存在的class属性
                if(!"class".equals(propertyDescriptor.getName())){

                    //获得source对象中属性的get方法
                    Method readMethod = propertyDescriptor.getReadMethod();
                    //获取source对象中的属性名
                    String key = propertyDescriptor.getName();
                    //通过反射调用get方法，获取source对象中的该属性的值
                    Object oldValue = readMethod.invoke(source);
                    //获取source对象属性的类型
                    String parameterName = propertyDescriptor.getPropertyType().getName();

                    System.out.println("在source对象中查询到属性："+key);

                    //获取target对象属性的属性描述器，即上面取到的key在目标对象中的属性描述器
                    target_propertyDescriptor = getPropertyDescriptor(target.getClass(),key);
                    if(null != target_propertyDescriptor){
                        //获取target对象属性的set方法
                        Method writeMethod = target_propertyDescriptor.getWriteMethod();
                        //获取target对象属性的类型
                        String name = target_propertyDescriptor.getPropertyType().getName();
                        //数据类型一致，则复制值
                        if(parameterName.equals(name)){
                            //调用set方法向target对象中设置值
                            System.out.println("开始为target设置值，设置的当前属性是"+key);
                            //通过反射调用set方法，设置对应的值
                            writeMethod.invoke(target,oldValue);
                            System.out.println("设置值成功");
                        }else{
                            System.out.println("源对象属性"+key+"的类型为"+parameterName+",目标对象属性类型为"+name+",类型不一致，将跳过该属性");
                        }
                    }else{
                        System.out.println("在target中没有查询到"+key+"的属性");
                    }
                    //System.out.println("---------操作完成-------");

                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

   private static Map<Class, Map<String, PropertyDescriptor>> cacheMap = null;

    private static Map<Class, Map<String, PropertyDescriptor>> createCacheMap (Class bean){
        Map<String, PropertyDescriptor> propertyDescriptorMap = new LinkedHashMap<>(10);
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(bean);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for(PropertyDescriptor propertyDescriptor : propertyDescriptors){
                if(!"class".equals(propertyDescriptor.getName())){
                    propertyDescriptorMap.put(propertyDescriptor.getName(),propertyDescriptor);
                }
            }
            if(null == cacheMap){
                cacheMap = new HashMap<>(50);
            }
            cacheMap.put(bean, propertyDescriptorMap);
        }catch (Exception e){
            e.printStackTrace();
        }
        return cacheMap;
    }

    //获取对应属性的属性描述器
    private static PropertyDescriptor getPropertyDescriptor(Class bean, String key){
        Map<Class, Map<String, PropertyDescriptor>> cacheMap = createCacheMap(bean);
        Map<String, PropertyDescriptor> propertyDescriptorMap = null;
        if(null != cacheMap && cacheMap.size()>0){
            propertyDescriptorMap = cacheMap.get(bean);
        }
        PropertyDescriptor propertyDescriptor = propertyDescriptorMap.get(key);
        if(null != propertyDescriptor){
            return propertyDescriptor;
        }
        return null;
    }
}
