package com.epam.test.automation.java.practice9;

import java.text.DecimalFormat;

public class Matrix {
    private double[][] matrix;
    private int row;
    private int column;


    /**
     * Implement a constructor that creates an empty matrix with a given number of rows
     * columns (all values in matrix equal 0.0)
     *
     * @param row    number of rows
     * @param column number of columns
     * @return Returns a new instance of the matrix with the specified parameters
     */
    public Matrix(int row, int column) {
        this.row = row;
        this.column = column;
        matrix = new double[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = 0;
            }
        }

    }

    /**
     * Implement a constructor that creating of matrix based on existing two-dimensional array.
     *
     * @param twoDimensionalArray existing two-dimensional array
     * @return Returns a new instance of the matrix based on existing two-dimensional array
     * @throws MatrixException if the incoming array with zero number of rows returns the message "Array passed with zero number of rows",
     *                         if the incoming array with zero number of columns returns the message "Array passed with zero number of columns"
     */
    public Matrix(double[][] twoDimensionalArray) throws MatrixException {

        if (twoDimensionalArray.length == 0) {
            throw new MatrixException("Array passed with zero number of rows");
        }
        for (int i = 0; i < twoDimensionalArray.length; i++) {
            if (twoDimensionalArray[i].length == 0){
                throw new MatrixException("Array passed with zero number of columns");
            }
        }
    }

    /**
     * @return Returns the number of rows in a matrix
     */
    public final int rows() {
        return matrix.length;
    }

    /**
     * @return Returns the number of columns in a matrix
     */
    public final int columns() {
        return matrix[0].length;
    }

    /**
     * Receiving of standard two-dimensional array out of matrix.
     *
     * @return Standard two-dimensional array
     */
    public double[][] twoDimensionalArrayOutOfMatrix() {
        return matrix;
    }

    /**
     * Reading of elements via predetermined correct index
     *
     * @param row    number of rows
     * @param column number of columns
     * @return Returns the value of a matrix element <code>[row,column]</code>
     * @throws MatrixException if index incorrect, returns message "Incompatible matrix sizes"
     */
    public double getValue(int row, int column) throws MatrixException {
        double value;
        try {
            value = matrix[row][column];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new MatrixException("Incompatible matrix sizes");
        }

       return value;
    }

    /**
     * Recording value <code>newValue</code> of elements via predetermined correct index <code>[row,column]</code>     *
     *
     * @param row      number of rows
     * @param column   number of columns
     * @param newValue new value of a matrix element
     * @throws MatrixException if index incorrect, returns message "Incompatible matrix sizes"
     */
    public void setValue(int row, int column, double newValue) throws MatrixException {
        try {
            matrix[row][column] = newValue;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new MatrixException("Incompatible matrix sizes");
        }
    }

    /**
     * Method of matrix's addition  <code>matrix</code>.
     * Result in the original matrix
     *
     * @param matrix matrix corresponding to the second term
     * @return Returns a new resulting matrix
     * @throws MatrixException if incompatible matrix sizes, returns message "Incompatible matrix sizes"
     */
    public Matrix addition(Matrix matrix) throws MatrixException {
        Matrix resMatrix = new Matrix(this.matrix);
        if (!(resMatrix.rows() != matrix.rows())){
            throw new MatrixException("Incompatible matrix sizes");
        }
        if (resMatrix.columns() != matrix.columns()){
            throw new MatrixException("Incompatible matrix sizes");
        }
        for (int i = 0; i < resMatrix.rows(); i++) {

            for (int j = 0; j < resMatrix.columns(); j++) {
                resMatrix.setValue(i,j,(resMatrix.getValue(i,j) + matrix.getValue(i,j)));
            }
        }
        return resMatrix;
    }

    /**
     * Method of matrix's deduction <code>matrix</code> from original.
     * Result in the original matrix
     *
     * @param matrix matrix corresponding to the subtracted
     * @return Returns a new resulting matrix
     * @throws MatrixException if incompatible matrix sizes, returns message "Incompatible matrix sizes"
     */
    public Matrix subtraction(final Matrix matrix) throws MatrixException {
        //TODO: Delete line below and write your own solution;
        throw new UnsupportedOperationException();
    }

    /**
     * Method of matrix's multiplication <code>matrix</code>
     * Result in the original matrix
     *
     * @param matrix matrix corresponding to the second factor
     * @return Returns a new resulting matrix
     * @throws MatrixException if incompatible matrix sizes, returns message "Incompatible matrix sizes"
     */
    public Matrix multiplication(final Matrix matrix) throws MatrixException {
        //TODO: Delete line below and write your own solution;
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.rows(); i++) {
            for (int j = 0; j < this.columns(); j++) {
                try {
                    if (j != this.columns() - 1) {
                        builder.append(decimalFormat.format(getValue(i, j)) + " ");
                    } else {
                        builder.append(decimalFormat.format(getValue(i, j)));
                    }
                } catch (MatrixException e) {
                    e.getMessage();
                }
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}