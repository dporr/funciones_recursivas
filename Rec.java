import java.util.LinkedList;
public class Rec{
	public StringBuilder buffer;
	public static void main(String[] args){
		Factorial fact = new Factorial(7);
	}
	//public int ack(int a,int b){
		//int result=0;
		//Implementando algunas propiedades para ahorrar procesamiento
		//if(a==1 && b>=0) return b+2;
		//if(a{==2 && b>=0) return (2*b)+3;
		//if(a==3 && b>=0) return Math.pow(2,n+3) -3;
		//buffer.append("A("+a+","+b+")");
		//if(a==0) return ++b;
		//if(b==0) result += ack(a-1,1);
		//if(a!=0 && b!=0){
			//buffer.append(buffer.append("A("+(a-1)+","+"A("+a+","+(b-1)+")"));
			//result += ack(a-1,ack(a,b-1));}
		//return result;
	//}
	//public String searchPath(int num){}
	}

	class Factorial{
		private LinkedList<Integer> factores;
		public Factorial(int nesimo){
			factores = new LinkedList<Integer>();
			factorial(nesimo);
		}

		/**
		*Calcula el n-esimo numero factorial. n=num.
		*como usa int el maximo factorial soportado es 12S!
		*@param int num n-esimo factorial a calcular
		*@author Diego Porras,16001742
		*/
		public int factorial(int num){
			int result=0;
			if(num == 0) {
				factores.add(0);
				System.out.println(factores.toString().replace("]","").replace("[","").replace(","," *")+"!");
				return 1; //caso base
			}
			factores.add(num);
			System.out.println(factores.toString().replace("]","").replace("[","").replace(","," *")+"!");
			result = num * factorial(num-1); //caso inductivo
			factores.pollLast();
			factores.pollLast();
			factores.add(result);
			System.out.println(factores.toString().replace("]","").replace("[","").replace(","," *"));
			return result;
		}
}