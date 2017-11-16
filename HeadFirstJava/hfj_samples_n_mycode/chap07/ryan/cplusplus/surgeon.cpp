#include "surgeon.hpp"
#include <iostream>

void Surgeon::treat_patient()
{
    Doctor::treat_patient();
    std::cout << "perform surgery" << std::endl;
}

void Surgeon::make_incision()
{
    std::cout << "make incision (yikes!)" << std::endl;
}
