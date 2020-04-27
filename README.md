# Listener
This is an implementation of a Java Listener. It shows the mechanism with one producer and two listeners. 
An generic listener interface is defined to be be able to handle different kind of listeners.

**Producer**
It reads the user keyboard input and sends the data to the listeners.

**Listener1: console writing**
It receives the data and echo's it back to the console.

**Listener2: Disc writing**
It receives the data and appends it to a disk file on C:\tmp\


