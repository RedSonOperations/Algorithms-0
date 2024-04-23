# Project Name
Lab3_AKain: Huffman Trees - Tree-building, Encoding, and Decoding Messages

## Description
The purpose of this lab was to implement various methods for building a Huffman tree, which is a method of encoding messages by counting the frequency of letters in a string, assigning them as leaf nodes in a tree from lowest to highest frequency (higher priority given to less frequent letters), and constructing branches to add the frequencies contiguously in order to generate a tree structure with the sum of all frequencies as the root node, thereby assigning each letter/frequency pair a code, where, depending on the depth of the leaf nodes, left branches are assigned a '0', appended to their existing, variable code, and right branches are given a '1', appended to their existing, variable code; in addition, encoding and decoding of strings based on a read-in (file I/O handles this part) frequency table prior to construction of the Huffman tree for subsequent encoding and decoding of string messages after the tree has been built.

## Prerequisites

- Java Development Kit (openJDK) using Eclipse IDE, version details below:
- openjdk version "20.0.2" 2023-07-18
- OpenJDK Runtime Environment Homebrew (build 20.0.2)
- Eclipse OpenJ9 VM Homebrew (build openj9-0.40.0, JRE 20 Mac OS X aarch64-64-Bit 20230801_000000 (JIT enabled, AOT enabled)
  OpenJ9   - d12d10c9e
  OMR      - e80bff83b
  JCL      - 19eb54abdac based on jdk-20.0.2+9)

## Compilation

- Navigate to Your Project Directory: Open your system's terminal or command prompt and navigate to the directory where your Java source code (.java files) is located: cd /Users/your_username/java-projects/Lab3_AKain/src

- Compile Your Java Files: Use the javac command to compile your Java source files. Replace Main.java with the filename of your main Java class (the one with the public static void main(String[] args) method): javac Main.java
This command will compile your Java code and generate corresponding .class files in the same directory.

- Run Your Java Program: Once the compilation is successful, you can run your Java program using the java command followed by the name of your main class (without the .class extension): java Main
Replace Main with the actual name of your main class.




