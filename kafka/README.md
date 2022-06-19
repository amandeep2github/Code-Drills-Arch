# Kafka

## important terms
- 

## setup 
- clusters 2X+1
- partitions atleast cluster size
- replication >=3
- ISR
- ACK (0, 1, all)
- ACK setting impacts Latency, Throughput, Durability

[Quickstart](https://kafka.apache.org/quickstart)

## Issues
[Connection to node 0 could not be established](https://stackoverflow.com/questions/62535706/how-to-resolve-kafka-error-connection-to-node-0-could-not-be-established)


## FAQs
### why kafka is called streaming not messaging system
- Its because in streams consumer can move backwards, so its not at message level where once message is delivered its removed.
- Second consumer can apply stream operations like aggregates
- New subscribers can get message from any point in the past as well.