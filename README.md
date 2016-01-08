# java-nat-sort

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
* Compiled for Java 6
* Relatively fast, does not allocate extra objects ("garbage free")
* Has a case sensitive and a case insensitive option
* Available under the Apache v2.0 License

Shortcoming / opportunity for improvement:

* Does not play nice with Unicode, especially characters which are outside of the BMP 
* Does not handle fractions or grouping characters properly (ie. 100,000.50)
* Only understands integer values up to 2^64-1

Get it from Maven Central:

````
<dependency>
    <groupId>net.grey-panther</groupId>
    <artifactId>natural-comparator</artifactId>
    <version>1.1</version>
</dependency>
````
