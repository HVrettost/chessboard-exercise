# ALGORITHM

#Visualization of the Chessboard

```A8 B8 C8 D8 E8 F8 G8 H8     (7,0) (7,1) (7,2) (7,3) (7,4) (7,5) (7,6) (7,7)
A7 B7 C7 D7 E7 F7 G7 H7     (6,0) (6,1) (6,2) (6,3) (6,4) (6,5) (6,6) (6,7)
A6 B6 C6 D6 E6 F6 G6 H6     (5,0) (5,1) (5,2) (5,3) (5,4) (5,5) (5,6) (5,7)
A5 B5 C5 D5 E5 F5 G5 H5     (4,0) (4,1) (4,2) (4,3) (4,4) (4,5) (4,6) (4,7)
A4 B4 C4 D4 E4 F4 G4 H4     (3,0) (3,1) (3,2) (3,3) (3,4) (3,5) (3,6) (3,7)
A3 B3 C3 D3 E3 F3 G3 H3     (2,0) (2,1) (2,2) (2,3) (2,4) (2,5) (2,6) (2,7)
A2 B2 C2 D2 E2 F2 G2 H2     (1,0) (1,1) (1,2) (1,3) (1,4) (1,5) (1,6) (1,7)
A1 B1 C1 D1 E1 F1 G1 H1     (0,0) (0,1) (0,2) (0,3) (0,4) (0,5) (0,6) (0,7) -> CartesianPair

Problem:
- User gives STARTING POSITION
- User gives ENDING POSITION
- Knight piece only moves in L-shape

Description:
Calculate all possible paths that could take to the knight to reach the ending position in 3 moves. 
If no solution is found present appropriate message

Solution
- validation on the input of the user for starting position and ending position
- validation on whether the starting position is the same as the ending position

How the knight moves -> implement the algorithm in helper
example:
START D4, D4 (3,3) (i, j)
          D4 -> B5 (4,1) (i+1, j-2)
          D4 -> E6 (5,4) (i+2, j+1)
          D4 -> E2 (1,4) (i-2, j+1)
          D4 -> C2 (1,2) (i-2, j-1)
          D4 -> F5 (4,5) (i+1, j+2)
          D4 -> F3 (2,5) (i-1, j+2)
          D4 -> B3 (2,1) (i-1, j-2)
          D4 -> C6 (5,2) (i+2, j-1)

1) Assuming it's D4 calculate all possible next steps(if they exist)
2) If one of the next steps is the ending position then add it in the path list 
3) Make the above algorithm run in 3fold for loop
```
# HOW TO RUN THE EXERCISE
In the root folder of the project run
- ./gradlew clean build
- java -jar build/libs/XmChessboard-1.0-SNAPSHOT.jar