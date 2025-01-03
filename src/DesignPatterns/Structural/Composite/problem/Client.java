package DesignPatterns.Structural.Composite.problem;

import java.util.ArrayList;
import java.util.List;

//?Concept Explanation:
//? lets you compose objects into tree structures to represent part-whole hierarchies.
//? You can treat individual objects and compositions of objects uniformly by defining a common interface.
//*Cons:
//*Complexity: Introduces additional complexity for simpler structures.
//*Overhead: May introduce overhead if the hierarchy is shallow or rarely changes.
class File {
    private String name;

    public File(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("File: " + name);
    }
}

class Folder {
    private String name;
    private List<File> files = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void addFile(File file) {
        files.add(file);
    }

    public void display() {
        System.out.println("Folder: " + name);
        for (File file : files) {
            file.display();
        }
    }
}

public class Client {
    public static void main(String[] args) {
        Folder folder = new Folder("Documents");
        folder.addFile(new File("Resume.pdf"));
        folder.addFile(new File("CoverLetter.docx"));
        folder.display();
    }
}
//Problem:
//The Folder class handles only File objects.
//Adding subfolders or handling nested structures becomes complex and requires additional logic.