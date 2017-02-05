package com.vertex.academy.homework1;/*
 * Created by Michael Rudyy on 23.01.2017.
 */

// Immutable class  (must be)

import java.util.Random;

public final class Point
{
    final int x;
    final int y;

    // TODO: 05.02.17 this logic should be in the class that is using the point, not here. 
    Random random = new Random();

    Point()
    {
        this.x=random.nextInt(25);
        this.y=random.nextInt(25);
    }

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }
}
