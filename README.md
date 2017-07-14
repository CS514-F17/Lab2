Lab 2 - Java Class Analyzer
==============================

### Functionality Deadline:
### Final Deadline:

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
7. Your solution must handle both single and multi-line comments. Single-line comments begin with `//`. For multi-line comments, you can assume that the beginning of comment marker `/*` has only whitespace (spaces, tabs) in front of it, while the end of comment marker `*/` has only whitespace after it. 
8. The `input` directory contains the Java files that will be passed as input to your program by the test cases. **Do not modify any of the files or directories in `input/`.**
9. The `expected	` directory contains the output against which your solution will be compared. **Do not modify any of the files in the `expected/` directory.**

### Design Requirements

1. :warning: You may not use `ArrayList` or any other data structure from the `Collections` library for any portion of this program. You may only use the array data structure.
2. :warning: You may not use any of the methods of `java.util.Arrays`, including `Arrays.sort`. All sorting the in this program must be implemented by you.


### Hints

When processing a single .java class file, you will need to go through the file line by line, counting both every line in the file, and every line that is not a comment line.  So, for the following file:

```
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

The line count would be 13 (since there are a total of 13 lines in the file), and the number of lines excluding comments would be 9.

If this class were defined in a file named `Test.java` it would be considered *valid*. If the file name were anything else the class would be *invalid*.

You will need to use many methods of the `String` class.

Remember that there *may* be import statements, package statements or comments at the beginning of the file.


###############


### Submission Requirements

1. Use the following link to create your private github repository for this assignment. The repository will be seeded with the skeleton code, test cases, and input files. [Lab 2]()
2. For full credit, make sure to follow all [Style Guidelines](https://github.com/CS514-F17/notes/blob/master/Admin/style.md). Points will be deducted for each violation.


### Grading Rubric

| Points | Criterion |
| ------ | -------- |  
| 30 | DocProcessorSimpleTest |
| 30 | DocProcessorComplexTest | 
| 5 | DocProcessorErrorHandlingTest | 
| 5 | DocProcessorSimpleTFIDFTest |
| 5 | DocProcessorComplexTFIDFTest | | 
| 15 | Design |
| 10 | Style |

Partial credit may be awarded for partial functionality and/or partially correct design or style elements.

### Academic Dishonesty

Any work you submit is expected to be your own original work. If you use any web resources in developing your code you are strongly advised to cite those resources. The only exception to this rule is code that is posted on the class website. The URL of the resource you used in a comment in your code is fine. If I google even a single line of uncited code and find it on the internet you may get a 0 on the assignment or an F in the class. You may also get a 0 on the assignment or an F in the class if your solution is at all similar to that of any other student.
