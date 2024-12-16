# API -> piece of code that include classes, interface, methods etc. [Application Programming Interface]
i.e -> Collection API, JDBC API, Java Persistence API and many more etc.
`It's a set of rules and proptocols by which different software applications communicate with each other`

# Key Points
APIs provide an interface through which different software components interact. 
They allow different systems, applications, or services to communicate without needing to understand 
each other's internal workings.
[
    In a typical API interaction, a client sends a request to an API endpoint, 
    and the server processes this request and sends back a response. 
    The request and response usually use a standardized format like JSON or XML.
]

# Types of API
1. Web API: These are the most common and are accessed over the internet using HTTP/HTTPS protocols. 
   Examples include REST APIs and SOAP APIs.
2. Library APIs: These are included in software libraries and allow programs to make direct calls to functions 
   or methods provided by the library.
3. Operating System APIs: These provide an interface for applications to interact with the operating system's 
   services and resources.

- -------------- Architectural Style --------------
# Architectural Style 
`defines how multiple system should communicate with each other`, outlines the principle and patterns for data exchange
within multiple system i.e. REST API, SOAP, GRAPHQL, Remote Procedure Cell (RPC)
                    

# RestFul API (REST - Representational State Transfer) -> Architectural style
`REST` : Rest is a popular architectural style for designing networked applications.
 Key Principles: Statelessness, client-server architecture, cacheability, layered system, uniform interface,
 and optionally, code on demand.
 Abstract Concept: REST describes how systems should behave and interact over a network, 
 but it doesn't provide actual code or implementation details.

`RESTful` : APIs use HTTP methods (GET, POST, PUT, DELETE) and are stateless, meaning each request from a client to a 
server must contain all the information needed to understand and process the request.
The actual implementation of REST principles in the form of a functioning API.


# WEB Services is also part of API
1. API can communicate with services by many data format i.e. xml, json, image, any type of file 
but `web service` is a type of API which communicates with other services by JSON or XML only.
2. API can use custom methods i.e. Graphql, Soap, grpc etc. API can use custom protocols i.e. Websocket, FTP etc.
but `web service` use http method protocols(GET, POST, DELETE, PATCH, PUT) only

