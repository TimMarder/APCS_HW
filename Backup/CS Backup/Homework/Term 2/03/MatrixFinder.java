// Team Beasts -- Tim Marder, William Lu, Max Millar
// Tim Marder
// APCS2 pd02
// HW#03 -- I Am Still Searching
// 2018-02-02

/*
We begin by defining two variables "rowCheck" and "colCheck" which will
hold the int index of the current row and column of the element that is
being looked at and compared to the target value. Those values will be
modified throughout the algorithm in order for the search method to go
through the correct elements in the correct order. Our algorithm starts
by comparing the target with the bottom left number in the 2D array. For
this to happen we set the rowCheck value to matrix.length - 1 so that the
element being looked at is in the very last row of the matrix and the
colCheck value is set to 0 so that the element being looked is in the very
first column of the matrix (resulting in the first element being looked
at to be the bottom left one). If the number is greater than the target,
the next spot compared will be 1 row up (by decreasing the rowCheck value
by 1). If the number is less, than the next spot will be 1 column to the
right (by increasing the colCheck value by 1). This continues using a while
loop until the target is found, or the target is not present, which in that
case you exit out of the while loop because of our conditional and the
algorithm returns (-1,-1).

Note: We realized that this method would also work if we were to start from
the top right element of the matrix (where rowCheck would be 0 and colCheck
would be matrix.length -1 [basically reversed]). The algorithm would work in
a very similar way except the if statements would be a bit different in a way
that the greater than/less than operations would swap and the operations inside
the if statements would also swap (rowCheck -= 1 would become rowCheck += 1 while
colCheck += 1 would become colCheck -= 1 since the algorithm causes the search
to go in the opposite direction).
*/

public class MatrixFinder {


    public static String Search( int[][] matrix, int target ) {

		int rowCheck = matrix.length - 1; //index of row where element is being looked at
		int colCheck = 0;                 //index of column where element is being looked at

		while (rowCheck >= 0 && colCheck <= matrix.length - 1) { //while the row and column being checked are ACTUALLY present in the matrix...

	    	if (matrix[rowCheck][colCheck] == target) { //if the current element equals to the target value...
				return "(" + rowCheck + "," + colCheck + ")"; //return the coordinates of the element
	    	}
	    													//if not...
	    	else if (matrix[rowCheck][colCheck] > target) { //if the current element is greater than the target value...
				rowCheck -= 1;								//go up 1 row (decrease rowCheck index by 1)
	    	}
	    													//if not...
	    	else {										    //last possible option would be that the current element is less than the target value, so...
				colCheck += 1;								//go 1 column to the right (increase colCheck index by 1)
	    	}
		}													//if none of the elements checked based on the algorithm equal to the target value...
		return "(-1,-1)";									//return the "no target value in matrix" or "(-1,-1)"
    }


    public static void main(String[] args) {
        
        int[][] matrix = { {1 ,3 ,7 ,20,31},
                           {5 ,6 ,11,25,35},
                           {9 ,10,15,32,40},
                           {16,22,30,41,55},
                           {20,25,43,57,69} }; //Our Test Case
                           
        System.out.println( Search(matrix, 32) ); // (2, 3)
        System.out.println( Search(matrix, 1) ); // (0, 0)
        System.out.println( Search(matrix, 55) ); // (3, 4)
        System.out.println( Search(matrix, 11) ); // (1, 2)
        System.out.println( Search(matrix, 42) ); // (-1, -1)
        
    }
}
