function [dm,desc] = tensor2dm (tensor)
%
% Transforms a density tensor into a density matrix
%
% Usage: dm = tensor2dm (tensor)
%     tensor - The density tensor
%     dm - The density matix
%     desc - The descriptor (optional)
%

sz = size(tensor);
N = length(sz)/2;
desc_1 = sz([1:N]*2-1);

ordering = zeros(1,2*N);
ordering(2*([1:N]-1)+1) =   N - [1:N] + 1;
ordering(2*([1:N]-1)+2) = 2*N - [1:N] + 1;

tensor_2 = ipermute(tensor, ordering);

prod_size = prod(desc_1);

dm = reshape(tensor_2, [prod_size,prod_size]);

if nargout > 1
    desc = desc_1;
end

