public class Monomial {
    private int exponent;
    private Scalar coefficient;

    public Monomial(int exponent, Scalar coefficient){
        this.exponent = exponent;
        this.coefficient = coefficient;
    }
    public Monomial add(Monomial m){
        //TO_DO
        if (this.exponent == m.exponent){
            return (new Monomial(exponent,(this.coefficient.add(m.coefficient))));
        } else {
            return null;
        }
    }
    public Monomial mul(Monomial m){
        //TO_DO
        return (new Monomial(this.exponent+m.exponent, this.coefficient.mul(m.coefficient)));
    }
    public Scalar evaluate(Scalar s){
        //TO_DO
        return (s.power(this.exponent).mul(this.coefficient));
    }
    public Monomial derivative(){
        //TO_DO
        return (new Monomial(exponent-1, this.coefficient.mul(new IntegerScalar(exponent))));
    }
    public int sing(){
        //TO_DO
        return this.coefficient.sign();
    }
    public boolean equals(Object o){
        //TO_DO
        if (o instanceof Monomial){
            Monomial mono = (Monomial) o;
            return (mono.coefficient.equals(this.coefficient)&&mono.exponent==this.exponent);
        } else {
            return false;
        }
    }
    public String toString(){
        //TO_DO
        String ans = "X^";
        String exp;
        String coef;
        if (this.exponent==1) {
            exp = "";
        } else {
            exp = ""+exponent;
        }
        if (this.coefficient.equals(new IntegerScalar(1))) {
            coef = "";
        } else if (this.coefficient.equals(new IntegerScalar(-1))){
            coef = "" + this.coefficient.toString();
        } else if (this.coefficient.equals(new IntegerScalar(0))) {
            return (this.coefficient.toString());
        } else {
            coef = coefficient.toString();
        }
        ans = coef+ans+exp;
        return  ans;
    }
}

