/**
 * QuantityMeasurementApp - UC1: Feet Measurement Equality
 *
 * This application compares two numerical values measured in feet.
 * It ensures accurate equality checks using proper floating-point comparison.
 *
 * Features:
 * - Immutable Feet value object
 * - Safe equality comparison using Double.compare()
 * - Handles null and type safety checks
 *
 * Author: Sajani G
 * Version: 1.0
 */
package com.apps.quantitymeasurement;
public class QuantityMeasurementApp {
    public static class Feet {
        private final double value;
        public Feet(double value){this.value=value;}
        public double getValue(){return value;}
        @Override
        public boolean equals(Object obj){
            if(this==obj)return true;
            if(obj==null)return false;
            if(getClass()!=obj.getClass())return false;
            Feet other=(Feet)obj;
            return Double.compare(this.value,other.value)==0;
        }
        @Override
        public int hashCode(){return Double.hashCode(value);}
    }

    public static void main(String[] args){
        Feet f1=new Feet(1.0);
        Feet f2=new Feet(1.0);
        System.out.println(f1.equals(f2));
    }
}
