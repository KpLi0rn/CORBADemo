package CORBA;

import CORBA.HelloApp.HelloPOA;

/**
 * servant side 的实现
 */
public class HelloImpl extends HelloPOA {
    @Override
    public String sayHello() {
        return "Hello, world!";
    }
}