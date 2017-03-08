/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.algorithm.examples.queues;

import dk.cphbusiness.airport.template.Passenger;
import java.util.NoSuchElementException;

/**
 *
 * @author John
 */
public class PersonHeap implements PriorityQueue<Passenger> {

    public PersonHeap(int size) {
        this.data = new Passenger[size];
    }
    
    private Passenger[] data;
    private int size = 0;

    @Override
    public void enqueue(Passenger person) {
        int p = ++size;
        data[p] = person;

        while (true) {
            int pp = parentOf(p);
            if (pp == 0 || data[p].compareTo(data[pp]) > 0) {
                break;
            } else {
                swap(p, pp);
                p = pp;
            }
        }

    }

    @Override
    public Passenger dequeue() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Passenger result = data[1];
        Passenger last = data[size];
        data[1] = last;
        size--;
        int index = 1;

        while (true) {
            int minChild = leftOf(index);
            if (data[minChild] == null || (data[rightOf(index)] != null && data[minChild].compareTo(data[rightOf(index)]) > 0)) {
                minChild = rightOf(index);
            }

            if (data[minChild] == null || data[minChild].compareTo(data[index]) > 0) {
                break;
            } else {
                swap(index, minChild);
                index = minChild;
            }
        }

        return result;
    }

    @Override
    public Passenger peek() {
        return data[1];
    }

    @Override
    public int size() {
        return this.size;
    }

    private int parentOf(int p) {
        return p / 2;
    }

    private void swap(int p, int pp) {
        data[0] = data[pp];
        data[pp] = data[p];
        data[p] = data[0];
    }

    private int leftOf(int p) {
        return p * 2;
    }

    private int rightOf(int p) {
        return ((p * 2) + 1);
    }

}
