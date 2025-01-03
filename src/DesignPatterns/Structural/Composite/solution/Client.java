package DesignPatterns.Structural.Composite.solution;

import java.util.ArrayList;
import java.util.List;

//?When to Use It:
//! When you have a hierarchical structure of objects, such as a tree, and need to treat individual objects and groups of objects uniformly.
//! When objects in your system can be composed into a tree-like structure to represent part-whole relationships.
//*Benefits:
//*Uniformity: Treats individual objects and composites uniformly.
//*Scalability: Easily adds new types of components without altering existing code.
//*Simplified Client Code: Client code doesn't need to distinguish between individual and composite objects.// Leaf class: File

class File implements FileSystemComponent {
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println("File: " + name);
    }
}

// Composite class: Folder
class Folder implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> components = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    @Override
    public void display() {
        System.out.println("Folder: " + name);
        for (FileSystemComponent component : components) {
            component.display();
        }
    }
}

// Client
public class Client {
    public static void main(String[] args) {
        // Create files
        File file1 = new File("Resume.pdf");
        File file2 = new File("CoverLetter.docx");

        // Create folder
        Folder documents = new Folder("Documents");

        // Add files to folder
        documents.addComponent(file1);
        documents.addComponent(file2);

        // Create subfolder and add components
        Folder subFolder = new Folder("Photos");
        subFolder.addComponent(new File("Photo1.jpg"));
        subFolder.addComponent(new File("Photo2.png"));

        // Add subfolder to main folder
        documents.addComponent(subFolder);

        // Display hierarchy
        documents.display();
    }
}
