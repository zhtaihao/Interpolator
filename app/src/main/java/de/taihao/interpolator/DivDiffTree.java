package de.taihao.interpolator;

import java.util.ArrayList;

import androidx.annotation.NonNull;

/**
 * Class to construct the divided difference tree (ref. Wikipedia).
 * It is necessary to know what level 'm' the highest level derivative is ('maxM'),
 * because each 'x' value will be duplicated 'm' times (ref. Wikipedia).
 * 
 * Example:
 *      x=0, f(x)=1, f'(x)=-1
 *      Then 'm' will be 1, since only the first derivative is known.
 *      If this is the case for all points to be interpolated, then 'maxM' will be set to 1.
 *      For the purpose of calculating the divided difference tree, each 'x' value will be duplicated once.
 *
 * // TODO: 26.12.2019 : implement 'calculate' method for DivDiffTree class
 */

public class DivDiffTree {
    private ArrayList<Point> points;
    private int maxM=0;

    /**
     * Constructor
     * @param points: A list of points each with an x and y value. Might contain m derivatives
     */
    public DivDiffTree(@NonNull ArrayList<Point> points) {
        this.points = points;
        for (Point p : points) if (p.getM() > maxM) maxM = p.getM();
    }

    

}
