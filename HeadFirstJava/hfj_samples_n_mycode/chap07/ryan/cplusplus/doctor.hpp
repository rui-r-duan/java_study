#ifndef DOCTOR_HPP
#define DOCTOR_HPP

class Doctor
{
public:
    virtual void treat_patient();
private:
    bool works_at_hospital;
};

#endif
