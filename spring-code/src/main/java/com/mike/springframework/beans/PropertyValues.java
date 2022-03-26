package com.mike.springframework.beans;

import java.util.ArrayList;
import java.util.Optional;

public class PropertyValues {
    private final ArrayList<PropertyValue> ppValueArrayList = new ArrayList<PropertyValue>();

    public void addProtertyValue(PropertyValue pv) {
        this.ppValueArrayList.add(pv);
    }

    public PropertyValue[] getPpValueArrayList() {
        return ppValueArrayList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getProterty(String name) {
        Optional<PropertyValue> any = ppValueArrayList.stream().filter(pp -> {
            if (pp.getName().equals(name)) {
                return true;
            }
            return false;
        }).findAny();
        return any.get();
    }
}
