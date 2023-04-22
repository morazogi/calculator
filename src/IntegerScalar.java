public class IntegerScalar implements Scalar {
    private int number;

    public IntegerScalar(int number) {
        this.number = number;
    }
    public int GetNumber(){return number;}
    public Scalar add(IntegerScalar I1) {
        return new IntegerScalar(number + I1.number);}
    public Scalar add(Scalar s) {
        return s.add(this);}
    public Scalar mul(IntegerScalar I1){
        return new IntegerScalar(this.number*I1.number);}
    public Scalar mul(Scalar s){
        return s.mul(this);}
    public Scalar neg() {
        return new IntegerScalar(this.number * (-1));}
    public Scalar power(int exponent){
        int num2 = this.number;
        if (exponent==0){
            num2=1;
        } else {
            for (; exponent > 1; exponent--) {
                num2 *= this.number;
            }
        }
        return new IntegerScalar(num2);
    }
    public int sign(){
        if (this.number==0) return 0;
        if (this.number>0) return 1;
        return -1;}
    public boolean equals(Object o){
        if (o instanceof IntegerScalar){
            return (this.number == ((IntegerScalar)o).number);
        }
        return false;
    }
    public String ToString(){
            return ""+this.number;
        }
}

