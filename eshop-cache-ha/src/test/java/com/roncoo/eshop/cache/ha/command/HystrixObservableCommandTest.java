package com.roncoo.eshop.cache.ha.command;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import rx.Observable;


/**
 * Created by hadoop on 2017/12/10.
 */
public class HystrixObservableCommandTest extends HystrixObservableCommand {

    protected HystrixObservableCommandTest(HystrixCommandGroupKey group) {
        super(group);
    }

    @Override
    protected Observable construct() {
        return null;
    }

}