package com.riwi.operations.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.operations.entities.Operation;

@RestController
@RequestMapping("/api/v1/operations")
public class OperationController {


    @PostMapping("/sum") // Con el POStmapping podemos asignar subRutas a cada metodo
    public String sum(@RequestBody Operation objOperation){

        int num1 = objOperation.getNum1();
        int num2 = objOperation.getNum2();

        return num1 + "+" + num2 + "=" + (num1+num2);
    }

    @PostMapping("/rest")
    public String rest(@RequestBody Operation objOperation){

        int num1 = objOperation.getNum1();
        int num2 = objOperation.getNum2();

        return num1 + "-" + num2 + "=" + (num1-num2);
    }

    @PostMapping("/div")
    public String div(@RequestBody Operation objOperation){

        int num1 = objOperation.getNum1();
        int num2 = objOperation.getNum2();

        if (num2 == 0) {
            return "El numero divisor no puede ser 0";
        }else {
            return num1 + "/" + num2 + "=" + (num1/num2);
        }
        
    }

    @PostMapping("/compara")
    public String compara(@RequestBody Operation objOperation){

        int num1 = objOperation.getNum1();
        int num2 = objOperation.getNum2();

        if (num1<num2) {
            return num2 + " es el numero mayor";
        } else if (num2<num1) {
            return num1 +  " es el numero mayor";
        }else{
            return "los numeros son iguales";
        }
    }
    
}
