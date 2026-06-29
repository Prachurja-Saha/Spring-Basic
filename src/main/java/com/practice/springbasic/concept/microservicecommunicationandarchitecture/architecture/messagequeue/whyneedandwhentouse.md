`Event-driven architecture`: Services send events when something happens, and other services react to those events.
There is no direct calling.

# Use cases
Asynchronous processing: Example: User uploads a file → API sends event to MQ → background service processes it.
High-volume data ingestion: Example: Logs, metrics, clickstream → Kafka handles millions of events per second.
Decoupling services: Producers and consumers don’t depend on each other’s availability.
Retry mechanism & error handling: Consumer can retry messages without losing data.
Event-driven architecture: Example: When an order is created → publish event → payment, notification, inventory services react.
Load leveling (smooth traffic spikes): If traffic suddenly increases, messages are stored in queue and processed slowly.
Microservices communication (async): Doesn’t block the caller. No need to wait for API response.

# Benefits
Loose coupling: Services can work independently.
Scalability: Add more consumers to process messages faster.
Reliability: Messages won’t be lost (durable queues, replication).
Fault tolerance: Even if a consumer service is down, messages stay safely in the queue.
Performance: Fast ingestion, async processing, reduced API latency.
Event replay (Kafka): Kafka stores events for long time → you can reprocess history anytime.
Traffic smoothing: Prevents system overload during peak times.

# Virtual thread limitation (why we need message queue to communicate with microservices)
1. `blocking threads` + super cheap + `massive concurrency NOT asynchronous`, NOT non-blocking, NOT cross-service solution
2. If we use millions virtual thread to call external api (takes 3 sec) concurrently, it will take 3 sec to complete all 
   operation. `Still blocking nature`, virtual thread runs inside JVM so they are lightweight (almost no memory + 
   cheap context switching). Even though they don't consume heavy resources, they still wait for the response.
   It makes external API call(service now, salesforce etc.) scalable
3. When a virtual thread in Service 1 calls Service 2 over the network, the request arrives at Service 2, 
   which uses platform threads. Platform threads are limited (tied to CPU cores), so only a fixed number of concurrent 
   requests can run at once. If many virtual threads from Service 1 call Service 2 at the same time, Service 1 scales 
   easily—but Service 2 becomes the bottleneck because it cannot handle high concurrency. Excess requests wait in the 
   queue, increasing latency and reducing throughput. [so we need message queue for microservice communication, virtual 
   thread is usefull when we are performing operation inside service or calling external service i.e. salesforce ]
4. They don't store or retry messages, tight couple with other service(if one service crash data will be losses) and 
   also not async. [message queue can retry, store, loose couple(if service crash data/event will not lose it will again process 
   once service is running) and async]
5. If too many requests come at the same time, your service may crash. [Kafka stores (buffers) the requests in a queue 
   so your service can process them slowly without dying.] virtual threads help, but they cannot protect your service 
   from a huge sudden spike the way a message queue can. Virtual threads let you run many tasks in parallel cheaply
   but your CPU, DB, network, and service still have limits.
   So if 1 million requests hit suddenly:
   Virtual threads will create many threads -->  ALL of them will try to hit your service/DB at once
   `Your CPU/DB will overload and crash` in Virtual thread no buffer, no traffic control, no queue[message queue has all]
6. not scalable(can't call multiple different api's) [in kafka we can increase consumer (with different implementation)]