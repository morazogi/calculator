public class Rational implements Scalar {
    private int nomerator;
    private int denominator;

    public Rational(int nomerator, int denominator) {
        this.nomerator = nomerator;
        this.denominator = denominator;
    }
    public int GetNumerator(){return nomerator;}
    public int GetDenominator(){return denominator;}
    //AddFunctions
    public Scalar add(Rational R1) {
        return new Rational(this.nomerator *R1.denominator+this.denominator* R1.nomerator,
                            this.denominator+R1.denominator);
    }
    public Scalar add(Integer I1){
        return new Rational(nomerator +denominator*I1.GetNumber(),denominator);
    }
    public Scalar add(Scalar s) {
        return s.add(this);
    }
    //MultiplicationFunctions
    public Scalar mul(Rational R1){
        return new Rational(this.nomerator*R1.nomerator,
                            this.denominator*R1.denominator);
    }
    public Scalar mul(Integer I1){
        return new Rational(this.nomerator*I1.GetNumber(),this.denominator);
    }
    public Scalar mul(Scalar s){
        return s.mul(this);
    }
    //---------
    public Scalar neg() {
        return new Rational(this.nomerator * (-1),this.denominator);
    }

    public Scalar power(int exponent){
        int nom2 = this.nomerator;
        int denom2 = this.denominator;
        if (exponent==0){
            nom2=1;
            denom2=1;
        } else {
            for (; exponent > 1; exponent--) {
                nom2 *= this.nomerator;
                denom2 *= this.denominator;
            }
        }
        return new Rational(nom2,denom2);
    }


    public int sign(){
        if (this.nomerator==0) return 0;
        if ((this.nomerator>0&this.denominator>0)||(this.nomerator<0&this.denominator<0)) return 1;
        return -1;
    }

    public boolean equals(Object o){
        if (o instanceof Rational){
            return (((this.nomerator == ((Rational)o).nomerator)&
                    (this.denominator == ((Rational)o).denominator))||
                    (((this.nomerator == -((Rational)o).nomerator)&
                    (this.denominator == -((Rational)o).denominator))));
        }
        return false;
    }

    public String ToString(){
        // specific instructions
        //to-do
        if ()
    }
}
