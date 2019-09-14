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
B=input('Input the value of B (0/1/2)=');
C=input('Input the value of C (Zero/One/Two)=');
Z=input('Input the value of Z transform (1/2/12/01/02)=','s');
disp('The first output is P=');
disp(A);
disp('The Second output is Q=');
disp(B);

if ((A==2)&&(B==2))
    if strcmp(Z,'1')==1
        CN1=Z1*C; %Use of Z1 permutation
        disp('The Third output is Y=');
        disp(CN1);
    elseif strcmp(Z,'2')==1
        CN2=Z2*C; %Use of Z2 permutation
        disp('The Third  output is Y=');
        disp(CN2);
    elseif strcmp(Z,'12')==1
        CN3=Z12*C; %Use of Z12 permutation
        disp('The Third  output is Y=');
        disp(CN3);
    elseif strcmp(Z,'01')==1
        CN4=Z01*C; %Use of Z01 permutation
        disp('The Third  output is Y=');
        disp(CN4);
    elseif strcmp(Z,'02')==1
        CN5=Z02*C; %Use of Z02 permutation
        disp('The Third  output is Y=');
        disp(CN5);
    end
else
    disp('The Third  output is Y='); % No Z-Permutation
    disp(C);
end

