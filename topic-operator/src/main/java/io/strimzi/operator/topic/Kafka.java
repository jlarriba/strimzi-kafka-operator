/*
 * Copyright 2017-2018, Strimzi authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.strimzi.operator.topic;

import io.vertx.core.Future;

import java.util.Set;

/**
 * A DAO for interacting with the Kafka AdminClient and/or command line Kafka
 * management tools.
 */
public interface Kafka {

    /**
     * Asynchronously create the given topic in Kafka,
     * completing the returned Future when the topic has been created.
     * If the operation fails the returned Future will be failed with the
     * KafkaException (not an ExecutionException).
     * @param newTopic The topic to create.
     * @return A future which is completed once the topic has been created.
     */
    Future<Void> createTopic(Topic newTopic);

    /**
     * Asynchronously delete the given topic in Kafka,
     * completing the returned Future when the topic has been deleted.
     * If the operation fails the returned Future will be failed with the
     * KafkaException (not an ExecutionException).
     * @param topicName The name of the topic to delete.
     * @return A future which is completed once the topic has been deleted.
     */
    Future<Void> deleteTopic(TopicName topicName);

    /**
     * Asynchronously update the topic config in Kafka,
     * completing the returned Future when the topic has been updated.
     * If the operation fails the returned Future will be failed with the
     * KafkaException (not an ExecutionException).
     * @param topic The topic config to update.
     * @return A future which is completed once the topic has been updated.
     */
    Future<Void> updateTopicConfig(Topic topic);

    /**
     * Asynchronously increase the topic's partitions in Kafka,
     * completing the returned Future when the topic has been updated.
     * If the operation fails the returned Future will be failed with the
     * KafkaException (not an ExecutionException).
     * @param topic The topic.
     * @return A future which is completed once the topic has been updated.
     */
    Future<Void> increasePartitions(Topic topic);

    /**
     * Asynchronously change the topic's replication factor in Kafka,
     * completing the returned Future when the topic has been updated.
     * If the operation fails the returned Future will be failed with the
     * KafkaException (not an ExecutionException).
     * @param topic The topic.
     * @return A future which is completed once the topic has been updated.
     */
    Future<Void> changeReplicationFactor(Topic topic);

    /**
     * Asynchronously fetch the topic metadata in Kafka,
     * completing the returned Future with the requested metadata.
     * If the topic does not exist the returned Future will be completed with null result.
     * If the operation fails the returned Future will be failed with the
     * KafkaException (not an ExecutionException).
     * @param topicName The name of the topic to get the metadata of.
     * @return A future which is completed with the requested metadata.
     */
    Future<TopicMetadata> topicMetadata(TopicName topicName);

    /**
     * Asynchronously list the names of the topics available in Kafka,
     * completing the returned Future with the topic names.
     * If the operation fails the returned Future will be failed with the
     * KafkaException (not an ExecutionException).
     * @return A future which is completed with the list of topics.
     */
    Future<Set<String>> listTopics();

}

