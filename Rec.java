import java.util.LinkedList;
public class Rec{
	public static void main(String[] args){
		//Factorial fact = new Factorial(7,1);
		Ackerman ak32 = new Ackerman(2,1,0);

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
	private LinkedList<Integer> operandos;
	private String display; //String del proceso de calulo
	private boolean DISPLAY=true; //Desplegar el proceso de calculo?
	private int result;

	public Ackerman(int a,int b, int display){
		this.DISPLAY= display==1? true:false;
		operandos = new LinkedList<Integer>();
		operandos.add(a);
		operandos.add(b);
		System.out.println("B:"+operandos + " = ") ;
		result = ack(a,b);
		if(!DISPLAY)
			System.out.println(result);
	}
	public int ack(int a,int b){
		int result=0;
		if(a==0){ 
			int tmp=b+1;
			operandos.pollLast();
			operandos.pollLast();
			operandos.add(tmp);
			if(DISPLAY)
				System.out.println("S:"+operandos);
			return tmp;
		}
		if(b==0){
			operandos.pollLast();
			operandos.pollLast();
			operandos.add(a-1);
			operandos.add(1);
			System.out.println("C2:"+operandos);
			result += ack(a-1,1);
		}
		if(a!=0 && b!=0){
		//	buffer.append(buffer.append("A("+(a-1)+","+"A("+a+","+(b-1)+")"));
			operandos.pollLast();
			operandos.pollLast();
			operandos.add(a-1);
			operandos.add(a);
			operandos.add(b-1);
			if(DISPLAY)
				System.out.println("C:"+operandos);
			result += ack(a-1,ack(a,b-1));}
		return result;
	}
	}