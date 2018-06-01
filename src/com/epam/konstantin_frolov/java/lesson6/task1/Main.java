package com.epam.konstantin_frolov.java.lesson6.task1;

import com.epam.konstantin_frolov.java.lesson6.task1.models.*;
import com.epam.konstantin_frolov.java.lesson6.task1.util.Connector;

import javax.jws.soap.SOAPBinding;
import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new Main().run();
    }

    private void run() throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select operation:");
        System.out.println("1 - serialize ");
        System.out.println("2 - deserialize ");

        int key = scanner.nextInt();
        if(key==1){
            this.serialize();
        }
        else
            if(key==2) {
                this.deserialize();
            }
        else System.out.println("Incorrect operation:");


        scanner.close();
    }

    private void serialize() throws IOException,ClassNotFoundException {
        ElSystem elSystem = this.foundElSystem();
        this.serializeElSystem(elSystem);
    }

    private void deserialize() throws IOException, ClassNotFoundException {
        ElSystem elSystem = this.deserializeElSystem("system.txt");
        System.out.println("ElSystem:");
        this.printSomething(elSystem.getSomething());
    }

    private ElSystem foundElSystem() {
        Kitchen kitchen = new Kitchen(100, 7, Kitchen.TypeKitchen.Owen);
        ComputerAndTV computerAndTV = new ComputerAndTV(200, 25, ComputerAndTV.TypeComputerAndTV.TV);
        SmallTech smallTech = new SmallTech(350, 2, SmallTech.TypeSmallTech.Iron);

        ElSystem elSystem = new ElSystem();

        int i = 0;
        elSystem.add(kitchen);
        elSystem.add(computerAndTV);
        elSystem.add(computerAndTV);
        elSystem.add(computerAndTV);
        elSystem.add(smallTech);
        return elSystem;
    }

    private void printSomething(List<Something> something) {
        something.forEach(this::printSomething);
        System.out.println();
    }

    private void printSomething(Something something) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(something.toString()).append("\n")
                .append("Power: ").append(something.getPower()).append("\n")
                .append("Weight: ").append(something.getWeight());
        System.out.println(stringBuilder);
    }

    private void serializeElSystem(ElSystem elSystem) throws IOException, ClassNotFoundException {
        File fileAboutElSystem = new File( "system.txt");
        Connector.printObject(fileAboutElSystem, elSystem);
    }

    private ElSystem deserializeElSystem(String fileName) throws IOException, ClassNotFoundException {
        File fileAboutElSystem = new File( fileName);
        return (ElSystem) Connector.readObject(fileAboutElSystem);
    }
}