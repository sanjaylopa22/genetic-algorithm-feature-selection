function op = toffoli_gate(n)
%
% The generalized CNOT gate - cyclicly permutes the basis vectors
%
% Usage: op = cnot_gate(n)
%     n     The dimension of both the control and data particle
%     op    The n^2 by n^2 generalized CNOT operator
%

op = zeros(n,n,n,n,n,n);
for ctrl_from1=0:(n-1)
    for ctrl_from2=0:(n-1)
     for data_from=0:(n-1)
        ctrl_to1 = ctrl_from1;
        ctrl_to2 = ctrl_from2;
        data_to = mod((data_from+(ctrl_from1*ctrl_from2)), n);
        op(1+ctrl_from1,1+ctrl_to1,1+ctrl_from2,1+ctrl_to2,1+data_from,1+data_to) = 1;
     end
    end
end

op = tensor2dm(op);