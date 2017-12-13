package com.roncoo.eshop.cache.ha.command.fallback;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by hadoop on 2017/12/13.
 */
public class CommandHelloFailureTest {


    public static void main(String[] args) {
       String result = new CommandHelloFailure("World").execute();
       System.out.println(result);
    }

}
