package com.example.dynamicproxy.cglib;

public class UserServiceImpl {

    public void add() {
        System.out.println("This is add cglib");
    }
    public void delete(int id) {
        System.out.println("This is delete cglib：delete " + id );
    }
}