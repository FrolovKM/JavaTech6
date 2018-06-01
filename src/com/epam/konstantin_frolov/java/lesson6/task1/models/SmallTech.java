package com.epam.konstantin_frolov.java.lesson6.task1.models;

public class SmallTech extends Something{
    public enum TypeSmallTech {
        VacuumCleaner,
        Iron,
    }

    private TypeSmallTech type = null;

    public SmallTech(Integer power, Integer weight, TypeSmallTech type) {
        super(power, weight);
        this.type = type;
    }

    public TypeSmallTech getType() {
        return type;
    }

    public void setType(TypeSmallTech type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "[Object] SmallTech";
    }
}