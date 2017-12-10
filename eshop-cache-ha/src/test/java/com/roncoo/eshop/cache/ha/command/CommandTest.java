package com.roncoo.eshop.cache.ha.command;

import rx.Observable;
import rx.Observer;
/**
 * Created by hadoop on 2017/12/10.
 * 同步：new CommandHelloWorld("World").execute()，
 *      new ObservableCommandHelloWorld("World").toBlocking().toFuture().get()
 */
public class CommandTest {

    public static void main(String[] args) {
        new CommandHelloWorld("World").execute();
        Observable<String> fWorld = new CommandHelloWorld("World").observe();

        fWorld.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {

            }
            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }
            @Override
            public void onNext(String v) {
                System.out.println("onNext: " + v);
            }
        });

    }

}
