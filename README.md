# Projekt Rozkładu Choleskiego

## Wprowadzenie

Ten projekt implementuje metody numeryczne do rozwiązywania układów równań liniowych przy użyciu rozkładu Choleskiego. Rozkład Choleskiego jest techniką faktoryzacji macierzy, która rozkłada symetryczną, dodatnio określoną macierz \(A\) na iloczyn macierzy dolnotrójkątnej \(L\) i jej transponowanej \(L^T\).

## Teoretyczne Podstawy

### Rozkład Choleskiego

Dla symetrycznej, dodatnio określonej macierzy \(A\), rozkład Choleskiego polega na znalezieniu macierzy dolnotrójkątnej \(L\) takiej, że:
\[ A = LL^T \]
gdzie \(L\) jest macierzą dolnotrójkątną. Rozkład ten umożliwia uproszczenie obliczeń i jest wykorzystywany do efektywnego rozwiązywania układów równań liniowych.
Dla macierzy Hermitowskich, które są macierzami zespolonymi spełniającymi określone warunki symetrii, rozkład Choleskiego jest nieco zmodyfikowany i zapisuje się jako:
\[ A = LL^T \]
gdzie \(L^T\) oznacza sprzężenie hermitowskie (transpozycja i sprzężenie zespolone) macierzy \(L\).

### Rozwiązywanie Układów Równań

Aby rozwiązać układ równań \(Ax = b\) przy użyciu rozkładu Choleskiego:
1. Rozkładamy macierz \(A\) na \(LL^T\).
2. Rozwiązujemy układ równań \(Ly = b\) w celu znalezienia wektora \(y\).
3. Rozwiązujemy układ równań \(L^Tx = y\) w celu znalezienia wektora \(x\).

### Rozkład Choleskiego z Macierzą Diagonalną

Każda dodatnio określona macierz Hermitowska może być również rozłożona w postaci:
\[ A = MDM*\]
gdzie \(M\) jest macierzą dolnotrójkątną z jedynkami na głównej przekątnej, \(D\) jest macierzą diagonalną z dodatnimi wartościami na głównej przekątnej, a \(M*\) jest macierzą sprzężoną i transponowaną do macierzy \(M\).

## Implementacja

Projekt zawiera dwie metody rozwiązywania układów równań liniowych:

1. **Metoda 1: \(A = LL^T\)**
2. ***Metoda 2: \(A = MDM*\)**

### Pliki

- **Main.java**: Główny punkt wejścia aplikacji. Obsługuje wejście użytkownika i wybór metody rozkładu.
- **CholeskiLLT.java**: Implementuje rozkład \(A = LL^T\) oraz rozwiązanie układu równań tą metodą.
- **CholeskiMDM2.java**: Implementuje rozkład \(A = MDM^*\) oraz rozwiązanie układu równań tą metodą.
