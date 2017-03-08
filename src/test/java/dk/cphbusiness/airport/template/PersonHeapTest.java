/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.airport.template;

import dk.cphbusiness.algorithm.examples.queues.PersonHeap;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author John
 */
public class PersonHeapTest {
    
    public static void main(String[] args) {
        Plane plane1 =  new Plane(new Time(15000));

        Passenger p1 = new Passenger(0, new Time(1001), Category.Monkey, plane1);
        Passenger p2 = new Passenger(1, new Time(2032), Category.BusinessClass, plane1);
        Passenger p3 = new Passenger(2, new Time(3043), Category.Monkey, plane1);
        Passenger p4 = new Passenger(3, new Time(4094), Category.BusinessClass, plane1);
        Passenger p5 = new Passenger(4, new Time(5005), Category.Monkey, plane1);
        Passenger p6 = new Passenger(5, new Time(6106), Category.BusinessClass, plane1);
        Passenger p7 = new Passenger(6, new Time(7037), Category.Monkey, plane1);
        Passenger p8 = new Passenger(7, new Time(8058), Category.BusinessClass, plane1);
        
        PersonHeap passengers =  new PersonHeap(10000);

        passengers.enqueue(p1);
        passengers.enqueue(p2);
        passengers.enqueue(p3);
        passengers.enqueue(p4);
        passengers.enqueue(p5);
        passengers.enqueue(p6);
        passengers.enqueue(p7);
        passengers.enqueue(p8);
        
        
        while(passengers.size() > 0) {
            Passenger p = passengers.dequeue();
            System.out.println(p.getCategory() + " - Arrival: " + p.getArrivalTime());
        }
    }
}
