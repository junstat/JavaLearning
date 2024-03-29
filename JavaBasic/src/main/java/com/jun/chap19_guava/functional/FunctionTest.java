package com.jun.chap19_guava.functional;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Preconditions;

import java.io.IOException;
import java.net.ServerSocket;

public class FunctionTest {
    public static void main(String[] args) throws IOException {
        Function<String, Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String input) {
                Preconditions.checkNotNull(input, "The input Stream should not be null.");
                return input.length();
            }
        };
        System.out.println(function.apply("Hello"));

        process("hello", new Handler.LengthDoubleHandler());

        System.out.println(Functions.toStringFunction().apply(new ServerSocket(8888)));
        Function<String, Double> compose = Functions.compose(new Function<Integer, Double>() {

            @Override
            public Double apply(Integer input) {
                return input * 1.0D;
            }
        }, new Function<String, Integer>() {
            @Override
            public Integer apply(String input) {
                return input.length();
            }
        });
        System.out.println(compose.apply("Hello"));
    }

    interface Handler<IN, OUT> {
        OUT handle(IN input);

        class LengthDoubleHandler implements Handler<String, Integer> {

            @Override
            public Integer handle(String input) {
                return input.length() * 2;
            }
        }
    }

    private static void process(String text, Handler<String, Integer> handler) {
        System.out.println(handler.handle(text));
    }
}
