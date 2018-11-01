package listeningrain.cn.introspector;

import listeningrain.cn.introspector.model.Circle;
import listeningrain.cn.introspector.model.Circle2;
import listeningrain.cn.introspector.utils.Beanutils;

/**
 * User:        sunqingfeng6
 * Date:        2018/9/27 11:00
 * Description: java 内省机制测试类
 */
public class IntrospectorTest {



    public static void main(String[] args) throws Exception{
        Circle circle = new Circle(12,13,14, 15);
        Circle2 circle2 = new Circle2();
        Beanutils.copyProperties(circle,circle2);
        System.out.println(circle2);

    }
/*
    private static void setProperty(IntrospectorTest it, String proName) throws Exception {
        PropertyDescriptor proDescriptor = new PropertyDescriptor(proName, IntrospectorTest.class);
        Method methodSetX = proDescriptor.getWriteMethod();
        methodSetX.invoke(it, 8);
        System.out.println(it.getX());// 8
    }

    private static void getProperty(IntrospectorTest it, String proName) throws Exception {
        PropertyDescriptor proDescriptor = new PropertyDescriptor(proName, IntrospectorTest.class);
        Method methodGetX = proDescriptor.getReadMethod();
        Object objx = methodGetX.invoke(it);
        System.out.println(objx);// 2
    }

    private static void getProperty2(IntrospectorTest it, String proName) throws Exception {
        BeanInfo beanInfo = Introspector.getBeanInfo(it.getClass());
        PropertyDescriptor[] proDescriptors = beanInfo.getPropertyDescriptors();
        for(PropertyDescriptor prop: proDescriptors){
                Method methodGetx = prop.getReadMethod();
                System.out.println(methodGetx.invoke(it));//8
        }
    }*/
}
