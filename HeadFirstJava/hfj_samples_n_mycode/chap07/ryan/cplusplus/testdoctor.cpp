#include "doctor.hpp"
#include "surgeon.hpp"
#include "familydoctor.hpp"
#include <iostream>

int main(int argc, char** argv)
{
    Doctor* d = new Doctor;
    d->treat_patient();

    Family_doctor* fd = new Family_doctor;
    fd->treat_patient();

    Surgeon* s = new Surgeon;
    s->treat_patient();
    Doctor* cast_s = (Doctor*)s;
    cast_s->treat_patient();

    Doctor* ds = new Surgeon;
    ds->treat_patient();

    return 0;
}
