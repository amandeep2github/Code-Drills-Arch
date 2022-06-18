# Kafka

## FAQs
### why kafka is called streaming not messaging system
- Its because in streams consumer can move backwards, so its not at message level where once message is delivered its removed.
- Second consumer can apply stream operations like aggregates
- New subscribers can get message from any point in the past as well.