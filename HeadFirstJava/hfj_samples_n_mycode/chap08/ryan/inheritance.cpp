#include <iostream>

class Account {
public:
    Account(double d) { balance = d; }
    virtual double getBalance() { std::cout << "Account getBalance(): " << balance
                                    << std::endl; }
protected:
    double balance;
};

class MyAcc : public Account {
public:
    MyAcc(double d, double r) : Account(d), ratio(r) {}
    double getBalance() { std::cout << "MyAcc getBalance(): "
                                    << balance * ratio << std::endl; }
private:
    double ratio;
};

int main(int argc, char* argv[])
{
    Account* pa = new MyAcc(10.5, 2.57);
    pa->getBalance();
    delete pa;
    return 0;
}
