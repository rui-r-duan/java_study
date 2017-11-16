package chap07.ryan;

class FamilyDoctor extends Doctor {
    boolean makesHouseCalls;
    void giveAdvice() {
        System.out.println("give homespun advice");
    }
}

class Surgeon extends Doctor {
    void treatPatient() {
        super.treatPatient();
        System.out.println("perform surgery");
    }
    void makeIncision() {
        System.out.println("make incision (yikes!)");
    }
}

public class TestOverrideMethod {
    public static void main(String[] args) {
        Doctor d = new Doctor();
        d.treatPatient();

        FamilyDoctor fd = new FamilyDoctor();
        fd.treatPatient();

        Surgeon s = new Surgeon();
        s.treatPatient();
        Doctor castS = (Doctor)s;
        castS.treatPatient();

        Doctor ds = new Surgeon();
        ds.treatPatient();

        // chap07/ryan/TestOverrideMethod.java:43: inconvertible types
        //     found   : chap07.ryan.Surgeon
        //     required: chap07.ryan.FamilyDoctor
        // FamilyDoctor castFD = (FamilyDoctor)s;
        // castFD.treatPatient();
    }
}