# OSI Model - 7 layers
-CLIENT [point 1,2,3 devices use -> App FW, VPN, SSL, Proxies | point 4 devices use -> Load Balancer | point 5 -> Router]
   | `Client calling server by layers`
1. APPLICATION  -> Uses HTTP(mainly for web), SMTP(mail), FTP(file transfer protocol) etc. protocols
2. PRESENTATION -> compress the data (ASCII, .JPEG, DOCX)
3. SESSION -> Open or establish a connection/ session. When the whole network communication is over then session is also over
              All authentication is takes place in session layer
4. TRANSPORT -> Ensure Delivery using TCP(Popular) or UDP(Live stream) protocols (We add transport headers [PORT Details])
                Here we break the data into segment
5. NETWORK -> collect data segment into packets(add more info[We add network header(logical ip of destination where i want to send)])
              ,Protocols -> IP, IPsec We Decide the routing 
6. DATALINK -> Here Data further divided into frames[add more data info (mac(media access control)/LLC address(universally 
                uniq in every device) of the device which i am sending)] Protocols is Ethernet [devices - NIC Switches]
7. PHYSICAL -> Converts whole frames into binary bits (0 and 1) it goes through electrical signals/ voltage pulse
    |  `Server reciveing call by layers`
1. PHYSICAL
2. DATALINK
3. NETWORK
4. TRANSPORT
5. SESSION
6. PRESENTATION
7. APPLICATION
- SERVER

# TCP/IP layer[4 layers] -> Very similar to OSI layer 