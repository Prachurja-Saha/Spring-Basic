# There are 2 types of Service Discovery
1. [Client-Side Service Discovery](Netflix Eureka, Zookeeper, Consul): client handles load balancing. (`Traditional`)
   In client-side discovery, the client queries the Discovery Service(internally fetch from service registry) 
   to get the service address, then calls the service directly. `Here Client call service directly`
   ┌────────────────────────────┐
   │       Service A (Client)   │
   │  Needs to call Service B   │
   └────────────┬───────────────┘
                │
   1️⃣ Query Discovery Service for Service B(Target) — which has multiple running instances.
                │
                ▼
   ┌────────────────────────────┐
   │   Discovery Service         │
   │ (Service Registry: stores   │
   │  IPs, ports of all services)│
   └────────────┬───────────────┘
                │
   2️⃣ Returns list of Service B instances 
   e.g., [10.0.0.5:8080, 10.0.0.6:8080]
                │
                ▼
   ┌────────────────────────────┐
   │     Service A (Client)     │
   │ Chooses one instance using │
   │ load-balancing logic       │
   └────────────┬───────────────┘
                │
   3️⃣ Sends request directly to chosen instance
                │
                ▼
   ┌────────────────────────────┐
   │     Service B Instance      │
   │ Processes request & returns │
   │ response to Service A       │
   └────────────────────────────┘


2. [Server-Side Service Discovery]:`Most common` (used with gateways like NGINX, AWS ALB, Spring Cloud Gateway, Kubernetes Ingress).
   who does discovery-> A middle component(API Gateway/Load Balancer) queries the Service Registry & routes the request.
   [Server-side discovery determines which server or service instance(in cloud there can be multiple instance) 
   should handle the request.] `Here Client does not call service directly it goes through a gateway or load balancer etc.`
   ┌──────────────────────────┐
   │         Client           │
   │ (Sends API Request)      │
   └────────────┬─────────────┘
                │
   1️⃣ Request to API Gateway / Load Balancer
                │
                ▼
   ┌───────────────────────────────────────────────┐
   │     API Gateway / Load Balancer / Mesh Proxy   │
   │  - Receives request                           │
   │  - Performs Service Discovery                 │
   └────────────┬──────────────────────────────────┘
                │
   2️⃣ Queries Discovery Service (Service Registry)
                │
                ▼
   ┌───────────────────────────────────────────────┐
   │            Discovery Service                  │
   │     (Stores Service Registry Data)             │
   │  e.g., Eureka, Consul, Zookeeper              │
   └────────────┬──────────────────────────────────┘
                │
   3️⃣ Returns list of available service instances
                │
                ▼
   ┌───────────────────────────────────────────────┐
   │             Target Service Instances           │
   │     e.g., Service-A, Service-B, Service-C      │
   └────────────┬──────────────────────────────────┘
                │
   4️⃣ Gateway chooses one instance and forwards request
                │
                ▼
   ┌───────────────────────────────────────────────┐
   │          Chosen Service Instance              │
   │  - Processes the request                      │
   │  - Sends response back                        │
   └────────────┬──────────────────────────────────┘
                │
   5️⃣ Response flows back to Client
                ▼
   ┌──────────────────────────┐
   │         Client           │
   │   (Receives response)    │
   └──────────────────────────┘

# NOTE
- If the load balancing is done by server side(i.e. server side discovery) than it's called server side load balancing
- If the load balancing is done by client side(i.e. client side discovery) than it's called server side load balancing

# Service Mesh Discovery(Most modern evolution of both approaches) Hybrid approach