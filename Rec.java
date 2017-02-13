import java.util.LinkedList;
public class Rec{
	public static void main(String[] args){
		//Factorial fact = new Factorial(7,1);
		Ackerman ak32 = new Ackerman(3,2,1);

	}
	//public String searchPath(int num){}
	}

	class Factorial{
		private LinkedList<Integer> factores;
		private String display; //String del proceso de calulo
		private boolean DISPLAY=true; //Desplegar el proceso de calculo?
		private int result;

		public Factorial(int nesimo,int display){
			factores = new LinkedList<Integer>();
			this.DISPLAY= display==1? true:false;
			result = factorial(nesimo);
			if(!DISPLAY)
				System.out.println(nesimo+"! = "+result);
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
				if(DISPLAY){
					display=factores.toString().replace("]","").replace("[","").replace(","," *")+"!";
					System.out.println(display);
					System.out.println(display.replace("0!","1"));
				}
				return 1; //caso base
			}
			factores.add(num);
			if(DISPLAY)
				System.out.println(factores.toString().replace("]","").replace("[","").replace(","," *")+"!");
			result = num * factorial(num-1); //Caso inductivo
			factores.pollLast();
			factores.pollLast();
			factores.add(result);
			if(DISPLAY)
				System.out.println(factores.toString().replace("]","").replace("[","").replace(","," *"));
			return result;
		}
	}

	class Ackerman{
	private LinkedList<String> endings;
	private LinkedList<String> tockens;
	private StringBuffer display; //String del proceso de calulo
	private boolean DISPLAY=true; //Desplegar el proceso de calculo?
	private int result;

	public Ackerman(int a,int b, int displayFlag){
		this.DISPLAY= displayFlag==1? true:false;
		tockens = new LinkedList<String>();
		endings = new LinkedList<String>();
		stringInitialCase(a,b);
		result = ack(a,b);
		if(!DISPLAY)
			System.out.println(result);
	}
			/**
		*Calcula el resultado de la funcion de Ackerman A(a,b)
		*@param int a A(a,)
		*@param int a A(,b)
		*@author Diego Porras,16001742
		*/
	public int ack(int a,int b){
		int result=0;
		//Implementando algunas propiedades para ahorrar procesamiento
		//Faster whitout display!
		if(!DISPLAY){
			if(a==1 && b>=0) return b+2;
			if(a==2 && b>=0) return (2*b)+3;
			if(a==3 && b>=0) return ((int) Math.pow(2,b+3))-3;
		}
		if(a==0){ 
			int tmp=b+1;
			stringCase1(tmp);
			return tmp;
		}
		if(b==0){
			stringCase2(a);
			result += ack(a-1,1);
		}
		if(a!=0 && b!=0){
			stringCase3(a,b);
			result += ack(a-1,ack(a,b-1));}
		return result;
	}
	private void stringCase1(int number){
			tockens.pollLast();
			tockens.pollLast();
			tockens.add(""+number);
			endings.remove();
			print();
	}
	private void stringCase2(int number){
			tockens.removeLast();
			tockens.removeLast();
			tockens.add("A("+(number-1));
			tockens.add(1+"");
			print();
	}
	public void stringInitialCase(int a,int b){
		tockens.add("A("+a);
		tockens.add(b+"");
		endings.add(")");
		print();
	}
	private void stringCase3(int a, int b){
			tockens.pollLast();
			tockens.pollLast();
			tockens.add("A("+(a-1));
			tockens.add("A("+a);
			tockens.add(""+(b-1));
			endings.add(")");
			print();
	}
	private void print(){
		display = new StringBuffer(tockens.toString().replace("[","").replace("]",""));
		display.append(endings.toString().replace("[","").replace("]","").replace(",","").replace(" ",""));
		System.out.println(display);
	}
}