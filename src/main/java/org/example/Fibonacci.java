package org.example;

import java.math.BigInteger;

public class Fibonacci {
    public BigInteger recursive(int n) {
        if (n < 2) {
            return BigInteger.valueOf(n);
        }

        BigInteger memory[] = new BigInteger[n+1];
        return _internal_recursive(n, memory);
    }

    private BigInteger _internal_recursive(int n, BigInteger[] memory) {
        if (memory[n] != null) {
            return memory[n];
        }

        if (n < 2) {
            memory[n] = BigInteger.valueOf(n);
            return memory[n];
        }

        memory[n] = _internal_recursive(n-1, memory).add(
                _internal_recursive(n-2, memory));

        return memory[n];
    }

    public BigInteger recursive_no_optimization(int n) {
        if (n < 2) {
            return BigInteger.valueOf(n);
        }

        return recursive_no_optimization(n-1).add(recursive_no_optimization(n-2));
    }

    public BigInteger iterative(int n) {
        if (n < 2) {
            return BigInteger.valueOf(n);
        }

        BigInteger n0 = BigInteger.valueOf(0);
        BigInteger n1 = BigInteger.valueOf(1);
        BigInteger ni = BigInteger.valueOf(0);

        for (int i = 2; i <= n; ++i) {
            ni = n0.add(n1);
            // step forward
            n0 = n1;
            n1 = ni;
        }

        return ni;
    }
}
