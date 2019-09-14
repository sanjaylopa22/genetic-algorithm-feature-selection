%D=bin2dec('011')
%phi=bin2vec('101')
%psi = bin2vec('01')
%pretty(psi)
%S=CNOT(2,psi)
%A=1;
%B=1;
%X=xor(A,B)
%cnot_gate(2)
%zeros(3,3,3,3)
%toffoli_gate(2)
% Half-Adder Circuit:
One=[0;1;0];
ZOne=[0 0 1;1 0 0;0 1 0];
prompt='Input A';
A=input(prompt);
Z=input('Input the value of Z transform=','s');
if A==2
    disp('success');
    %CN1=Z*ZOne
    if strcmp(Z,'1')==1
        CN1=ZOne*One %Use of Z1 permutation
        %disp('The Second output is Q=');
        %disp(CN1);
    end
end