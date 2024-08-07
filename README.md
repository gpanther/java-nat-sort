# java-nat-sort

Updated implementation for Java 1.8+

Java implementation of the "[natural sort](http://blog.codinghorror.com/sorting-for-humans-natural-sort-order/)" (also known as [Alphanum sort](http://www.davekoelle.com/alphanum.html)) algorithm which gives a more "natural" ordering when presenting the sorted list of strings to humans.

For example, given the following strings:

````
a1.txt
a2.txt
a10.txt
````

A traditional sort algorithm would sort them like:

````
a1.txt
a10.txt
a2.txt
````

While this algorithm would give the initial ("natural") order.

Features:

* Self-contained, no other dependencies
* Relatively fast, does not allocate extra objects ("garbage free")
* Has a case sensitive and a case insensitive option
* Available under the Apache v2.0 License

Shortcoming / opportunity for improvement:

* Does not play nice with Unicode, especially characters which are outside of the BMP 
* Does not handle fractions (ie. 1/5)
* Only understands integer values up to 2^64-1

````
