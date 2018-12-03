//package com.zq.learn.springlearn.hystrix;
//
//import com.netflix.hystrix.HystrixCommand;
//import com.netflix.hystrix.HystrixCommandGroupKey;
//import rx.Observable;
//
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.Future;
//
//public class CommandHelloWorld extends HystrixCommand<String> {
//
//    private String name;
//
//    protected CommandHelloWorld(String name) {
//        super(HystrixCommandGroupKey.Factory.asKey("ExamleGroup"));
//        this.name = name;
//    }
//
//    @Override
//    protected String run() throws Exception {
//        return "Hello " + name + "!";
//    }
//
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        String zq = new CommandHelloWorld("Zq").execute();
//        System.out.println(zq);
//
//        Future<String> future = new CommandHelloWorld("Cy").queue();
//        System.out.println(future.get());
//
//        Observable<String> cj = new CommandHelloWorld("Cj").observe();
//    }
//}
