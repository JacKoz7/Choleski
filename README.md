# Cholesky Decomposition Algorithms
## Introduction
This project implements numerical methods for solving systems of linear equations using Cholesky decomposition. Cholesky decomposition is a matrix factorization technique that decomposes a symmetric, positive-definite matrix (A) into the product of a lower triangular matrix (L) and its transpose (L^T).
## Theoretical Foundations
### Cholesky Decomposition
For a symmetric, positive-definite matrix (A), Cholesky decomposition involves finding a lower triangular matrix (L) such that:
[ A = LL^T ]
where (L) is a lower triangular matrix. This decomposition simplifies calculations and is used for efficiently solving systems of linear equations.
For Hermitian matrices, which are complex matrices satisfying specific symmetry conditions, the Cholesky decomposition is slightly modified and written as:
[ A = LL^T ]
where (L^T) denotes the Hermitian conjugate (transpose and complex conjugate) of matrix (L).
### Solving Systems of Equations
To solve the system of equations (Ax = b) using Cholesky decomposition:

Decompose matrix (A) into (LL^T).
Solve the system of equations (Ly = b) to find vector (y).
Solve the system of equations (L^Tx = y) to find vector (x).

### Cholesky Decomposition with Diagonal Matrix
Every positive-definite Hermitian matrix can also be decomposed in the form:
[ A = MDM* ]
where (M) is a lower triangular matrix with ones on the main diagonal, (D) is a diagonal matrix with positive values on the main diagonal, and (M*) is the conjugate transpose of matrix (M).

Decompose matrix (A) into (A = MDM*)
Solve the system of equations (My = b) to find vector (y).
Solve the system of equations (M^Tx = D^(-1)y) to find vector (x).

## Implementation
The project includes two methods for solving systems of linear equations:

Method 1: (A = LL^T)
Method 2: (A = MDM)*

### Files

Main.java: The main entry point of the application. Handles user input and method selection for decomposition.
CholeskiLLT.java: Implements the (A = LL^T) decomposition and solution of the system of equations using this method.
CholeskiMDM2.java: Implements the (A = MDM*) decomposition and solution of the system of equations using this method.
