package com.vertex.academy.exceptions;

/**
 * Created by sweet_home on 18.02.17.
 */
public class ClosableResource implements AutoCloseable {
    @Override
    public void close() throws RuntimeException {
        throw new OutOfMemoryError("try of close was interrupted");
    }
}
