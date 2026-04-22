package org.example;

import java.util.*;

public class CustomHashMap<Key, Value> implements Iterable<CustomHashMap.Node<Key, Value>> {

    public static class Node<Key, Value> {
        final Key key;
        Value value;
        Node<Key, Value> next;

        Node(Key key, Value value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private Node<Key, Value>[] table;
    private int countElements = 0;
    private int sizeTable = DEFAULT_SIZE;

    private static final int DEFAULT_SIZE = 16;

    public CustomHashMap(){
        this(DEFAULT_SIZE);
    }

    public CustomHashMap(int sizeTable){
        this.sizeTable = sizeTable;
        table = (Node<Key, Value>[]) new Node[sizeTable];
    }

    private int getHash(Key key) {
        if(key == null) return 0;
        int hashcode = key.hashCode();
        hashcode = hashcode ^ (hashcode >>> 16);
        return (hashcode & 0x7FFFFFFF) % table.length;
    }

    public Value put(Key key, Value value) {
        int index = getHash(key);

        if(table[index] == null){
            table[index] = new Node<>(key, value);
            countElements++;
            return null;
        }

        Node<Key, Value> node = table[index];
        Node<Key, Value> temp = null;

        while(node != null){
            if(node.key.equals(key)){
                Value tempValue = node.value;
                node.value = value;
                return tempValue;
            }
            temp = node;
            node = node.next;
        }

        temp.next = new Node<>(key, value);
        countElements++;
        return null;
    }

    public Value putIfAbsent(Key key, Value value){
        int index = getHash(key);

        if(table[index] == null){
            table[index] = new Node<>(key, value);
            countElements++;
            return null;
        }

        Node<Key, Value> node = table[index];
        Node<Key, Value> temp = null;

        while(node != null){
            if(node.key.equals(key)){
                return node.value;
            }
            temp = node;
            node = node.next;
        }

        temp.next = new Node<>(key, value);
        countElements++;
        return null;
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

    public Value getOrDefault(Key key, Value defaultValue){
        Value value = get(key);
        return value != null ? value : defaultValue;
    }

    public Value remove(Key key) {
        int index = getHash(key);

        Node<Key, Value> node = table[index];

        if (node == null)
            return null;

        if(node.key.equals(key)) {
            Value value = node.value;
            table[index] = node.next;
            countElements--;
            return value;
        }

        Node<Key, Value> temp = node.next;

        while(temp != null) {
            if(temp.key.equals(key)){
                Value value = temp.value;
                node.next = temp.next;
                countElements--;
                return value;
            }
            node = temp;
            temp = node.next;
        }

        return null;
    }

    public void clear(){
        countElements = 0;
        table = (Node<Key, Value>[]) new Node[sizeTable];
    }

    public boolean containsKey(Key key) {
        int index = getHash(key);

        Node<Key, Value> node = table[index];
        while(node != null) {
            if(node.key.equals(key))
                return true;
            node = node.next;
        }

        return false;
    }

    public boolean containsValue(Value value){
        for (Node<Key, Value> keyValueNode : table) {
            Node<Key, Value> node = keyValueNode;
            while (node != null) {
                if (node.value.equals(value))
                    return true;
                node = node.next;
            }
        }

        return false;
    }

    public boolean isEmpty() {
        return countElements == 0;
    }

    public int getSize() {
        return countElements;
    }

    private class NodeIterator implements Iterator<Node<Key, Value>> {
        private int indexTable = 0;
        private Node<Key, Value> node = null;
        private int countEl = countElements;

        private void getNode() {
            if (node != null && node.next != null) {
                node = node.next;
                return;
            }

            node = null;
            while (indexTable < table.length && node == null) {
                node = table[indexTable];
                indexTable++;
            }
        }

        @Override
        public boolean hasNext() {
            return countEl > 0;
        }

        @Override
        public Node<Key, Value> next() {
            getNode();
            countEl--;
            return new Node<>(this.node.key, this.node.value);
        }
    }

    @Override
    public Iterator<Node<Key, Value>> iterator() {
        return new NodeIterator();
    }
}
