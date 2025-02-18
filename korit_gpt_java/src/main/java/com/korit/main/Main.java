package com.korit.main;

import com.korit.controller.UserController;
import com.korit.service.UserServiceImpl;
import com.korit.service.UserServiceImpl2;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        UserServiceImpl2 userService2 = new UserServiceImpl2();
        UserController userController = new UserController(userService);

        System.out.println("asdasdadasda");
        userController.signUp();
        userController.signIn();
        userController.setUserService(userService2);
    }
}
