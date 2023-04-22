import java.util.Iterator;
import java.util.LinkedList;

public class Polynomial {
    private LinkedList<Monomial> monos;

    public Polynomial(){monos= new LinkedList<>();}
    public Polynomial(LinkedList<Monomial> monos)
    {
        this.monos = monos;
    }

    public static Polynomial build(String input) {
        LinkedList<Monomial> poly = new LinkedList<Monomial>();
        LinkedList<String> strList = new LinkedList<String>();//deviding the numbers in the strings

        for (int i = 0; i < input.length(); i++)
            if (input.charAt(i) != ' ') {
                String str = "";
                while (input.charAt(i) != ' ') {
                    str = str + input.charAt(i);
                }
                strList.addLast(str);
            }

        if (strList.size() == 0) {//if the string was empty
            Monomial M = new Monomial(1, new IntegerScalar(0));
            poly.addLast(M);

        } else {//starting to build the list
            for (String str : strList) {
                int i = 0;//exponent
                Monomial M = null;

                if (str.indexOf('/') == -1)//Integer number coefficient
                {
                    IntegerScalar sca = null;
                    if (str.charAt(0) != '-')//positive number
                        sca = new IntegerScalar(java.lang.Integer.parseInt(str));
                    else//negative number
                        sca = new IntegerScalar(-1 * java.lang.Integer.parseInt(str));
                    M = new Monomial(i, sca);
                } else//Rational number coefficient
                {
                    Rational sca = null;
                    int nome = 0, deno = 0;

                    nome = java.lang.Integer.parseInt(str);
                    if (str.charAt(0) == '-')//checks for negative nomerator
                        nome *= -1;
                    str = str.substring(str.indexOf('/'), str.length());//getting the denominator
                    deno = java.lang.Integer.parseInt(str);
                    sca = new Rational(nome, deno);
                    M = new Monomial(i, sca);
                }
                poly.addLast(M);
                i++;
            }
        }
        return new Polynomial(poly);
    }



    public Polynomial add(Polynomial p){
        Iterator<Monomial> Iter1 = this.monos.iterator();
        Iterator<Monomial> Iter2 = p.monos.iterator();
        LinkedList<Monomial> MonoAdd = new LinkedList<>();

        for(int i =0;Iter1.hasNext() && Iter2.hasNext();)
            MonoAdd.addLast(Iter1.next().add(Iter2.next()));

        while(Iter1.hasNext())
                MonoAdd.addLast(Iter1.next());

        while(Iter2.hasNext())
            MonoAdd.addLast(Iter2.next());

        return new Polynomial(MonoAdd);
    }
    public Polynomial mul(Polynomial p){
        Polynomial PolyMul = new Polynomial();
        for(Monomial M: monos)
        {
            LinkedList<Monomial>  MonoMul = new LinkedList<>();
            for(Monomial MP: p.monos)
                MonoMul.addLast(M.mul(MP));
            PolyMul.add(new Polynomial(MonoMul));
        }
        return PolyMul;
    }
    public Scalar evaluate(Scalar s){
        Rational soul = new Rational(0,0);
        for(Monomial M:monos)
            soul.add(M.evaluate(s));
        return soul;
    }
    public Polynomial derivative(){
        LinkedList<Monomial> MonoDer = new LinkedList<>();
        for(Monomial M:monos)
            MonoDer.addLast(M.derivative());
        return new Polynomial(MonoDer);
    }
    public boolean equals(Object o){
        if(o instanceof Polynomial)
        {
            Iterator<Monomial> Iter1 = this.monos.iterator();
            Iterator<Monomial> Iter2 = (((Polynomial)o).monos.iterator());
            while(Iter1.hasNext() && Iter2.hasNext())
                if(!Iter1.next().equals(Iter2.next()))
                    return false;

            if(!Iter1.hasNext() && !Iter2.hasNext())
                return true;
        }
        return false;
    }
    public String toString(){
        String s="";
        Monomial ZERO = new Monomial(0,new IntegerScalar(0));
        for(Monomial M:monos)
            if(!M.equals(ZERO))//checks for not Monomial 0
                s = s+M.toString() + "+";

        return s.substring(-1);
    }

}
