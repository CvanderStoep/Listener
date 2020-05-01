# Listener
This is an implementation of a Java listener Design Pattern. It shows the mechanism with one producer and multiple listeners. 
An generic listener interface is defined to be be able to handle different kind of listeners.

**Producer**
It reads the user keyboard input and sends the data to the various listeners. The textproducer holds the list of listeners using an addtextlistener method.

**Listener1: console writing**
It receives the data and echo's it back to the console.

**Listener2: Disc writing**
It receives the data and appends it to a disk file on C:\tmp\

**Listener3: GUI writing**
It receives the data and writes it to a Jav Frame

**START**
The program can be run using the main class.


