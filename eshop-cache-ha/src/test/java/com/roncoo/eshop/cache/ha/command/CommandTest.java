package com.roncoo.eshop.cache.ha.command;

import rx.Observable;
import rx.Observer;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by hadoop on 2017/12/10.
 * 同步：new CommandHelloWorld("World").execute()，
 * new ObservableCommandHelloWorld("World").toBlocking().toFuture().get()
 */
public class CommandTest {

    public static void main(String[] args) {
//        new CommandHelloWorld("World").execute();
//        //Observable<String> fWorld = new CommandHelloWorld("World").observe();
//        Observable<String> fWorld = new CommandHelloWorld("World").observe();
//        fWorld.subscribe(new Observer<String>() {
//            @Override
//            public void onCompleted() {
//
//            }
//            @Override
//            public void onError(Throwable e) {
//                e.printStackTrace();
//            }
//            @Override
//            public void onNext(String v) {
//                System.out.println("onNext: " + v);
//            }
//        });

        String result = new CommandHelloWorld("World").execute();
        System.out.println("onNext: " + result);
        Future<String> future = new CommandHelloWorld("Future World").queue();
        try {
            result = future.get(1, TimeUnit.SECONDS);
            System.out.println("onNext: " + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        Observable<String> fWorld = new CommandHelloWorld("Observer World").observe();

        fWorld.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                System.out.println("complete");
            }
            @Override
            public void onError(Throwable e) {

            }
            @Override
            public void onNext(String s) {
                System.out.println("onNext: " + s);
            }
        });

        Observable<String> observable=new CommandHelloWorld("Observable World").toObservable();
        observable.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext: " + s);
            }
        });

    }

}
