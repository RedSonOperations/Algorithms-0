//added 'Arrays' solely to show output of tree structure
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    private static Object[][] dictArr = new Object[26][2];

    public static void main(String[] args) {
    	System.out.println("Frequency table: ");
        makeFreqDict();
        Node huffmanTree = buildHuffmanTree(dictArr);
        System.out.println("\nThe tree in preorder is: ");
        printPreOrder(huffmanTree);
        String clearTextFile = "/Users/aleckain/java-projects/Lab3_AKain/input-files/ClearText-1.txt";
        String encodedText = encodeFromFile(clearTextFile, huffmanTree);
        System.out.println("\nThe code is: ");
        generateEncoding(huffmanTree);
        
        System.out.println("\nEncoded Text:");
        System.out.println(encodedText);
        
        String encodedFile = "/Users/aleckain/java-projects/Lab3_AKain/input-files/Encoded-1.txt";
        String decodedText = decodeFromFile(encodedFile, huffmanTree);
        
        System.out.println("Decoded Text:");
        System.out.println(decodedText);
        
        String clearTextFileAdditional = "/Users/aleckain/java-projects/Lab3_AKain/input-files/ClearText-AdditionalInput.txt";
        String encodedTextAdditional = encodeFromFile(clearTextFileAdditional, huffmanTree);
        
        System.out.println("Encoded Text (additional):");
        System.out.println(encodedTextAdditional);
        
        String encodedFileAdditional = "/Users/aleckain/java-projects/Lab3_AKain/input-files/Encoded-AdditionalInput.txt";
        String decodedTextAdditional = decodeFromFile(encodedFileAdditional, huffmanTree);
        
        System.out.println("Decoded Text (additional):");
        System.out.println(decodedTextAdditional);
    }
    
    public static String decodeFromFile(String filePath, Node huffmanTree) {
        //parses encoded text from a file line by line and decodes it using Huffman tree generated
        StringBuilder decodedText = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                decodedText.append(decodeText(line, huffmanTree));
                decodedText.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace(); //prints any encountered input/output exception
        }
        return decodedText.toString(); //returns decoded text
    }

    public static String decodeText(String encodedText, Node huffmanTree) {
        //decodes given encoded text using Huffman tree
        StringBuilder decodedText = new StringBuilder();
        Node currentNode = huffmanTree;

        for (char bit : encodedText.toCharArray()) {
            //traverses Huffman tree based on codes in encoded text
            if (bit == '0') {
                currentNode = currentNode.getLeft();
            } else if (bit == '1') {
                currentNode = currentNode.getRight();
            }

            //appends decoded characters to the result when a leaf node is reached
            if (currentNode != null && currentNode.getLeft() == null && currentNode.getRight() == null) {
                decodedText.append(currentNode.getData()[0]);
                currentNode = huffmanTree;
            }
        }

        return decodedText.toString(); //returns the decoded text
    }

    public static String encodeFromFile(String filePath, Node huffmanTree) {
        //reads text from clear file, encodes it using Huffman tree, and returns encoded text
        StringBuilder encodedText = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                encodedText.append(encodeText(line, huffmanTree));
                encodedText.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace(); //prints any encountered input/output exception for error checking
        }
        return encodedText.toString(); //returns encoded text
    }

    public static String encodeText(String text, Node huffmanTree) {
        //encodes given text using a Huffman tree and returns the encoded text
        StringBuilder encodedText = new StringBuilder();

        //removes spaces and punctuation from input text
        text = text.replaceAll("[^a-zA-Z]", "");

        //encodes each character in input text based on the Huffman tree
        for (char c : text.toCharArray()) {
            String code = findCharacterCode(huffmanTree, c, "");
            encodedText.append(code); //appends the code for each character to existing code
        }

        return encodedText.toString(); //returns encoded text
    }

    public static String findCharacterCode(Node root, char target, String code) {
        //finds Huffman code for a specific character in the Huffman tree
        if (root == null) {
            return "";
        }

        if (root.getLeft() == null && root.getRight() == null && (char) root.getData()[0] == target) {
            return code; //returns the code when the target character is found
        }

        String leftCode = findCharacterCode(root.getLeft(), target, code + "0");
        if (!leftCode.equals("")) {
            return leftCode;
        }

        String rightCode = findCharacterCode(root.getRight(), target, code + "1");
        return rightCode;
    }

    private static void makeFreqDict() {
        //populates a frequency dictionary from input file
        Dictionary freqDict = new Dictionary(dictArr);
        String freqFile = "/Users/aleckain/Downloads/FreqTable-1.txt";
        freqDict.populateFromFreqFile(freqFile);
        freqDict.printDictionary(); //prints the populated dictionary
    }

    public static void printPreOrder(Node root) {
        //prints the nodes of a tree in preorder traversal
        if (root != null) {
            printArray(root.getData());
            printPreOrder(root.getLeft());
            printPreOrder(root.getRight());
        }
    }

    public static void generateEncoding(Node root) {
        //generates and prints Huffman codes for characters based on tree's node structure
        if (root == null) return;
        generateEncodingAuxiliary(root, "", 0);
    }

    private static void generateEncodingAuxiliary(Node root, String code, int freq) {
        //recursively generates and prints Huffman codes for characters, traversing down tree via left and right subtree children
        if (root == null) return;

        Object[] data = root.getData();
        if (data[0] != null) {
            System.out.println(data[0] + " = " + code); //prints the character and its code
        }

        generateEncodingAuxiliary(root.getLeft(), code + "0", freq + 1); //traverses left subtree
        generateEncodingAuxiliary(root.getRight(), code + "1", freq + 1); //traverses right subtree
    }

    public static void printArray(Object[] array) {
        //prints the content of an array
        System.out.println(Arrays.toString(array));
    }

    public static Node buildHuffmanTree(Object[][] dictArr) {
        //constructs a Huffman tree from a frequency dictionary using priority queue
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((a, b) -> (int) a.getData()[1] - (int) b.getData()[1]);
        for (Object[] data : dictArr) {
            Node node = new Node(data);
            priorityQueue.add(node); //adds nodes to priority queue
        }

        //combines nodes until a single tree remains in the priority queue, sum of prior collective node sums
        while (priorityQueue.size() > 1) {
            Node left = priorityQueue.poll();
            Node right = priorityQueue.poll();

            int sumFrequency = (int) left.getData()[1] + (int) right.getData()[1];
            Object[] parentData = {null, sumFrequency};
            Node parent = new Node(parentData);
            parent.setLeft(left);
            parent.setRight(right);

            priorityQueue.add(parent); //adds parent node back to priority queue
        }

        return priorityQueue.poll(); //returns the root of Huffman tree
    }

    public static void printHuffmanTree(Node root) {
        //prints nodes of a Huffman tree
        if (root != null) {
            printArray(root.getData()); //print the root node array
            printHuffmanTree(root.getLeft()); //prints left subtree
            printHuffmanTree(root.getRight()); //prints right subtree
        }
    }

}