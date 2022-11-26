# Multithreaded-TCP-And-Peer-To-Peer

This project is capable of showing following use cases:

1.  Single Server & Multiple Client
    - A single server thread tries to serve multiple client threads. Since the server has only one thread, there is no benefits of making client side multithreaded.
    - Run `TCPServerSingle.java` & `TCPClientMultiple.java` for this test case.

2. Multiple Server & Multiple Client
    - Multiple server threads try to serve multiple clients. All clients will be able to run concurrently in that case.
    - By default, number of threads is 8.
    - Run `TCPServerMultiple.java` & `TCPClientMultiple.java`

3. Peer to Peer
    - A single process could be both client & server at the same time.
    - Command Line Arguments:
        -   `server port number` and `client port number`
    - Two options:
        -   Single PeerToPeer instance:
            -   Example Run Command: 
                ```
                PeerToPeer 3000 3000
                ```
        -   Double PeerToPeer instances:
            -   Example Run Command:
                -   Instance1:
                    ```
                    PeerToPeer 3000 4000
                    ```
                -   Instance2:
                    ```
                    PeerToPeer 4000 3000
                    ```