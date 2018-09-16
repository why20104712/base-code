package com.example.java.nio;


import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * nio中buffer用了存储数据的
 *
 */
public class BufferTest {


    @Test
    public void test() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        System.out.println("================allocate()===================");
        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());


        System.out.println("================put()===================");
        buffer.put("abcde".getBytes());
        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());


        System.out.println("================flip()===================");
        buffer.flip();
        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());


        System.out.println("================get()===================");
        buffer.get();
        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());


    }

}
