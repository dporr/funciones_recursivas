import java.util.LinkedList;
public class Rec{
	public static void main(String[] args){
		Factorial fact = new Factorial(7,1);
	}
	//public String searchPath(int num){}
	}

	class Factorial implements FuncionImprimible{
		private LinkedList<Integer> factores;

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

		interface FuncionImprimible{
			private String display; //String del proceso de calulo
			private boolean DISPLAY; //Desplegar el proceso de calculo?
			private int result;
		}
}