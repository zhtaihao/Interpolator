package de.taihao.interpolator;

public class Point {
    private double x; // x coordinate
    private double[] f; // y coordinate and derivatives f(x), f'(x), ...
    private int m; // amount of derivatives known for this specific x

    /**
     * Constructor
     * @param x x coordinate of a given value pair
     * @param f y coordinate f(x) at f[0], the n-th derivative f^(n)(x) of x at f[n]
     */
    public Point(double x, double[] f) {
        this.x = x;
        this.f = f;
        m = f.length -1;
    }

    public int getM() {
        return m;
    }

}
