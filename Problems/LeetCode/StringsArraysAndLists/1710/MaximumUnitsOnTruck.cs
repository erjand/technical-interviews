// LeetCode #1710
// https://leetcode.com/problems/maximum-units-on-a-truck/

// You are assigned to put some amount of boxes onto one truck. You are given a 2D array boxTypes, where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:
//    numberOfBoxesi is the number of boxes of type i.
//    numberOfUnitsPerBoxi is the number of units in each box of the type i.
// You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck. You can choose any boxes to put on the truck as long as the number of boxes does not exceed truckSize.
// Return the maximum total number of units that can be put on the truck.

// You can sort the jagged array with something like: 
//  Array.Sort(boxTypes, (a,b) => b[1] - a[1]);
// But it ends up being a similar algorithm.

// Time: O(n log n) on account of the List<T>.Sort call
// Space: O(n)
public class Solution {
    public int MaximumUnits(int[][] boxTypes, int truckSize) {
        List<int> unitList = new List<int>();

        int rowCount = boxTypes.GetLength(0);
        for (int i = 0; i < rowCount; i++) {
            int boxCount = boxTypes[i][0];
            int unitCount = boxTypes[i][1];

            for (int j = 0; j < boxCount; j++) {
                unitList.Add(unitCount);
            }
        }

        unitList.Sort();

        int unitsInTruck = 0;
        int boxesInTruck = 0;
        while (boxesInTruck < truckSize && unitList.Count > 0) {
            int currentBoxUnitCount = unitList[unitList.Count - 1];
            unitsInTruck += currentBoxUnitCount;
            unitList.RemoveAt(unitList.Count - 1);
            boxesInTruck++;
        }

        return unitsInTruck;
    }
}