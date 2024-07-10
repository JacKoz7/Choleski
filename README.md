# Cholesky Decomposition Algorithms
## Introduction
This project implements numerical methods for solving systems of linear equations using Cholesky decomposition. Cholesky decomposition is a matrix factorization technique that decomposes a symmetric, positive-definite matrix A into the product of a lower triangular matrix L and its transpose L^T.
## Theoretical Foundations
### Cholesky Decomposition
For a symmetric, positive-definite matrix (A), Cholesky decomposition involves finding a lower triangular matrix L such that:
 A = LL^T 
where (L) is a lower triangular matrix. This decomposition simplifies calculations and is used for efficiently solving systems of linear equations.
For Hermitian matrices, which are complex matrices satisfying specific symmetry conditions, the Cholesky decomposition is slightly modified and written as:
 A = LL^T 
where L^T denotes the Hermitian conjugate (transpose and complex conjugate) of matrix L.
### Solving Systems of Equations
To solve the system of equations Ax = b using Cholesky decomposition:

1. Decompose matrix A into LL^T.
2. Solve the system of equations Ly = b to find vector y.
3. Solve the system of equations L^Tx = y to find vector x.

### Cholesky Decomposition with Diagonal Matrix
Every positive-definite Hermitian matrix can also be decomposed in the form:
 A = MDM* 
where M is a lower triangular matrix with ones on the main diagonal, D is a diagonal matrix with positive values on the main diagonal, and M* is the conjugate transpose of matrix M.

1. Decompose matrix A into A = MDM*
2. Solve the system of equations My = b to find vector y.
3. Solve the system of equations M^Tx = D^(-1)y) to find vector x.

## Implementation
The project includes two methods for solving systems of linear equations:

Method 1: A = LL^T
Method 2: A = MDM*

Sample solution of the following equations using both methods:
1<sub>x1</sub> + 2<sub>x2</sub> + 3<sub>x3</sub> = 1
2x1 + 8x2 + 10x3 = 3
3x1 + 10x2 + 22x3 = 7
where x1, x2, and x3 are the unknowns
_
Enter the number of matrix rows: 3
Fill in the matrix rows 
Row 1:
Enter value for column 1: 1
Enter value for column 2: 2
Enter value for column 3: 3
Row 2:
Enter value for column 1: 2
Enter value for column 2: 8
Enter value for column 3: 10
Row 3:
Enter value for column 1: 3
Enter value for column 2: 10
Enter value for column 3: 22

Enter right side of the equation, i.e., matrix b: 
Result of equation 1: 1
Result of equation 2: 3
Result of equation 3: 7

Entered matrix:
1 2 3 
2 8 10 
3 10 22 
Matrix b
1 
3 
7 

Choose a method: 
1 - A = LL^T
2 - A = MDM*
1
Selected A = LL^T

Matrix L looks like this: 
1.0 0.0 0.0 
2.0 2.0 0.0 
3.0 2.0 3.0 

Results y
1.0
0.5
1.0

Transposed matrix LT:
1.0 2.0 3.0 
0.0 2.0 2.0 
0.0 0.0 3.0 

Results x
0.16666666666666663
-0.08333333333333331
0.3333333333333333_


### Files

- Main.java: The main entry point of the application. Handles user input and method selection for decomposition.
- CholeskiLLT.java: Implements the A = LL^T decomposition and solution of the system of equations using this method.
- CholeskiMDM2.java: Implements the A = MDM* decomposition and solution of the system of equations using this method.
