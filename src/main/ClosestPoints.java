package main;

import conversions.Constants;
import conversions.Distance;
import io.InputData;
import io.OutputData;

public class ClosestPoints {

    private Point closestPointA;
    private Point closestPointB;
    private double shortestDistance;

    public ClosestPoints() {
        closestPointA = null;
        closestPointB = null;
        shortestDistance = Double.MAX_VALUE;
    }

    /**
     * Finds the two closest points by great circle distance from a set of points.
     */
    public OutputData findClosestPoints(InputData inputData) {
        int numPoints = inputData.getNumPoints();
        Point[] pointsByLatitude = inputData.getPointsByLatitude();
        Point[] pointsByDepth = inputData.getPointsByLatitudeCopy();
        Point[] helper = new Point[numPoints];

        //ensure starting state is correct
        closestPointA = null;
        closestPointB = null;
        shortestDistance = Double.MAX_VALUE;

        recursiveFindClosestPoints(pointsByLatitude, pointsByDepth, helper, 0, numPoints-1);
        return new OutputData(closestPointA, closestPointB, shortestDistance);
    }

    private void recursiveFindClosestPoints(Point[] pointsByLatitude, Point[] pointsByDepth, Point[] helper, int startIndex, int endIndex) {
        if (endIndex <= startIndex) {
            return;
        }

        int midIndex = (startIndex + endIndex)/2;
        Point midLine = pointsByLatitude[midIndex];
        recursiveFindClosestPoints(pointsByLatitude, pointsByDepth, helper, startIndex, midIndex);
        recursiveFindClosestPoints(pointsByLatitude, pointsByDepth, helper, midIndex+1, endIndex);
        mergeByDepth(pointsByDepth, helper, startIndex, midIndex, endIndex);

        //If points vertical distance is within shortestDistance of the midLine, it may be closer to another point
        //that is on the other side of the midLine.
        int count = 0;
        for(int i = startIndex; i <= endIndex; i++){
            if((Math.abs(pointsByDepth[i].getLatitude() - midLine.getLatitude()) * Constants.kmPerDegreeLatitude) < shortestDistance) {
                helper[count++] = pointsByDepth[i];
            }
        }

        //Compute whether points within the strip are closer than the shortestDistance.
        //The exit condition ensures that this algorithm runs in O(nlogn)
        for(int i = 0; i < count; i++){
            for(int j = i+1; (j < count) && Math.abs(helper[i].getDepth() - helper[j].getDepth()) < shortestDistance; j++) {
                double distance = Distance.greatCircleDistance(helper[i], helper[j]);
                if (distance < shortestDistance){
                    closestPointA = helper[i];
                    closestPointB = helper[j];
                    shortestDistance = distance;
                }
            }
        }
    }

    /**
     * Let a conceptual array be a set of consecutive elements within an array.
     * Runs merge on the two conceptual arrays in pointsByDepth: [start, mid] and [mid+1, end]
     * To create one conceptual array between [start, end] that is sorted by depth.
     */
    private static void mergeByDepth(Point[] pointsByDepth, Point[] helper, int start, int mid, int end) {
        for(int i = start; i <= end; i++){
            helper[i] = pointsByDepth[i];
        }

        int i = start, j = mid+1;
        for(int k = start; k <= end; k++){
            if (i > mid) {
                pointsByDepth[k] = helper[j++];
            } else if(j > end) {
                pointsByDepth[k] = helper[i++];
            } else if (Double.compare(helper[j].getDepth(), helper[i].getDepth()) < 0) {
                pointsByDepth[k] = helper[j++];
            } else {
                pointsByDepth[k] = helper[i++];
            }
        }
    }
}
