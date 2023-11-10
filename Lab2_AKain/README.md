# Project Name
Lab2_AKain: Recursive Prefix to Postfix Expression Converter Algo

## Description
The purpose of this lab was to implement a recursive method for converting prefix expressions to postfix expressions, leveraging a left-to-right reading order that concatenated two preceding operand expressions that may contain an operator due to possible prior concatenation with a current operator, and maintains that the number of operands must be greater than the number of operators by 1. This recognized pattern holds for all prefix expressions that can be reliably translated into their respective postfix expressions; any variation from this pattern will result in an invalid input expression.

## Prerequisites

- Java Development Kit (openJDK) using Eclipse IDE, version details below:
- openjdk version "20.0.2" 2023-07-18
- OpenJDK Runtime Environment Homebrew (build 20.0.2)
- Eclipse OpenJ9 VM Homebrew (build openj9-0.40.0, JRE 20 Mac OS X aarch64-64-Bit 20230801_000000 (JIT enabled, AOT enabled)
  OpenJ9   - d12d10c9e
  OMR      - e80bff83b
  JCL      - 19eb54abdac based on jdk-20.0.2+9)

## Compilation

- Navigate to Your Project Directory: Open your system's terminal or command prompt and navigate to the directory where your Java source code (.java files) is located: cd /Users/your_username/java-projects/Lab2_AKain/src

- Compile Your Java Files: Use the javac command to compile your Java source files. Replace Main.java with the filename of your main Java class (the one with the public static void main(String[] args) method): javac Main.java
This command will compile your Java code and generate corresponding .class files in the same directory.

- Run Your Java Program: Once the compilation is successful, you can run your Java program using the java command followed by the name of your main class (without the .class extension): java Main
Replace Main with the actual name of your main class.




