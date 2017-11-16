#ifndef FAMILYDOCTOR_HPP
#define FAMILYDOCTOR_HPP

#include "doctor.hpp"

class Family_doctor : public Doctor
{
public:
    void give_advice();
private:
    bool makes_house_calls;
};

#endif
