package org.pk.kda.application;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class MyStreamingJob {


    public static void main(String[] args) throws Exception {
        System.out.println(">>> Started MyStreamingJob");

        final StreamExecutionEnvironment env =
                StreamExecutionEnvironment.getExecutionEnvironment();

        DataStream<String> input = env.fromElements(
                "Hello I am Prabhash",
                "I live in India");

        SingleOutputStreamOperator<String> upperCase = input.map(String::toUpperCase);
        upperCase.print();

        env.execute("My Upper Case Streaming Job");

        System.out.println(">>> End MyStreamingJob");

    }
}
