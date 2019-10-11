package net.fengyu;

import net.fengyu.util.MyClassLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class LoadClass {
    public static void main( String[] args ) throws Exception {
        //读取本地的class文件内的字节码，转换成字节码数组
        File file = new File(".");
        InputStream input = new FileInputStream(file.getCanonicalPath()+"/proxy/target/classes/net/fengyu/proxy/JavaDeveloper.class");
        byte[] result = new byte[1024];
        int count = input.read(result);
        // 使用自定义的类加载器将 byte字节码数组转换为对应的class对象
        MyClassLoader loader = new MyClassLoader();
        Class clazz = loader.defineMyClass(null, result, 0, count);
        //测试加载是否成功，打印class 对象的名称
        System.out.println(clazz.getCanonicalName());
        //构造函数带参数
        Constructor con=clazz.getConstructor(String.class);
        //实例化JavaDeveloper对象
        Object o = con.newInstance("Farmerbrag");
        try {
            //调用Programmer的code方法
            clazz.getMethod("code", null).invoke(o, null);
        } catch (IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }

    }
}
