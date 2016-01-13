package leetcode.medium;

import java.util.Iterator;

/**
 * Created by jai around 9/21/15.
 *
 * Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that
 * support the peek() operation -- it essentially peek() at the element that will be returned by the next call
 * to next().
 * Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].
 * Call next() gets you 1, the first element in the list.
 * Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
 * You call next() the final time and it returns 3, the last element. Calling hasNext() after that should return
 f alse.
 */



// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    Integer peek;
    Iterator<Integer> iter;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        peek = null;
        iter = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(peek == null) {
            if (iter.hasNext()) {
                peek = iter.next();
            }
        }
        return peek;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (peek != null) {
            Integer retval = peek;
            peek = null;
            return retval;
        }
        return iter.next();
    }

    @Override
    public boolean hasNext() {
        if (peek != null) {
            return true;
        }
        return iter.hasNext();
    }
}
