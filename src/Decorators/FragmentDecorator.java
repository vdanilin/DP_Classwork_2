package Decorators;

import CheckPolicies.ICheck;
import Drawable.ICurve;
import Drawable.IPoint;

/**
 * Created by Vasily Danilin on 11.11.2017.
 */
public class FragmentDecorator extends ACurveDecorator {
    private double start;
    private double finish;
    private double interval;

    public FragmentDecorator(ICurve component, double start, double finish) {
        super(component);
        this.start = start;
        this.finish = finish;
        this.interval = finish-start;
    }

    @Override
    public IPoint getPoint(double t) {
        return super.getPoint(t * interval + start);
    }

    @Override
    public double getLength(double t, ICheck checker) {
        //System.out.println("Warning! getLength function isn't overridden for fragmentDecorator");
        return super.getLength(t, checker);
    }
}
