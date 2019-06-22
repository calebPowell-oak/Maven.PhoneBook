package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    private Map<String, List<String>> map;
    private ArrayList<String> keys;

    public PhoneBook(Map<String, List<String>> map) {
        this.map = new HashMap<String, List<String>>();
        this.keys = new ArrayList<String>();
    }

    public PhoneBook() {
        this(null);
        this.keys = new ArrayList<String>();
    }

    public void add(String name, String phoneNumber) {
        if(map.get(name) != null){
            map.get(name).add(phoneNumber);
        } else {
            map.put(name, new ArrayList<String>());
            map.get(name).add(phoneNumber);
            keys.add(name);
        }
    }

    public void addAll(String name, String... phoneNumbers) {
        if(map.get(name) != null){
            for(String number : phoneNumbers){
                map.get(name).add(number);
            }
        } else {
            for(String number : phoneNumbers){
                add(name, number);
            }
        }
    }

    public void remove(String name) {
        map.remove(name);
        keys.remove(name);
    }

    public Boolean hasEntry(String name) {
        if(map.containsKey(name)){return true;}
        else {
            for(List<String> list : map.values()){
                if(list.contains(name)){return true;}
            }
        }
        return false;
    }

    public List<String> lookup(String name) {
        return map.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            for(String q : entry.getValue()){
                if(q.equals(phoneNumber)){return entry.getKey();}
            }
        }
        return "";
    }

    public List<String> getAllContactNames() {
        return keys;
    }

    public Map<String, List<String>> getMap() {
        return map;
    }
}
