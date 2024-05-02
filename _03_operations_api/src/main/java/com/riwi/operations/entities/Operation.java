package com.riwi.operations.entities;

public class Operation {
    private int num1;
    private int num2;

    // getters 
    public int getNum1() {
        return num1;
    }
    public int getNum2() {
        return num2;
    }
   

    // setters 
    public void setNum1(int num1) {
        this.num1 = num1;
    }
    public void setNum2(int num2) {
        this.num2 = num2;
    }

    // constructor vacio 

    public Operation() {
    }


    // constructor 
    public Operation(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    // to Strgin
    @Override
    public String toString() {
        return "Operation [num1=" + num1 + ", num2=" + num2 + "]";
    }


    
}

