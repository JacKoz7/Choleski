# Cholesky Decomposition Algorithms
## Introduction
This project implements numerical methods for solving systems of linear equations using Cholesky decomposition. Cholesky decomposition is a matrix factorization technique that decomposes a symmetric, positive-definite matrix A into the product of a lower triangular matrix L and its transpose L^T.

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
1x<sub>1</sub> + 2x<sub>2</sub> + 3x<sub>3</sub> = 1    
2x<sub>1</sub> + 8x<sub>2</sub> + 10x<sub>3</sub> = 3    
3x<sub>1</sub> + 10x<sub>2</sub> + 22x<sub>3</sub> = 7    
where x<sub>1</sub>, x<sub>2</sub>, and x<sub>3</sub> are the unknowns  
```
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
0.3333333333333333   
  
Choose a method:    
1 - A = LL^T   
2 - A = MDM*   
2   
Selected A = MDM*   
   
Matrix M:   
1.0 0.0 0.0   
2.0 1.0 0.0    
3.0 1.0 1.0    
   
Matrix D:  
1.0 0.0 0.0   
0.0 4.0 0.0   
0.0 0.0 9.0    
   
Matrix M*: 
1.0 2.0 3.0   
0.0 1.0 1.0    
0.0 0.0 1.0   
   
Matrix D^-1:   
1.0 0.0 0.0    
0.0 0.25 0.0    
0.0 0.0 0.1111111111111111   
   
Results y:   
1.0  
1.0  
3.0  
   
Results x:    
0.16666666666666663   
-0.08333333333333331   
0.3333333333333333    
```   

# https://replit.com/@JacekKozlowski1/Cholesky-Decomposition-Algorithms
