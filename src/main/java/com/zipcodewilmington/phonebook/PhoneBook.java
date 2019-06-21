package com.zipcodewilmington.phonebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    private Map<String, List<String>> book;
    public PhoneBook(Map<String, List<String>> map) {
        this.book = map;
    }

    public PhoneBook() {
        this(null);
    }

    public void add(String name, String phoneNumber) {
        List<String> numbers = book.get(name);
        if(numbers != null){
            numbers.add(phoneNumber);
        }
    }

    public void addAll(String name, String... phoneNumbers) {
        List<String> numbers = book.get(name);
        if(numbers != null){
            for(String number : phoneNumbers){
                numbers.add(number);
            }
        }
    }

    public void remove(String name) {
        book.remove(name);
    }

    public Boolean hasEntry(String name) {
        return book.containsKey(name);
    }

    public List<String> lookup(String name) {
        return book.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        for(Map.Entry<String, List<String>> entry : book.entrySet()){
            for(String string : entry.getValue()){
                if(string.equals(phoneNumber)){
                    return entry.getKey();
                }
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        List<String> names = new ArrayList<>();
        for(String name : book.keySet()){
            names.add(name);
        }
        return names;
    }

    public Map<String, List<String>> getMap() {
        return book;
    }
}
