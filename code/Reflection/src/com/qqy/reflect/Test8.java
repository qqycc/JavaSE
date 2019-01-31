package com.qqy.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 利用反射，调用一次set，给所有属性赋值
 * emp.name:张三|emp.age：18
 * Author:qqy
 */
public class Test8 {
    public static void main(String[] args) {
        String value = "emp.name：张三|emp.job：老师";
        EmpAction empAction = new EmpAction();
        empAction.setValue(value);
        System.out.println(empAction.getEmp());
    }
}

class Emp {
    private String name;
    private String job;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}

class EmpAction {
    private Emp emp = new Emp();

    public void setValue(String value) {
        BeanOperation.setBeanValue(this, value);
    }

    public Emp getEmp() {
        return emp;
    }
}

class BeanOperation {
    private BeanOperation() {

    }

    /**
     * 取得真实操作的类对象
     *
     * @param actionObject xxAction对象
     * @param value        emp.name：张三|emp.job：老师
     */
    public static void setBeanValue(Object actionObject, String value) {
        //1.字符串拆分
        String[] temp = value.split("\\|");
        for (int i = 0; i < temp.length; i++) {
            String[] result = temp[i].split("：");
            //取得真实设置的内容
            String realValue = result[1];
            //取得真实类名称
            String realClassName = result[0].split("\\.")[0];
            //取得要设置的属性名称
            String attrName = result[0].split("\\.")[1];

            //通过反射取得xxAction中的真实对象
            //取得了emp对象
            Object realObj = getRealObject(actionObject, realClassName);

            //取得真实类（Emp）class对象
            Class<?> classz=realObj.getClass();
            //获得setEmp方法名
            String setName="set"+initCap(attrName);
            try {
                Method setMethod=classz.getDeclaredMethod(setName,String.class);
                setMethod.invoke(realObj,realValue);
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private static Object getRealObject(Object actionObj, String realClassName) {
        //取得action对象的class对象
        Class<?> classz = actionObj.getClass();
        //获得getEmp方法名
        String methodName = "get" + initCap(realClassName);
        Object realObj = null;
        //取得Method对象
        try {
            //取得getEmp的Method对象
            Method method = classz.getDeclaredMethod(methodName);
            //相当于调用了empAction.getEmp();
            realObj = method.invoke(actionObj);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return realObj;
    }

    //首字母大写
    private static String initCap(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
