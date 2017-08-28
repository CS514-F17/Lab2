Lab 2 - Java Class Analyzer
==============================

### Functionality Deadline: Monday, September 25, 2017, 5pm
### Final Deadline: Sunday, October 15, 2017, 5pm

*This lab description is subject to change until officially assigned.*

The goal of this project is to implement a program that analyzes the Java files in a given directory. You will use the following features:

- Object-oriented Design
- Arrays

### Overview

For this assignment, you will write a program to find all Java files in a specified directory and then analyze each file to determine the following: 

1. Number of source lines of code ([SLOC](https://en.wikipedia.org/wiki/Source_lines_of_code)) for each class
2. SLOC excluding comments for each class
3. Sum of the SLOC and SLOC excluding comments for all classes found in the directory
4. *Invalid* classes where the name of the class specified by the class definition does not match the name of the file

### General Requirements

For full credit, your solution **must** meet the following requirements.

1. :warning: You may not use `ArrayList` or any other data structure from the `Collections` library for any portion of this program. You may only use the array data structure.
2. :warning: You may not use any of the methods of `java.util.Arrays`, including `Arrays.sort`. All sorting the in this program must be implemented by you.
3. Your program will be run as follows: `java javaanalyzer.Driver -input <input_directory> -output <output_file>` for example:
```
java -cp target/classes/ javaanalyzer.Driver -input input/simple/ -output output/simple.txt
```
4. Your program will process files in the input directory to find *all* Java files in the specified directory. You do *not* need to traverse subdirectories. You will need to ignore any file that does not end with the extension `.java`.
5. The output of your program will display (1) the total number of valid classes found, (2) for each class, the absolute path of the class, the SLOC, and SLOC excluding comments; (3) the total SLOC across all classes found; (4) the SLOC excluding comments across all classes found; and (5) the absolute path of all *invalid* classes found. The required formatting is shown in this example: [simple.txt](expected/simple.txt) Your formatting must match the example *exactly* or your solution will not pass the test cases.
6. The list of valid classes will be sorted in order of the total number of lines in each class from least to greatest. 
7. Your solution must handle both single and multi-line comments. Single-line comments begin with `//`. For multi-line comments, you can assume that the beginning of comment marker `/*` has only whitespace (spaces, tabs) in front of it, while the end of comment marker `*/` has only whitespace after it. Make sure to use the `trim` method.
8. The `input` directory contains the Java files that will be passed as input to your program by the test cases. **Do not modify any of the files or directories in `input/`.**
9. The `expected	` directory contains the output against which your solution will be compared. **Do not modify any of the files in the `expected/` directory.**

### Design Requirements

Following are the required design elements for your solution. You will have additional classes and methods, but a solution that does not implement the following design elements will not be eligible for code review and resubmission.

1. :warning: You may not use `ArrayList` or any other data structure from the `Collections` library for any portion of this program. You may only use the array data structure.
2. :warning: You may not use any of the methods of `java.util.Arrays`, including `Arrays.sort`. All sorting in this program must be implemented by you.
3. As you process each file, its statistics must be stored in a custom object called `ClassInfo`. A `ClassInfo` object maintains data members that store the filename, classname, total number of lines in the file, and total number of non-comment lines in the file. A new instance of this class is created for every individual Java file. You will need to decide which methods are appropriate for this class and where it should be instantiated.
4. You must implement a class `FilesInfo` that maintains the entire list of `ClassInfo` objects. The `FilesInfo` object will be instantiated before you start processing the Java files. For each Java file processed, a new `ClassInfo` object will be created and added to the `FilesInfo` object. The `FilesInfo` class must contain at least the following methods:
  - `constructor` - takes no input and instantiates two arrays. The first array stores the list of `ClassInfo` objects and the second array stores a list of `String` where each `String` represents an invalid class.
  - `addClassInfo` - takes as input a `ClassInfo` object and stores it *in sorted order* in the array of `ClassInfo` objects. Note, if the array is full it must be resized to accommodate the new object. The array must remain sorted at all times. `ClassInfo` objects are sorted by the total lines of the class from least to greatest.
  - `addInvalidFile` - takes as input a `String` and stores it *in sorted order* in the array of `String` objects. Note, if the array is full it must be resized to accommodate the new object. The array must remain sorted at all times. `String` objects are sorted in alphabetical order.
  - `saveToFile` - takes as input a `String` representing an output file name and saves a `String` representation of the `FilesInfo` to the specified file. The output directory must be created if it does not exist. The method returns `true` if successful and `false` otherwise.
  - Additional methods may be added to `FilesInfo`. My solution has a `toString` method, methods to resize the arrays, and helper methods to find the total SLOC for all files and the non-comment SLOC for all files.


### Hints

When processing a single .java class file, you will need to go through the file line by line, counting both every line in the file, and every line that is not a comment line.  So, for the following file:

```java
public class Test
{
   public int Q;
   
   // This is a comment line
   public Test() // This is not a comment line!
   {
       /* int x = 0
          int y = 4
          int z = 3 */
       Q = 3;
   }
} 
```
The line count would be 13 (since there are a total of 13 lines in the file), and the number of lines excluding comments would be 9. Note that empty lines (like the line between the declaration of `Q` and the comment below) *are* counted.

If this class were defined in a file named `Test.java` it would be considered *valid*. If the file name were anything else the class would be *invalid*.

You will need to use many methods of the `String` class.

Remember that there *may* be import statements, package statements or comments at the beginning of the file.

### Submission Requirements

1. Use the following link to create your private github repository for this assignment. The repository will be seeded with the skeleton code, test cases, and input files. [Lab 2]()
2. For full credit, make sure to follow all [Style Guidelines](https://github.com/CS514-F17/notes/blob/master/Admin/style.md). Points will be deducted for each violation.


### Grading Rubric

| Points | Criterion |
| ------ | -------- |  
| 30 | JavaAnalyzerTest |
| 30 | JavaAnalyzerErrorTest-testSimple | 
| 15 | JavaAnalyzerErrorTest-testComplex | 
| 10 | `ClassInfo` and `FilesInfo` Design Requirement | 
| 15 | Design |

Partial credit may be awarded for partial functionality and/or partially correct design or style elements.

### Academic Dishonesty

Any work you submit is expected to be your own original work. If you use any web resources in developing your code you are strongly advised to cite those resources. The only exception to this rule is code that is posted on the class website. The URL of the resource you used in a comment in your code is fine. If I google even a single line of uncited code and find it on the internet you may get a 0 on the assignment or an F in the class. You may also get a 0 on the assignment or an F in the class if your solution is at all similar to that of any other student.
