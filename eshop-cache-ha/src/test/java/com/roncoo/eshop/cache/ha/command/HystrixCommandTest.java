package com.roncoo.eshop.cache.ha.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * Created by hadoop on 2017/12/10.
 */
public class HystrixCommandTest extends HystrixCommand<Long>{

    protected HystrixCommandTest(HystrixCommandGroupKey group) {
        super(group);
    }

    @Override
    protected Long run() throws Exception {
        return null;
    }

}
