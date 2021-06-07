# closest-points-on-sphere

This algorithm takes a number of points, which are points on the surface of earth, and returns the two points which are closest to each other.

The metric used to determine closeness is the Great Circle Distance, which takes the distance between two points along the surface of the earth.

This algorithm uses a 'divide and conquer' approach and the necessary implementation to bound the run-time to O(nlogn) where n is the number of points.


Input format:
![Screenshot 2021-06-07 222955](https://user-images.githubusercontent.com/12625705/121004173-78505900-c7e2-11eb-9b58-287e72ed232d.png)

