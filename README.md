# closest-points-on-sphere

This algorithm takes a number of points, which are points on the surface of earth, and returns the two points which are closest to each other.

The metric used to determine closeness is the Great Circle Distance, which takes the distance between two points along the surface of the earth.

This algorithm uses a 'divide and conquer' approach and the necessary implementation to bound the run-time to O(nlogn) where n is the number of points.


Input format:
![image](https://user-images.githubusercontent.com/12625705/121004080-59ea5d80-c7e2-11eb-988f-f0485e0d7ec4.png)
