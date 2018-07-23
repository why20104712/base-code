package com.example.java.lamada;


/**
 * java8新增接口默认方法和静态方法
 */
public interface DefalutMethodInterface {


    /**

     接口默认方法的”类优先”原则

     若一个接口中定义了一个默认方法，而另外一个父类或接口中 又定义了一个同名的方法时

      选择父类中的方法。如果一个父类提供了具体的实现，那么 接口中具有相同名称和参数的默认方法会被忽略。

      接口冲突。如果一个父接口提供一个默认方法，而另一个接 口也提供了一个具有相同名称和参数列表的方法（不管方法 是否是默认方法），那么必须覆盖该方法来解决冲突

     */
    /**
     * 接口默认方法（类优先原则）
     * @return
     */
    default String defaultMethod() {
        return "default method";
    }

    /**
     * 静态方法
     * @return
     */
    static String staticMethod() {
        return "static method";
    }


    default String defaultMethod2() {
        System.out.println("接口中可以有多个默认方法");
        return "接口中可以有多个默认方法";
    }


    static String staticMethod2() {
        return "接口中可以有多个静态方法";
    }
}
