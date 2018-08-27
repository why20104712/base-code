package com.example.java.lombok;

import lombok.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class LombokTest {

    public static void main(String[] args) throws IOException {

//        对于一个final变量，如果是基本数据类型的变量，则其数值一旦在初始化之后便不能更改；
        final int a = 1;
//        a = 2;
//        如果是引用类型的变量，则在对其初始化之后便不能再让其指向另一个对象，若对象的属性未被final修饰，则该对象的属性可以被赋值修改。
        final Object o = new Object();
//        o = new Object();
        final TestGetterSetter testGetterSetter = new TestGetterSetter();
        testGetterSetter.setAge(20);
        testGetterSetter.setAge(220);
        System.out.println(testGetterSetter.getAge());


        //val
        val example =new ArrayList<String>();
        example.add("HelloWorld");
        val foo = example.get(0);
        System.out.println(foo.toLowerCase());
        //val
        val map = new HashMap<Integer, String>();
        map.put(0, "zero");
        map.put(5, "five");
        for (val entry : map.entrySet()) {
            System.out.printf("%d: %s\n", entry.getKey(), entry.getValue());
        }


        new TestNull().println("test pass");
//        new TestNull().println(null);


//        OutputStream out = new FileOutputStream(new File("test.txt"));
//        try {
//            out.write("HelloWorld!".getBytes());
//        } finally {
//            if (out != null) {
//                out.close();
//            }
//        }

        // @Cleanup
        @Cleanup OutputStream out = new FileOutputStream(new File("test.txt"));
        out.write("HelloWorld!".getBytes());


//        val是final的，但是var就是正常的变量。
        val t = new TestGetterSetter();
        t.setAge(25);
        System.out.println(t.getAge());


        System.out.println(new ToStringExample());

        val o1 = new EqualsAndHashCodeExample("name1", 12, 15);
        val o2 = new EqualsAndHashCodeExample("name2", 12, 12);
        val o3 = new EqualsAndHashCodeExample("name1", 12, 16);
        System.out.println(o1.equals(o2));
        System.out.println(o2.equals(o3));
        System.out.println(o1.equals(o3));

    }
}


class TestNull{
    /**
     * if (str == null) {
     *       throw new NullPointerException("str");
     * }
     */
    public void println(@NonNull String str){
        System.out.println(str);
    }
}

//@Getter @Setter
class TestGetterSetter {

    @Getter
    @Setter
    private int age = 10;
}

//    includeFieldNames 是否显示字段名字
//    exclude 排除哪些字段
//    callSuper 是否将父类的成员加入到toString()
//    of 跟 exclude 相对应，显示的增加自己想要显示的字段
@ToString(exclude="id",includeFieldNames=false)
class ToStringExample {
    private static final int STATIC_VAR = 10;
    private String name = "名字";
    private String[] tags = {"1","2","3"};
    private Integer id = 1;
}

//EqualsAndHashCode
@EqualsAndHashCode(exclude={"id"})
class EqualsAndHashCodeExample {
    private String name;
    private int count;
    private int id;
    public EqualsAndHashCodeExample(String name, int count, int id) {
        this.name = name;
        this.count = count;
        this.id = id;
    }
}

//final修饰的类不能被继承
//　　在使用final修饰类的时候，要注意谨慎选择，除非这个类真的在以后不会用来继承或者出于安全的考虑，尽量不要将类设计为final类。
final class FinalClass{

}
//final修改的方法，不能被子类覆盖
//如果只有在想明确禁止 该方法在子类中被覆盖的情况下才将方法设置为final的
class FinalMethod{

    public final void fi(){
        System.out.println("final修改的方法，不能被子类覆盖");
    }
}




