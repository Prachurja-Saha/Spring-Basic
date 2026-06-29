#  Monolithic Architecture. (Single application) 
https://www.geeksforgeeks.org/advance-java/microservices-interview-questions/
https://www.geeksforgeeks.org/system-design/microservices/

# Stateful vs Stateless Microservices

`Stateless` -> Does not store date inside application rely on external DB. No session state each request is independent
Easily Scalable, failure do not affect other
`Stateful` -> stores data between request, Maintain user session, More complex required state synchronization, state can
be loss on failure

Use Cases of Stateful Microservices
Stateful microservices are ideal for applications where maintaining session data is crucial. Here are several common use cases:

E-Commerce Applications: Shopping carts require maintaining user selections across sessions. When a user adds items to 
their cart, that information needs to persist until checkout.
Online Gaming: Multiplayer games need to track player sessions, scores, and inventories, requiring a constant state to 
provide a seamless experience.
Financial Services: Banking applications often need to maintain state for transactions, such as ongoing transfers or 
loan applications, ensuring security and compliance.
Collaborative Tools: Applications like Google Docs keep track of user edits in real-time, necessitating a persistent 
state to manage concurrent modifications.
Streaming Services: User preferences, watch history, and playlists must be tracked over time, requiring a stateful 
approach to deliver a personalized experience.


Use Cases of Stateless Microservices
Stateless microservices shine in scenarios where operations are independent and do not require persistent data. Common use cases include:

APIs: RESTful services that process requests independently without needing to remember previous states.
Data Processing: Services that handle batch jobs or data transformations, where previous interactions are irrelevant and not stored.
Authentication: Stateless tokens (like JWT) can be used for user sessions without retaining server-side data, enhancing scalability and performance.
Content Delivery: Static file serving, where each request for a file is treated independently, making it straightforward and efficient.
Microservices Communication: Services that provide utility functions (like logging or metrics) without retaining state,
allowing them to operate independently of user sessions.