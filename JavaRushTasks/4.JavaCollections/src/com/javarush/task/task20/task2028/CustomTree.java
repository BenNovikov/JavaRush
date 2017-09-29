package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
1. После добавления N элементов в дерево с помощью метода add, метод size должен возвращать N.
2. После удаления последнего добавленного элемента из дерева с помощью метода remove, метод size
должен возвращать N-1.
3. После удаления второго элемента добавленного в дерево, метод size должен
возвращать N/2 + 1 (для случаев где N > 2 и является степенью двойки), N - размер дерева до удаления.
4. Метод getParent должен возвращать имя родителя для любого элемента дерева.
*/
public class CustomTree extends AbstractList implements Cloneable, Serializable {
    Entry<String> root;
    List<Entry<String>> tree;
    int line;

    public static void main(String[] args) {
        List<String> list = new CustomTree();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }
        System.out.println("Expected 3, actual is " + ((CustomTree) list).getParent("8"));
        list.remove("5");
        System.out.println("Expected null, actual is " + ((CustomTree) list).getParent("11"));
    }

    public CustomTree() {
        tree  = new LinkedList<>();
        root = new Entry<>("0");
        root.lineNumber = 0;
        tree.add(root);
        line = 0;
    }

    private int countLine(String s) {
        int result = 0;
        for (int i = 0; i <= tree.size(); ++i) {
            if (i > Math.pow(2, result) - 2)
                result++;
        }
        return result - 1;
    }

    @Override
    public boolean add(Object o) {
        String s = (String)o;
        Entry<String> child = new Entry<String>(s);
        line = countLine(s);

        ListIterator<Entry<String>> listIterator = tree.listIterator();
        while (listIterator.hasNext()) {
            Entry<String> entry = listIterator.next();

            if (entry.isAvailableToAddChildren()) {
                ConsoleHelper.writeMessage(String.format("Leaf%3s", s));
                if (entry.availableToAddLeftChildren) {
                    entry.leftChild = child;
                    entry.availableToAddLeftChildren = false;
                    ConsoleHelper.writeMessage(String.format(" added as Left  Child Of:%3s", entry.elementName));
                }
                else {
                    entry.rightChild = child;
                    entry.availableToAddRightChildren = false;
                    ConsoleHelper.writeMessage(String.format(" added as Right Child Of:%3s", entry.elementName));
                }
                child.parent = entry;
                child.lineNumber = getLine();
                ConsoleHelper.writeMessage(" in line: " + child.lineNumber);
                tree.add(child);
                return true;
            }
        }
        return false;
    }

    public int getLine() {
        return line;
    }


    @Override
    public boolean remove(Object o) {
        if (!o.equals(null)) {
            String s = o.toString();
            Entry<String> entry = findEntryByName(s);

            try {
                if (!entry.leftChild.equals(null)) {
                    this.remove(entry.leftChild.elementName);
                }
                if (!entry.rightChild.equals(null)) {
                    this.remove(entry.rightChild.elementName);
                }
            }
            catch (NullPointerException e) {
            }

            try {
                if (!entry.parent.equals(null)) {
                    if (!entry.parent.leftChild.equals(null)) {
                        if (entry.parent.leftChild.equals(entry)) {
                            entry.parent.leftChild = null;
                        }
                    }
                    if (!entry.parent.rightChild.equals(null)) {
                        if (entry.parent.rightChild.equals(entry)) {
                            entry.parent.rightChild = null;
                        }
                    }
                }
            }
            catch (NullPointerException e) {
            }

            if (tree.contains(entry))
                tree.remove(entry);
            ConsoleHelper.writeMessage(s + " removed");
            line = countLine(s);
            ConsoleHelper.writeMessage("Tree size: " + tree.size());

            return true;
        }

        return false;
    }

    public String getParent(String s) {
        Entry<String> entry = findEntryByName(s);
        if (entry != null && entry.parent != null)
                return entry.parent.elementName;

        return null;
    }

    private Entry<String> findEntryByName(String s) {
        ListIterator<Entry<String>> listIterator = tree.listIterator();
        while (listIterator.hasNext()) {
            Entry<String> currentElement = listIterator.next();
            if (currentElement.elementName.equals(s))
                return currentElement;
        }
        return null;
    }

    // возвращает текущее количество элементов в дереве.
    @Override
    public int size() {
        return tree.size() - 1;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    static class Entry<T> implements Serializable {
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        @Override
        public String toString() {
            return elementName;
        }

        public void checkChildren() {
            if (leftChild != null)
                availableToAddLeftChildren = false;
            if (rightChild != null)
                availableToAddRightChildren = false;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }
    }
}
