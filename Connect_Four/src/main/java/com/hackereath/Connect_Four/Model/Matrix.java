package com.hackereath.Connect_Four.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Matrix {

    private static int[][] matrix;
    private final UUID id;
    private static char color;

    public Matrix(@JsonProperty("id") UUID id, @JsonProperty("matrix") int[][] matrix,@JsonProperty("color") char color) {
        this.id = id;
        this.matrix = matrix;
        this.color = color;
    }

    public UUID getId() {
        return id;
    }

    public int[][] getBox() {
        return matrix;
    }

    public char getColor() {
        return color;
    }

    public void setColor(char color)
    {
        this.color = color;
    }
    public void setMatrix(int[][] matrix)
    {
        this.matrix = matrix;
    }

}
