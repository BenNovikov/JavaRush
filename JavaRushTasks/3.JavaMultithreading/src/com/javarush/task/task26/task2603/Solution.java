package com.javarush.task.task26.task2603;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

/*
Убежденному убеждать других не трудно
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static class CustomizedComparator<T> implements Comparator<T> {
        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator<T>... comparators) {
            this.comparators = comparators;
        }

        @Override
        public int compare(T o1, T o2) {
            Optional<Comparator<T>> optional = Arrays.stream(comparators)
                    .filter(comparator -> (compare(o1, o2) != 0))
                    .findFirst();
            return optional.isPresent() ? optional.get().compare(o1, o2) : 0;

            //the same
//            int result = 0;
//            for (Comparator comparator : comparators) {
//                result = comparator.compare(o1, o2);
//                if (result != 0) {
//                    break;
//                }
//            }
//            return result;
        }
    }
}
