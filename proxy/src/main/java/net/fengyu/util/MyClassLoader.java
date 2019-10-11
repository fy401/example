package net.fengyu.util;

public class MyClassLoader extends ClassLoader {

    public Class<?> defineMyClass( String name, byte[] b, int off, int len)
    {
        return super.defineClass(name, b, off, len);
    }
}
