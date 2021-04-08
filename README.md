# ΑΛΓΟΡΙΘΜΟΣ

#Visualization της σκακιέρας

A8 B8 C8 D8 E8 F8 G8 H8     (7,0) (7,1) (7,2) (7,3) (7,4) (7,5) (7,6) (7,7)
A7 B7 C7 D7 E7 F7 G7 H7     (6,0) (6,1) (6,2) (6,3) (6,4) (6,5) (6,6) (6,7)
A6 B6 C6 D6 E6 F6 G6 H6     (5,0) (5,1) (5,2) (5,3) (5,4) (5,5) (5,6) (5,7)
A5 B5 C5 D5 E5 F5 G5 H5     (4,0) (4,1) (4,2) (4,3) (4,4) (4,5) (4,6) (4,7)
A4 B4 C4 D4 E4 F4 G4 H4     (3,0) (3,1) (3,2) (3,3) (3,4) (3,5) (3,6) (3,7)
A3 B3 C3 D3 E3 F3 G3 H3     (2,0) (2,1) (2,2) (2,3) (2,4) (2,5) (2,6) (2,7)
A2 B2 C2 D2 E2 F2 G2 H2     (1,0) (1,1) (1,2) (1,3) (1,4) (1,5) (1,6) (1,7)
A1 B1 C1 D1 E1 F1 G1 H1     (0,0) (0,1) (0,2) (0,3) (0,4) (0,5) (0,6) (0,7) -> CartesianPair

Map<String, String> placeToCartesianMap
A1 -> 0,0
A8 -> 7,0

User gives STARTING POSITION
User gives ENDING POSITION

Knight piece only moves in L-shape

CALCULATE ALL POSSIBLE PATHS THAT COULD TAKE TO THE KNIGHT TO REACH THE ENDING POSITION IN 3 MOVES

- check να δω τι βάζει ο χρήστης και αν η αρχική θέση και η τελική θέση ειναι valid.
- check να δω ότι αυτό που βάζει δεν συμπίπτει με την αρχική θέση
(για τα check κάνω iterate τα keys του map, ίσως και enumeration)

H κίνηση του knight:

START D4, D4 (3,3) (i, j)
          D4 -> B5 (4,1) (i+1, j-2)
          D4 -> E6 (5,4) (i+2, j+1)
          D4 -> E2 (1,4) (i-2, j+1)
          D4 -> C2 (1,2) (i-2, j-1)
          D4 -> F5 (4,5) (i+1, j+2)
          D4 -> F3 (2,5) (i-1, j+2)
          D4 -> B3 (2,1) (i-1, j-2)
          D4 -> C6 (5,2) (i+2, j-1)

Υπολογίζω το καρτεσιανό που έχει επιλέξει ο χρήστης.

1) έστω ότι ειναι το D4, Υπολογίζω όλα τα πιθανά σενάρια, όπως βλέπουμε πιο πάνω, αν κάποια δεν υπάρχει δεν το υπολογίζουμε
2) Αν μια από τις εγγραφές έχει υπολογιστεί και συμπέφτει με το ending point τότε επέστρεψε την λίστα και κάνε την print

Για το κάθε ένα από αυτά, υπολογίζω το επόμενο step:

List<String> finalPathList = ...
StringBuilder sb = null;

for (String chessboardPosition : calculateNextStepBoardingPositionsWithGivenPosition(STARTINGPOINT)) {
  sb = new StringBuilder(STARTINGPOINT);
  if (chessboardPosition == ENDINGPOINT) {
    finalPathList.add(sb.append(" -> " + chessboardPosition));
  }
  continue;
  for (String chessboardPosition2 : calculateNextStepBoardingPositionsWithGivenPosition(chessboardPosition)) {
    if (chessboardPosition2 == ENDINGPOINT) {
      finalPathList.add(sb.append(" -> " + chessboardPosition2))
    }
    continue;
    for (String chessboardPosition3 : calculateNextStepBoardingPositionsWithGivenPosition(chessboardPosition2)) {
      if (chessboardPosition3 == ENDINGPOINT)
        finalPathList.add(sb.append(" -> " + chessboardPosition3))
    }
  }

 
}

int counter = 1;
String position  = STARTINGPOINT;
int timesToIterate = 3;

String calculateNextPositions(int counter, String position) {
  if (counter == 3) {
    end process temporarily;
  }

  for (String chessboardPosition : calculateNextStepBoardingPositionsWithGivenPosition(position)) {
    sb = new StringBuilder(position);
    if (chessboardPosition == ENDINGPOINT) {
      finalPathList.add(sb.append(" -> " + chessboardPosition));
      counter++;
      continue;
    }
  }
  makeCalculation(counter, chessboardPosition);
}

