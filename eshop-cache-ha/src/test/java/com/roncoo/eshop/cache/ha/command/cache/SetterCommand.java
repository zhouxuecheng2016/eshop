package com.roncoo.eshop.cache.ha.command.cache;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * Created by hadoop on 2017/12/12.
 */
public class SetterCommand extends HystrixCommand<Void> {

    private final int id;
    private final String prefix;

    public SetterCommand(int id, String prefix) {
        super(HystrixCommandGroupKey.Factory.asKey("GetSetGet"));
        this.id = id;
        this.prefix = prefix;
    }

    @Override
    protected Void run() {
        // persist the value against the datastore
       String prefixStoredOnRemoteDataStore = prefix;
        // flush the cache
        GetterCommand.flushCache(id);
        // no return value
        return null;
    }

}
