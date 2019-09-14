library(QCSimulator) #5-qubits quantum simulator
library(ggplot2)
library(e1071)
#practice
init()
ls()
I2
q00_
PauliX(I2)
Hadamard(I2)
PauliZ(Hadamard(q0_))
a = SGate(TGate(Hadamard(TGate(Hadamard(q0_)))))
result=measurement(a)
plotMeasurement(result)
#BQIGSA
data(iris)
str(iris)
qplot(Petal.Length,Petal.Width,data=iris,color=Species)
iris$Species=NULL
str(iris)
nrow(iris)
ncol(iris)
TensorProd(Hadamard,Hadamard)
#I4=TensorProd(Hadamard(I2),I3)
#I4=TensorProd(Hadamard(I2),I3)
#I5=TensorProd(Hadamard(I2),I4)
#I6=TensorProd(Hadamard(I2),I5)
#I7=TensorProd(Hadamard(I2),I6)
#H=1/sqrt(2) * matrix(c(1,1,1,-1),nrow=2,ncol=2)
#Q.t=DotProduct(Hadamard(data("iris"),H))
#mat=matrix(c(4,5,7,8),nrow=2)
#TensorProd(mat,I2)
#TensorProd(Hadamard(mat))

#K-NN Classifier for Iris
library(class)
train <- rbind(iris3[1:25,,1], iris3[1:25,,2], iris3[1:25,,3])
test <- rbind(iris3[26:50,,1], iris3[26:50,,2], iris3[26:50,,3])
cl <- factor(c(rep("s",25), rep("c",25), rep("v",25)))
myknn<-knn(train, test, cl, k = 3, prob=TRUE)
attributes(.Last.value)
cm <- table(myknn, cl)
cm
1-sum(diag(cm))/sum(cm) #Misclassification Error
n = sum(cm) # number of instances
nc = nrow(cm) # number of classes
diag = diag(cm) # number of correctly classified instances per class 
rowsums = apply(cm, 1, sum) # number of instances per class
colsums = apply(cm, 2, sum) # number of predictions per class
p = rowsums / n # distribution of instances over the actual classes
q = colsums / n # distribution of instances over the predicted classes
accuracy = sum(diag) / n #Accuracy
accuracy
precision = diag / colsums 
recall = diag / rowsums 
f1 = 2 * precision * recall / (precision + recall) 
data.frame(precision, recall, f1) 

cnt=0
Fit<-0
Fitness=c()
SB_T=c()
while(cnt<2){
#Fitness calculation of each object

W_A <- runif(1,0.75, 1.0)
W_F <- runif(1,0, 0.25)

SB_t <- W_A*accuracy+W_F*(1-1/5)
#SB_T<-c(SB_t)
#print(SB_T)
if(SB_t>accuracy && SB_t<1)
{
  Fitness<-SB_t
    #print(Fitness)
     # print("Final Fitness value is:")
   for(i in 1:100)
     {
     Fit[i]<-Fitness
     }
    print(Fit)
}
print(max(Fit))
print(min(Fit))
}
print("Sum Fitness is:")


#Mass of object calculation
#for(i in 1:150){
 # fitness[i]}
best_fitness<-max(fitness)
print(best_fitness)
#worst_fitness<-fitness[i]
print(min(fitness))
print("m_fitness value")
#m_fitness<-(fitness-worst_fitness)/(best_fitness-worst_fitness)
m_fitness<-(fitness-0.924648)/(0.9965294-0.924648)
print(m_fitness)
Mass<-m_fitness/sum(m_fitness)
print(Mass)


#Random Number Generator by uniform distribution of each object in Iris Dataset
cnt=0
while(cnt<601){
x1 <- runif(1,-1.0, 1.0)
print("1st qubit")
x_1<-c(x1)
print(x_1)
x2 <- sqrt(1-abs(x1[1]^2))
print("2nd qubit")
x_2<-c(x2)
print(x_2)
combined.Q_bit <- matrix(c(x_1,x_2),nrow=150, byrow=TRUE)
rand<-runif(1,0, 1.0)
if(rand<x_1^2)
{
  x_1<-1
  }
else
{
  x_1<-0
}
SW_t<-matrix(c(x_1),nrow=10,ncol=10)
print(SW_t)
cnt=cnt+1
}

#caculate G(t) gravitational constant
c=1
t=0
G=0.125
while(c<10 && G!=0 && t<10){
  m<-t/c
  print(m)
  Gt<-G*(1-m)
  print(Gt)
  t=t+1
  c=c+1 
  G=G-0.25
     }

