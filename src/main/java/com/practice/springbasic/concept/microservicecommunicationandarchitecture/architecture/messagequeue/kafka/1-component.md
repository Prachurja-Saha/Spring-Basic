# Streaming: Data flows like a river, and you process it immediately while it is flowing.
Example: NonStreaming and Streaming
- Non-streaming (batch)
  You order 50 pizzas. --> Delivery boy comes after 1 hour with all pizzas. --> You eat only after everything is ready.

- Streaming
  You order 50 pizzas. --> As soon as each pizza is ready, it is delivered immediately. --> You start eating while pizzas
  are still being made.

# Kafka is streaming platform -> Messages flow continuously, Consumers read them continuously Processing happens in real
# time (or near real time). If sudden spike in data internally Kafka uses a buffer (the topic log) to handle spikes safely.
# Kafka is continuous because data never stops flowing. Buffering only stores extra messages; it does NOT pause the stream.

# Kafka Component
1. `Kafka Broker`: A Kafka broker is a server that runs Kafka and stores data.
2. `Kafka Cluster`: Kafka cluster consists of multiple brokers that work together to provide scalability, fault tolerance,
   and high availability. Each broker is responsible for storing and serving data related to topics.
   Each broker in the cluster has its own unique number ID.
3. `Topic`: A Kafka topic is like a table where you store the same type of messages. A topic is [append-only], you cannot 
    update or delete specific rows easily. Data is stored in partitions, not in columns/rows. It's for [streaming], 
    not for queries.
4. `Partions`: A partition is a part of a topic where messages are stored in order. Think of a topic as a folder, and
    partitions as sub-folders inside it. This is where actual message are stored. When creating a topic, you must 
    specify the number of partitions. Messages inside a partition are stored in sequence using an incremental ID 
    called the offset. (example: like partition1 is array and offset value is array size)
    [Offset = the position number of a message inside a partition.]
    Topic: {   
     Partition0: [msg1, msg2, msg3, ,] here offset for msg1 = 0, msg2 = 1, msg3 = 2 (Partition0) 
     Partition1;[msg4, msg5]....  here offset for msg4 = 0, msg5 = 1 
    }
    [Each partition are independent, A partition has no fixed message limit; it grows until retention rules or disk 
    space are reached. As new records are produced offset increased, `all the records exist in distributed log file`]
    We can decide which partition(there can be multiple partition in a topic) we want to send data, for that we have to
    mention key. If we don't mention message will go round-robin format(i.e. 1st message par1, 2nd part2, 3rd part1, 
    4rt prt2.... like wise assuming there is only 2 partition) [when we're sending msg with key ordering will be 
    maintained (consume will consume in order, without key we can not guarantee the ordering of the message as consumer 
    pull the messages from all the partition at the same time]
    
5. `Producer`: An application that sends messages to a topic, and Kafka puts them into a partition. 
6. `Consumer`: Application that receives the messages.
7. `Kafka Connect`:
8. `Kafka Stream`:
9. `Zookeeper`: ZooKeeper acted as Kafka’s (old) brain. Kafka brokers were workers, ZooKeeper controlled them.
    maintain kafka broker/server. In Old kafka you need zookeeper to run kafka broker/server
    Command to run kafka broker(old) and use [windows command(cmd)]
    - zookeeper-server-start.bat ..\..\config\zookeeper.properties 
    - kafka-server-start.bat ..\..\config\server.properties 
    - kafka-topics.bat --create --topic my-topic --bootstrap-server localhost:9092 --replication-factor 1 --partitions 3 
    - kafka-console-producer.bat --broker-list localhost:9092 --topic my-topic 
    - kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic my-topic --from-beginning
    [In latest kafka version you do not need zookeeper. Kafka 3.3+ introduced KRaft (Kafka Raft)]
10. `Kafka Raft`:
11. `Consumer Group`: A consumer group is a set of consumers that work together to read data from a topic. 
     [Each partition is read by only 1 consumer in the group. Only 1 consumer in the group can read a partition at a time]
     We need consumer groups(multiple consumer) to share the load, increase speed, & provide fault-tolerant message processing.
12. `Consumer Offset`: The last message position that a consumer has read in a partition. if consumer reads last message
     in partition0 and offset2 than consumer offset is 2. It is a bookmark showing how far a consumer has read in a partition.
13. `_consumer_offset`: is the internal Kafka topic where Kafka stores the committed consumer offsets.
    This topic tracks: Which consumer group has read which message. `The last offset read by each consumer
    Where a consumer should restart if it crashes or restarts`. Kafka manages it automatically.
    It is created when the cluster starts. It usually has 50 partitions (by default). 
    no. of consumer group = no. of _consumer_offset topic
14. `Consumer Group Coordinator`: It is a Kafka broker responsible for managing one consumer group. For every consumer 
    group, Kafka automatically chooses one broker as the group coordinator. It tracks consumer group membership
    Which consumers have joined, Which consumers have left, Which consumers are alive (heartbeat). When a new consumer 
    joins or leaves, coordinator triggers rebalance. It stores offsets in the _consumer_offsets internal topic.
    Ensures consumers are active and not dead.
    When a consumer joins a consumer group, it sends join request to the group coordinator. The group coordinator 
    determines which partitions the consumer should be assigned based on the number of consumers in the group and the
    current assignment  of partitions to the consumer
    [`Note`: The consumer in a consumer group are always assign same partition as long as it remains in the group.
    If a consumerA is handling partition1 than same partition1 again will be assigned by group coordinator to that consumerA]

   # U need to know how consumer group coordinator is assigning partitions to consumer (skipping for now - learn later)

15. `Segment`: In a partition message will append, here segment is group/set of messages in partition. segment is a 
     small part of a partition. i.e. partition1['msg1','msg2','msg3'....]-> here [msg2,msg3] is set of message so it is segment
     A smaller file inside a partition that stores messages for a specific offset range. We can define segment size
16. `Commit log`: Actual data stores (when we install kafka there will be commit log directory inside that tmp/kafka log)
     when Kafka producer produce logs it stores here. path: kafka -> config -> server.properties -> logs.dirs=/tmp/kafka-logs
     u can see this logs using command
     [Producer sends data to a Topic → Kafka stores it in the Partition Log (Commit Log)
     In Kafka: Topic → has partitions 
               Partition → is a commit log file  `A topic contains one or more partitions.Each partition is stored as files on disk.`
               Commit log → is implemented as multiple segment files]
    Topic
    ├── Partition-0 → Commit log (segment files)  these files are encoded 
    ├── Partition-1 → Commit log (segment files)
    └── Partition-2 → Commit log (segment files)
    [partition is not one single file. It is a directory containing many segment files: i.e. .log, .index, .timeindex etc.]
17. `Retention Policy`: Retention policy in Kafka controls how long or how much data Kafka keeps in a topic before 
     deleting it.(by default 168 hours) (time based and size based). 2 types 
     - Time-based retention: Delete data after X time [Messages older than X days will be deleted]
     - Size-based retention: Keep only X GB of data [If partition log exceeds X GB, Kafka deletes oldest segments.]
18. `log cleaner process`: Kafka has a background thread called the Log Cleaner. A background thread that removes older 
     duplicate records for the same key and keeps only the latest one (log compaction). It runs only for compacted topics,
     not for normal retention-based topics. It cleans segments that are “dirty” (segments containing redundant keys).
     It runs only when log compaction is enabled (cleanup.policy=compact). It does NOT manage retention policy.
19.  `server.properties` it is the main configuration file for a Kafka broker. Each Kafka broker has its own 
     server.properties file. each have uniq broker id, port, logfile. If there is kafka cluster(multiple broker) than 
     there should be multiple server.properties file.
20. `replication factor`: how many copies of each partition Kafka keeps across different brokers. 
     if replication.factor = 3 that means Partition has 3 copies Stored on 3 different brokers [why needed b/c if one
     broker/server failed other replicas continue serving data `Kafka can tolerate replicas/brokers going down. this
     is called fault tolerance` Replication Factor is exactly how Kafka achieves fault tolerance ]
     Replication Factor does NOT replicate topics. It replicates EACH partition individually
     So if you have: Partitions = 3 (P0, P1, P2)    Replication Factor = 2  Then each partition gets 2 copies (replicas)
     Partition 0 → Replica on Broker1 (Leader), Replica on Broker2 (Follower)
     Partition 1 → Replica on Broker2 (Leader), Replica on Broker3 (Follower)
     Partition 2 → Replica on Broker3 (Leader), Replica on Broker1 (Follower)
     here total 6 partition (3 actual 3 copy)
21. `ISR (In-Sync Replicas)`: replicas that are fully caught up with the leader and safe to become leader if needed.
     These replicas: Have the latest messages. Are safe and consistent. Are eligible to become leader if current leader fails
     i.e. Leader: Broker1 -> Follower: Broker2 -> Follower: Broker3
     [VI]: If both followers are fully synced with the leader, then ISR is ISR = [Broker1, Broker2, Broker3]
           If a follower falls behind? ISR = [Broker1, Broker2] (OSR = Broker3 → Out-of-Sync Replica)
    1️⃣ Ensures no data loss -> Because only fully synced replicas can take over as leader.
    2️⃣ Ensures high availability -> Quick leader election during broker failure.
    3️⃣ Ensures strong durability when using acks=all
    [Producer sends a message with: acks = all   -> Kafka will do this: Leader writes the message 
           -> Leader sends the message to Broker2 and Broker3 -> Both followers store the message Only when all 
        3 replicas confirm, Kafka replies “SUCCESS” to producer `need to check later ignoring now`]

