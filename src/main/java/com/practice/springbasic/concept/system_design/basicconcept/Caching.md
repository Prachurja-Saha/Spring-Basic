`Latency` -> In Site Reliability Engineering (SRE), latency is the total time a system takes to process a request and 
             return a response, a critical metric in the Four Golden Signals (Latency, Traffic, Errors, Saturation) for 
             monitoring performance and user experience.

# To reduce latency
`Caching` -> Caching in system design is storing frequently accessed data in a fast, temporary storage (cache) to reduce 
latency and database load, improving application performance significantly by serving data from the cache (cache hit) 
instead of the slower main source (cache miss).
`CDN (Content delivery network)` -> A Content Delivery Network (CDN) is a globally distributed network of servers 
designed to enhance the performance and availability of web content. CDNs reduce latency and accelerate the delivery of 
static assets, such as images, videos, and scripts, by storing copies on servers strategically positioned around the 
world. When a user requests content, the CDN automatically routes the request to the nearest server, minimizing the 
physical distance and, consequently, reducing load times.
`Throughput` -> The rate at which a system, process, or network can move data or carry out operations in a particular 
period of time is referred to as throughput. Bits per second (bps), bytes per second, transactions per second, 
etc. are common units of measurement. It is computed by dividing the total number of operations or objects executed 
by the time taken.

# Consistency types

# CAP theorem
The CAP Theorem states that a distributed data system can only guarantee two out of three properties: 
Consistency `(all nodes see the same data)`, 
Availability `(every request gets a response)`, and 
Partition Tolerance `(the system works despite network failures)`. 
[In practice, network partitions will happen, so systems must choose between 
prioritizing Consistency (CP) or Availability (AP) during a partition, sacrificing the other to maintain function, 
a key trade-off in designing reliable distributed databases like NoSQL systems.]

- The Three Properties
Consistency (C): All readers see the most recent write, or an error. Data is uniform across all nodes at any given time.
Availability (A): Every request receives a non-error response, even if some data might be stale (not the latest write).
Partition Tolerance (P): The system continues to operate even if network communication between nodes is lost (a "partition").

- The Trade-off
In normal operation, a distributed system can have C, A, and P.
During a network partition (P), the system must choose between C and A.
1. CP (Consistency & Partition Tolerance): If a partition occurs, the system might become unavailable 
(stop responding to requests) to ensure data consistency, preventing stale reads. (e.g., Traditional relational databases, some NoSQL)
2. AP (Availability & Partition Tolerance): If a partition occurs, the system stays available but might return stale 
data because it can't confirm the latest write across all nodes. (e.g., Many modern NoSQL databases like Cassandra, DynamoDB)

Why it Matters
The CAP theorem highlights that you can't have perfect consistency, availability, and resilience to network failure 
simultaneously in a distributed system. Developers use it to make informed design choices, understanding that prioritizing
one property often means compromising another, depending on the application's needs (e.g., banking needs C; social media 
feeds often favor A).

# Lamport logical lock

# Scaling
1. Vertical Scaling : adds resources (CPU, RAM) to a single machine (scaling up/down), being simpler but limited by 
                      hardware and often requiring downtime.
2. Horizontal Scaling : adds more machines (nodes) to distribute a workload (scaling out/in), offering high availability
                        and near-limitless capacity but with added complexity.

# Redundancy and Replication
Redundancy refers to having backup copies or extra resources to ensure smooth operation even if something fails. 
Replication, on the other hand, replication involves creating exact copies of data or resources to distribute workload 
or improve accessibility. While both involve creating duplicates, redundancy focuses on backup and safety, while 
replication emphasizes sharing and efficiency. Let us understand the differences between the two.
 
