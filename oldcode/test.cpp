#include <iostream>
#include "testobject.hpp"

using namespace std;

class Test
{
private:
    TestObject* a;
    TestObject* b;
public:
    Test();
};

Test::Test() : a(new TestObject) {
    cout << "Test()" << endl;
    b = new TestObject();
}

int main(int argc, char* argv[]) {
    Test* t = new Test();
    return 0;
}
