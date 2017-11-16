#ifndef SURGEON_HPP
#define SURGEON_HPP

#include "doctor.hpp"

class Surgeon : public Doctor
{
public:
    void treat_patient();       // override
    void make_incision();
};

#endif
