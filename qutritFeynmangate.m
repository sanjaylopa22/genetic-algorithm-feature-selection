prompt='Input the value of A(0/1/2)=';
A=input(prompt);
B=input('Input the value of B (0/1/2)=');
%Z=input('Input the value of Z transform (1/2/12/01/02)=','s');
disp('The first output is P=');
disp(A);
    z=A+B;
    x=mod(z,3);
disp('The Second output is Q=');
disp(x);