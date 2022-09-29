package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable
{
    Entry<String> root;

    public CustomTree()
    {
        root = new Entry<>("0");
        root.newLineRootElement = true;
        root.lineNumber = 0;
    }

    @Override
    public int size()
    {
        Stack<Entry<String>> stack = new Stack<>();
        stack.push(root);

        int count = -1;

        while(!stack.isEmpty()){
            Entry<String> node = stack.pop();

            ++count;

            if(node.leftChild != null)
                stack.push(node.leftChild);

            if(node.rightChild != null)
                stack.push(node.rightChild);
        }

        return count;
    }

    @Override
    public String get(int index)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(String element)
    {
        Entry<String> x = root;
        Entry<String> newNode = new Entry<>(element);

        ArrayDeque<Entry<String>> stack = new ArrayDeque<>();
        stack.push(root);

        while(!stack.isEmpty()){
            Entry<String> node = stack.getLast();
            stack.remove(node);

            if(node.leftChild != null)
                stack.addFirst(node.leftChild);
            else if(node.rightChild == null)//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            {
                node.leftChild = newNode;
                node.leftChild.parent = node;
                break;
            }

            if(node.rightChild != null)
                stack.addFirst(node.rightChild);
            else
            {
                node.rightChild = newNode;
                node.rightChild.parent = node;
                break;
            }
        }
        return true;
    }

    @Override
    public String remove(int index)
    {
        throw new UnsupportedOperationException();
    }

    public boolean remove(Object o) throws UnsupportedOperationException
    {
        if (!o.getClass().getSimpleName().equals("String"))
            throw new UnsupportedOperationException();

        Entry<String> newNode = new Entry<>(o.toString());

        ArrayDeque<Entry<String>> stack = new ArrayDeque<>();
        stack.push(root);

        while(!stack.isEmpty()){
            Entry<String> node = stack.getLast();
            stack.remove(node);

            if(node.elementName.equals(newNode.elementName))
            {
                ArrayDeque<Entry<String>> stack1 = new ArrayDeque<>();
                stack1.push(node);

                while(!stack1.isEmpty()){
                    Entry<String> node1 = stack1.getLast();
                    stack1.remove(node1);

                    if(node1.leftChild != null)
                        stack1.addFirst(node1.leftChild);


                    if(node1.rightChild != null)
                        stack1.addFirst(node1.rightChild);

                    if(node1.parent.leftChild == node)
                        node1.parent.leftChild = null;
                    else
                        node1.parent.rightChild = null;

                    node1.parent = null;
                    node1.leftChild = null;
                    node1.rightChild = null;
                    node1 = null;
                }

                return true;
            }

            if(node.leftChild != null)
                stack.addFirst(node.leftChild);


            if(node.rightChild != null)
                stack.addFirst(node.rightChild);
        }
        return false;
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c)
    {
        throw new UnsupportedOperationException();
    }

    public String getParent(String s){
        ArrayDeque<Entry<String>> stack = new ArrayDeque<>();
        stack.push(root);

        String parentName = null;

        while(!stack.isEmpty())
        {
            Entry<String> node = stack.pop();

            if(node.elementName.equals(s))
            {
                parentName = node.parent.elementName;
                break;
            }

            if(node.leftChild != null)
                stack.push(node.leftChild);

            if(node.rightChild != null)
                stack.push(node.rightChild);
        }

        return parentName;

    }

    static class Entry<T> implements Serializable
    {
        int lineNumber;
        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        boolean newLineRootElement;
        Entry<T> parent, leftChild, rightChild;

        private Entry(String elementName)
        {
            this.elementName = elementName;
            newLineRootElement = false;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return this.availableToAddRightChildren || this.availableToAddLeftChildren;
        }
    }
}
