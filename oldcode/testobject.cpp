#include <iostream>
#include "testobject.hpp"

int TestObject::cnt = 0;

TestObject::TestObject() {
    ++cnt;
    std::cout << "TestObject(): " << cnt << std::endl;
}
