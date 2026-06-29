`Service Registry` – It’s like a phonebook/DB that keeps the address (IP/port) of all running microservices.
                      database that stores service info.
`Service Registration` = adding info into the registry.
`Service Discovery` = It’s the process of finding a service’s address from that phonebook/db (registry)
                      so other services can talk to it. When the API Gateway (or Load Balancer / Service Mesh) 
                      queries the Service Registry to find which service instances are available and healthy, 
                      that process is called Service Discovery.

# What's Service Discovery and Service Registry in Microservices?
Suppose we have Service-A & Service-B and we have our Load Balancer(think as Service-C) placed inside a different server. 
Now let's introduce our Discovery Service(Service-Registry). Now what this discovery service will do now whenever 
Service-A and Service-B want to communicate with each other then `whenever we are starting our Microservices 
we'll be registering them with Discovery Service(Service-Registry)`. And this discovery service right now will know what 
is the IP and port number of Service-A and what is the IP and port number of Service-B. All detailed information will be
there with Discovery Service. Similarly, if we have many different instances of Service-B, all this Service-B which is 
running in different servers will be registering their information with Discovery Service. So it is one central location
where we'll be managing our host and the port number information inside this particular server. This is basically called
registration because all the services whenever they are starting off they are registering themselves with the discovery 
service and now the discovery service is maintaining all their information inside a particular map or a list or a database. 
We called it a `Service Registry`.
Discovery Service: The whole system (includes API, logic, and registry)
Service Registry: The Service Registry is the data storage (or database) inside the Discovery Service that holds the service details
✅ Example:
In Eureka,
Eureka Server = Discovery Service
Eureka Registry = Data store inside Eureka Server that keeps all service instance information

[Discovery Service stores data, and that stored data is called the Service Registry.
There can be multiple discovery service if one down other will be backup]

Now Service-A wants to connect to Service-B. Now the load balancer once get the request, it is gonna do a query with 
the discovery service that, hey, can you tell me what instances are there for Service-B? Now the load balancer 
finds out that there are this many instances available where Service-B has been deployed. 
Now Load Balancer is going to dispatch to one of the servers by looking into Service Registry. 
It can take all four instances of Service-B and whoever has less load then to balance the load, it can send the request to there.

[Note: Don't mix up load balancing and service discovery. The `Load Balancer job is to do load balancing` while 
the `Service Discovery job is to do discovering service info`. When we build Microservices and call other microservices, 
we need service discovery to find the hosts and IP info and if multiple hosts are available then the load balancer helps
to pick one and make a call in a load-balanced way.]

