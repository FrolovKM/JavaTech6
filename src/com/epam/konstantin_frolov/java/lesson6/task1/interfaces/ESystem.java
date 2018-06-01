package com.epam.konstantin_frolov.java.lesson6.task1.interfaces;

import com.epam.konstantin_frolov.java.lesson6.task1.models.Something;
import java.util.*;

public interface ESystem {
    public void add(Something something);

    public void sort();

    public int getElSystemPower();

    public List<Something> findSomethingByWeight(int min, int max);
}