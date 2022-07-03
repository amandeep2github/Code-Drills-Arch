package com.wtt.pubsub.sample;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

public class Consumer {
    static String bootstrapServers = "localhost:9092"; // usually of the form cell-1.streaming.<region>.oci.oraclecloud.com:9092 ;
    static String streamOrKafkaTopicName = "test-topic"; // from step 2 of Prerequisites section

    private static Properties getKafkaProperties() {
        Properties props = new Properties();
        props.put("bootstrap.servers", bootstrapServers);
        props.put("group.id", "test");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("buffer.memory", 33554432);
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        return props;
    }

    public static void main(String args[]) {
        try {
            Properties properties = getKafkaProperties();
            KafkaConsumer consumer = new KafkaConsumer(properties);

            consumer.subscribe(Arrays.asList("test-topic"));
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(100);
                for (ConsumerRecord<String, String> record : records)
                    System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
            }
        } catch (Exception e) {
            System.err.println("Error: exception " + e);
        }
    }
}
