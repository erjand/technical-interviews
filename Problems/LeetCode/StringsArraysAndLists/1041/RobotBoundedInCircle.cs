// LeetCode #1041
// https://leetcode.com/problems/robot-bounded-in-circle/
//
// On an infinite plane, a robot initially stands at (0, 0) and faces north. The robot can receive one of three instructions:
// "G":go straight 1 unit;
// "L":turn 90 degrees to the left;
// "R":turn 90 degrees to the right.
// The robot performs the instructions given in order, and then repeats them forever.
// Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.

// Time: O(n)
// Space: (1)
public class Solution {
    public enum Direction {
        North,
        South,
        East,
        West
    }

    private static int _robotX;
    private static int _robotY;
    private static Direction _robotDirection;
    
    public bool IsRobotBounded(string instructions) {
        if (instructions == null) {
            return false;
        }
        
        _robotX = 0;
        _robotY = 0;
        _robotDirection = Direction.North;
        
        foreach (char command in instructions.ToCharArray()) {
            CommandRobot(command);
        }
        
        if ((_robotX == 00 && _robotY == 0) || _robotDirection != Direction.North) {
            return true;
        }
        return false;
    }

    public static void CommandRobot(char command) {
        if (command == 'G') {
            switch (_robotDirection) {
                case Direction.North:
                    _robotY++;
                    break;
                case Direction.South:
                    _robotY--;
                    break;
                case Direction.East:
                    _robotX++;
                    break;
                case Direction.West:
                    _robotX--;
                    break;
            }
        }
        else if (command == 'L') {
            switch (_robotDirection) {
                case Direction.North:
                    _robotDirection = Direction.West;
                    break;
                case Direction.South:
                    _robotDirection = Direction.East;
                    break;
                case Direction.East:
                    _robotDirection = Direction.North;
                    break;
                case Direction.West:
                    _robotDirection = Direction.South;
                    break;
            }
        }
        else if (command == 'R') {
            switch (_robotDirection) {
                case Direction.North:
                    _robotDirection = Direction.East;
                    break;
                case Direction.South:
                    _robotDirection = Direction.West;
                    break;
                case Direction.East:
                    _robotDirection = Direction.South;
                    break;
                case Direction.West:
                    _robotDirection = Direction.North;
                    break;
            }
        }
    }
}