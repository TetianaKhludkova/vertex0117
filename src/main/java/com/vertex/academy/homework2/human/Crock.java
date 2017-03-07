package com.vertex.academy.homework2.human;

import lombok.*;

/**
 * Created by Tanya on 07.03.2017.
 */
@Getter
@AllArgsConstructor
public class Crock extends Human{
    @Setter
    private int id;
    private int amountOfTickets;
    private String gender;

    @Override
    public boolean equals(Object o) {
        return false;
    }


    @Override
    public String toString() {
        return "{"+ gender +
                " id" + id +
                ": amountOfTickets=" + amountOfTickets +
                "}\n";
    }
}