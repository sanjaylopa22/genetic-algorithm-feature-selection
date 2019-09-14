% Half-Adder Circuit:

I=[1 0;0 1];
X=cnot_gate(2)
CN2=toffoli_gate(2)
CN1=kron(X,I);
Final= CN2*CN1