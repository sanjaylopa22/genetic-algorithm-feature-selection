%function op = qutritMSGate(A,B,Z)

%declaration of permutation Z gates and three basis states
Z1=[0 0 1;1 0 0;0 1 0];
Z2=[0 1 0;0 0 1;1 0 0];
Z12=[1 0 0;0 0 1;0 1 0];
Z01=[0 1 0;1 0 0;0 0 1];
Z02=[0 0 1;0 1 0;1 0 0];
Zero=[1;0;0];
One=[0;1;0];
Two=[0;0;1];

%Muthukrishnan-Stroud (M-S)Gate
prompt='Input the value of A(0/1/2)=';
A=input(prompt);
B=input('Input the value of B (Zero/One/Two)=');
Z=input('Input the value of Z transform (1/2/12/01/02)=','s');
disp('The first output is P=');
disp(A);
if A==2
    if strcmp(Z,'1')==1
        CN1=Z1*B; %Use of Z1 permutation
        disp('The Second output is Q=');
        disp(CN1);
    elseif strcmp(Z,'2')==1
        CN2=Z2*B; %Use of Z2 permutation
        disp('The Second output is Q=');
        disp(CN2);
    elseif strcmp(Z,'12')==1
        CN3=Z12*B; %Use of Z12 permutation
        disp('The Second output is Q=');
        disp(CN3);
    elseif strcmp(Z,'01')==1
        CN4=Z01*B; %Use of Z01 permutation
        disp('The Second output is Q=');
        disp(CN4);
    elseif strcmp(Z,'02')==1
        CN5=Z02*B; %Use of Z02 permutation
        disp('The Second output is Q=');
        disp(CN5);
    end
else
    disp('The Second output is Q='); % No Z-Permutation
    disp(B);
end

