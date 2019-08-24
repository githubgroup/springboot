package com.yq.consumer;import lombok.extern.slf4j.Slf4j;import org.apache.kafka.clients.consumer.ConsumerRecord;import org.springframework.kafka.annotation.KafkaListener;import org.springframework.stereotype.Component;import java.util.Optional;/** * Created by yqbjtu on 2018/4/22. * */@Component@Slf4jpublic class CmdReceiver {    @KafkaListener(topicPattern = "yqtopic01.*", group = "consumer2")    //public void listen(ConsumerRecord<?, ?> record, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {    public void listen(ConsumerRecord<?, ?> record) {        Optional<?> kafkaMessage = Optional.ofNullable(record.value());        if (kafkaMessage.isPresent()) {            Object message = kafkaMessage.get();            long offset = record.offset();            int partitionId = record.partition();            //log.info("----------------- record =topic："  + topic+ ", " + record);            log.info("message={}, offset={}, partitionId={}", message, offset, partitionId);        }    }}