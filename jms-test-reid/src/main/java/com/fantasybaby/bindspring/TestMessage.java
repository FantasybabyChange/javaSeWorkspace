package com.fantasybaby.bindspring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by fanta on 2017-07-09.
 */
public class TestMessage {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        IMessageSender sender = ctx.getBean(IMessageSender.class);
        sender.sendMessage("Hello");
        /*IMessageReceive receive = ctx.getBean(IMessageReceive.class);
        receive.receiveMessage();*/
        ctx.close();
    }
}
