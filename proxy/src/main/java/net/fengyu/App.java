package net.fengyu;

import net.fengyu.proxy.Developer;
import net.fengyu.proxy.Farmerbrag;
import net.fengyu.proxy.JavaDeveloper;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Developer developer = new Farmerbrag(new JavaDeveloper("Farmerbrag"));
        developer.code();
        developer.debug();
    }
}
