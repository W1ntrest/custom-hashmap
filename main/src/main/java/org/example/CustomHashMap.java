package org.example;

import java.util.*;

public class CustomHashMap<Key, Value> {

    private static class Node<Key, Value> {
        final Key key;
        Value value;
        Node<Key, Value> next;

        Node(Key key, Value value){
            this.key = key;
            this.value = value;
        }

        public Key getKey() {
            return key;
        }
        public Value getValue() {
            return value;
        }
        public void setValue(Value value) {
            this.value = value;
        }
    }

    private Node<Key, Value>[] table;
    private int size = 0;

    private static final int DEFAULT_SIZE = 16;

    public CustomHashMap(){
        this(DEFAULT_SIZE);
    }

    public CustomHashMap(int size){
        table = (Node<Key, Value>[]) new Node[size];
    }

    private int getHash(Key key) {
        if(key == null) return 0;
        int hashcode = key.hashCode();
        hashcode = hashcode ^ (hashcode >>> 16);
        return (hashcode & 0x7FFFFFFF) % table.length;
    }

    public void put(Key key, Value value) {
        int index = getHash(key);

        if(table[index] == null){
            table[index] = new Node<>(key, value);
            size++;
            return;
        }

        Node<Key, Value> node = table[index];
        Node<Key, Value> temp = null;

        while(node != null){
            if(node.key.equals(key)){
                node.value = value;
                return;
            }
            temp = node;
            node = node.next;
        }

        temp.next = new Node<>(key, value);
        size++;
    }

    public Value get(Key key){
        int index = getHash(key);

        Node<Key, Value> node = table[index];
        while (node != null){
            if(node.key.equals(key))
                return node.value;
            node = node.next;
        }
        return null;
    }
}
