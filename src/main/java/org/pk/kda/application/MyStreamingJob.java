package org.pk.kda.application;

import org.apache.flink.api.common.JobExecutionResult;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyStreamingJob {

    private static final Logger LOG = LoggerFactory.getLogger(MyStreamingJob.class);

    public static void main(String[] args) throws Exception {
        LOG.info(">>> Started MyStreamingJob");

        final StreamExecutionEnvironment env =
                StreamExecutionEnvironment.getExecutionEnvironment();

        DataStream<String> input = env.fromElements(
                "Hello I am Prabhash",
                "I live in India");

        SingleOutputStreamOperator<String> upperCase = input.map(String::toUpperCase);
        upperCase.print();

        LOG.info(">>> Will Execute MyStreamingJob");
        env.execute("My Upper Case Streaming Job");


        LOG.info(">>> End MyStreamingJob");

    }
}
