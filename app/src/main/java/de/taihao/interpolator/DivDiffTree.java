package de.taihao.interpolator;

import java.util.ArrayList;

import androidx.annotation.NonNull;

/**
 * Class to construct the divided difference tree (ref. Wikipedia).
 * It is necessary to know what level 'm' the highest level derivative is ('maxM'),
 * because each 'x' value will be duplicated 'm' times (ref. Wikipedia).
 * <p>
 * Example:
 * x=0, f(x)=1, f'(x)=-1
 * Then 'm' will be 1, since only the first derivative is known.
 * If this is the case for all points to be interpolated, then 'maxM' will be set to 1.
 * For the purpose of calculating the divided difference tree, each 'x' value will be duplicated once.
 * <p>
 * // TODO: 26.12.2019 : implement 'calculate' method for DivDiffTree class
 */

public class DivDiffTree {
    private ArrayList<Point> points;
    private int maxM = 0;

    /**
     * Constructor
     *
     * @param points: A list of points each with an x and y value. Might contain m derivatives
     */
    public DivDiffTree(@NonNull ArrayList<Point> points) {
//        this.points = points;
//        for (Point p : points) if (p.getM() > maxM) maxM = p.getM();
//        double[][] treeValues = new double[maxM][];
//        for (Point p : points) {
//            for (int i = 0; i < p.getM(); i++) {
//                treeValues[i][0] = p.getX();
//            }
//        }
    }

    /**
     * Method to perform the mathematical aspect of the divided difference formula.
     * First checks if entirely identical points were entered;
     * in that case, there is no clearly defined divided difference (division by zero would occur).
     * Instead it will return the n-th derivative of that single point,
     * where n is the amount of points entered (ref. Wikipedia).
     *
     * @param points an ArrayList of points, may be several identical ones
     * @return returns the calculated divided difference of those points,
     *      outputs the n-th derivative instead if "one" point was entered
     */
    public double getDivDiff(@NonNull ArrayList<Point> points) {
        int amountOfPoints = points.size();
        double result = 0;
        boolean allPointsEqual = false;

        for (Point p : points) if (p.equals(points.get(0))) allPointsEqual = true;


        if (allPointsEqual) return points.get(0).getF()[amountOfPoints];
        else {
            for (Point p : points) {
                double denominator = 1;
                for (int k = 0; k < amountOfPoints; k++) {
                    if (k != points.indexOf(p)) {
                        denominator *= (p.getX() - points.get(k).getX());
                    }
                }
                result += p.getF()[0] / denominator;
            }
        }
        return result;
    }


}
