# How to easily share your tests

To easily share your tests, you can use the code we have implemented in the _Algo2Problem1Test_, _Algo2Problem2Test_ and _Algo2Problem3Test_.

## Parsing JSON in Java
Because Java is the best language, if you want to parse some JSON easily, you need to install a package, *javax.json*.

To do this, you can add this XML code in your pom.xml file.

```xml
<dependency>
    <groupId>javax.json</groupId>
    <artifactId>javax.json-api</artifactId>
    <version>1.1.4</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.glassfish</groupId>
    <artifactId>javax.json</artifactId>
    <version>1.0.4</version>
</dependency>
```

## Adding a new test
### To add a test, you need to create two files
A _.txt_ file and a _.json_ file. The _.txt_ file will contain the test itself, like the one provide
by James.
The _.json_ file will contain the result of the test. This result will be store in an array (even of the result is null).

*Both file need to have the same name.*

Then, you will have to create a function to run this new test in the corresponding test class in [`java/be/unamur/info/algo2`](java/be/unamur/info/algo2).
The function should looks like:

```java

/* Here, it is for problem 1, but it is the same for any problem */
@Test
public void test_problem_x_desc_of_your_test() throws Exception{
    testFileNaive("src/test/resources/problem1/testfile");
    testFile("src/test/resources/problem1/testfile");
}
```

assuming that you created the two files (`testfile.txt` and `testfile.json`) in [`resources/problem1`](resources/problem1).

#### Example 1 - Valid result

The .txt file
```text
4
5 3 10
3 3 7
2 3 1
6 1 9
8 2 4
3 7 2
1 1 7
8
3 3 7
2 3 1
6 1 9
8 2 3
3 4 9
2 3 4 1
6 5 5 3
5 2 3 4
``` 

The .json file
```json
[10, -1, 6, -1]
```

_As you can see, the values are integer not string._

#### Example 2 - Invalid result

The .txt file
```text
-4
5 3 10
3 3 7
2 3 1
6 1 9
8 2 4
3 7 2
``` 

The .json file
```json
[null]
```

_As you can see, the null is store in an array._

