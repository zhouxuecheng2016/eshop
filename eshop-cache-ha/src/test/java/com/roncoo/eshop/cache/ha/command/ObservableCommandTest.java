package com.roncoo.eshop.cache.ha.command;

import com.netflix.hystrix.HystrixObservableCommand;
import rx.Observable;
import rx.Observer;

/**
 * Created by hadoop on 2017/12/10.
 */
public class ObservableCommandTest {

    public static void main(String[] args) {
        HystrixObservableCommand<String> observableCommand = new ObservableCommandHelloWorld("World");
        Observable<String> fWorld = observableCommand.observe();
        //Observable<String> fWorld = observableCommand.toObservable();
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
