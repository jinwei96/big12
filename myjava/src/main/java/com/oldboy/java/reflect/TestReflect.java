package com.oldboy.java.reflect;

import org.junit.Test;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class TestReflect {

    @Test
    public void testCopy() throws Exception {
        JiafeiCat c1 = new JiafeiCat();
        c1.setColor("black");
        c1.setName("kk");
        JiafeiCat c2 = new JiafeiCat();
        copyPropertiesInMethod(c1 , c2);
        System.out.println(c2.getName() + c2.getColor());
    }


    /**
     * 实现两只猫属性的复制
     */
    private static void copyPropertiesInMethod(JiafeiCat c1 , JiafeiCat c2) throws Exception{
        Class clazz = JiafeiCat.class;
        Method[] ms = clazz.getMethods();
        for (Method m :ms){
            //得到方法名
            String mName = m.getName();
            //得到返回值
            Class retType = m.getReturnType();
            //得到参数类型
            Class[] types = m.getParameterTypes();

            //提取标准的javabean方法
            if (mName.startsWith("get") && (types.length == 0 ||types == null)){
                m.setAccessible(true);
                Object retValue = m.invoke(c1);
                String setter = mName.replace("get", "set");
                try {
                    Method setMethod = c2.getClass().getMethod(setter, retType);
                    setMethod.setAccessible(true);
                    setMethod.invoke(c2,retValue);
                } catch (Exception e) {
                    System.out.println(setter + " : " + e.getMessage());}

            }
        }

    }


    /**
     * 使用内省实现复制，专用于javabean
     */
    private static void copyPropertiesInIntrospector(JiafeiCat c1, JiafeiCat c2) throws Exception{

        //bean信息
        BeanInfo info = Introspector.getBeanInfo(c1.getClass());
        PropertyDescriptor[] pps = info.getPropertyDescriptors();
        for(PropertyDescriptor pp : pps){
            Method getter = pp.getReadMethod();
            Method setter = pp.getWriteMethod() ;
            if(getter != null){
                Class retType = getter.getReturnType();
                Object retValue = getter.invoke(c1 ) ;
                if(setter != null ){
                    setter.invoke(c2 , retValue) ;
                }
            }
        }

    }



    /**
     * 使用内省实现任意两个对象的属性复制
     * 只要返回值类型和参数相同即可。
     */
    private static void copyPropertiesInIntrospector1(Object src , Object dest) throws Exception {
        //原对象的beaninfo
        BeanInfo srcBI = Introspector.getBeanInfo(src.getClass());
        //目标对象的beaninfo
        BeanInfo destBi = Introspector.getBeanInfo(dest.getClass());

        PropertyDescriptor[] srcPPs = srcBI.getPropertyDescriptors();
        for (PropertyDescriptor pp : srcPPs) {
            String ppname = pp.getName();
            Method getMethod = pp.getReadMethod();
            if (getMethod == null){
                continue;
            }
            Class retType = getMethod.getReturnType();
            PropertyDescriptor[] destPPs = destBi.getPropertyDescriptors();
            for (PropertyDescriptor destPP : destPPs){
                String destPPName = destPP.getName();
                Method setMethod = destPP.getWriteMethod();
                if (setMethod == null){
                    continue;
                }
                Class[] types = setMethod.getParameterTypes();
                if (destPPName.equals(ppname)
                        && setMethod != null
                        && (types != null && types[0] == retType && types.length == 1 )){
                    getMethod.setAccessible(true);
                    Object retValue = getMethod.invoke(src);
                    setMethod.setAccessible(true);
                    setMethod.invoke(dest,retValue);
                }
            }


        }


    }

}
