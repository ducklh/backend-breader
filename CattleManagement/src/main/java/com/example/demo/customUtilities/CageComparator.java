package com.example.demo.customUtilities;

import com.example.demo.model.Entities;
import java.util.Comparator;

public class CageComparator implements Comparator<Entities> {

    @Override
    public int compare(Entities o1, Entities o2) {
        return o1.getOutDate().compareTo(o2.getOutDate());
    }
}
