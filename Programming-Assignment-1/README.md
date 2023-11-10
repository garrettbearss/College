This code include both the consumer.c and producer.c files which run together to simulate the producer and consumer problem. 

In order to run the program you must use the following instructions:
$ gcc producer.c -pthread -lrt -o producer
$ gcc consumer.c -pthread -lrt -o consumer
$ ./producer & ./consumer &
Note when building the program: In order to change the amount of items produced or consumed change the loop variable in both the producer and consumer to the same value. When building the files there may be some warning messages, I couldn't figure out how to fix these without breaking the code. 

Example of an output: 

Producer: produced an item, there are 1 items now

Producer: produced an item, there are 2 items now

Consumer: I have consumed an item

Consumer: I have consumed an item

Producer: produced an item, there are 1 items now

Producer: produced an item, there are 2 items now

Consumer: I have consumed an item

Consumer: I have consumed an item

Producer: produced an item, there are 1 items now

Consumer: I have consumed an item

Producer: produced an item, there are 1 items now

Producer: produced an item, there are 2 items now

Consumer: I have consumed an item

Producer: produced an item, there are 2 items now

Consumer: I have consumed an item

Consumer: I have consumed an item

Producer: produced an item, there are 1 items now

Producer: produced an item, there are 2 items now

Consumer: I have consumed an item

Producer: Finished producing

Consumer: I have consumed an item

Consumer: Finished consuming

[1]-  Done                    ./producer
[2]+  Done                    ./consumer