package com.javarush.task.task21.task2108;

/* 
Клонирование растений
*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try {
            clone = tree.clone();
        } catch (Exception /*|CloneNotSupportedException*/ e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);
    }

    public static class Plant {
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public Plant clone() {
            return new Plant(this.name);
        }
    }

    public static class Tree extends Plant implements Cloneable {
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
            //this.branches;// = branches;
        }

        public String[] getBranches() {
            return branches;
        }

        @Override
        public Tree clone() {
            String[] branchesClone = Arrays.copyOf(this.branches, this.branches.length);

            return new Tree(this.getName(), branchesClone);
        }

        /*
                @Override
        protected Object clone() throws CloneNotSupportedException {
            return new Tree(getName(), branches == null ? null : branches.clone());
        }
        * */
    }


}
