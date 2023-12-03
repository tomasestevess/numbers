package com.aor.numbers;

public class DivisibleByFilter implements GenericListFilter{
    private final int number_diviser;
    public DivisibleByFilter(int number) {this.number_diviser = number;}
    @Override
    public boolean accept(Integer number) {return number % number_diviser == 0;}
}
