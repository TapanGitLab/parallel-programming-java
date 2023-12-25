# parallel-programming-java

This project's goal is to show how to run many threads concurrently and how to do a specific operation when each thread has finished its execution.

To do this, there were 2 methods:
1: Fork-join using Thread.
2: ExecutorService and Future.


Below is the output without using either of fork-join/ExecutorSrvice and Future. Here will not have any control on completion of all threads.
<img width="782" alt="image" src="https://user-images.githubusercontent.com/118552076/230639452-bee03dd5-e231-4f85-a063-6f3dabc79fd4.png">


Below is the output using either of fork-join/ExecutorSrvice and Future. Here application will wait till completion of execution of all threads and then only it will executes next task.
<img width="848" alt="image" src="https://user-images.githubusercontent.com/118552076/230640291-475846ee-2785-44f7-a249-0aa83ece8779.png">


