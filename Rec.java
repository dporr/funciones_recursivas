import java.util.LinkedList;
public class Rec{
	public static void main(String[] args) throws Exception{
		int display=0;
		int value1=0;
		int value2=0;
		if(args.length<3) throw new Exception("Faltan parametros.Revisar documentacion");
		if(args.length>4) throw new Exception("Sobran parametros.Revisar documentacion");
		if(!(args[0].equals("-r")||args[0].equals("-d"))) throw new Exception("Modos validos: -r|-d");
		if(args[0].equals("-d")) display=1;	
		if(!(args[1].equals("-fact")||args[1].equals("-ack")||args[1].equals("-search")))
			throw new Exception("Operaciones validas: -fib:factorial,-ack:Ackerma,-search:Busqueda recursiva");
		switch(args[1]){
			case "-fact":
				try{
					value1 = Integer.parseInt(args[2]);
				}catch(Exception e){
					throw new Exception("El tercer parametro debe ser numerico para la funcion elegida");
				}
				if(value1<0) throw new Exception("Imposible calcular factorial de un negativo.");
				Factorial factorial = new Factorial(value1,display);
				break;
			case "-ack":
				try{
					value1 = Integer.parseInt(args[2]);
					value2 = Integer.parseInt(args[3]);
				}catch(Exception e){
					throw new Exception("El tercer y cuarto parametro deben ser numericos para la funcion elegida");
				}
				if(value1<0 || value2<0)
					throw new Exception("Ambos parametrosde f:Ackerman(x,y) deben ser positivos o cero");
				Ackerman ackerman = new Ackerman(value1,value2,display);
				break;
			case "-search":
				System.out.println("NO implementado");	
		}
		System.out.println("SKIP!");
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
	private LinkedList<String> endings; //tockens en la forma A\(d,d), A\(d 
	private LinkedList<String> tockens; //parentesis de cierre en el despliegue
	private StringBuffer display; //String que representa el proceso de calulo
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
	/**
	*Forma un string de la forma b+1 para la llamada A(0,b) 
	*para  desplegar de forma correcta el caso base 1 de Ackerman
	*@param int de una llamada de tipo A(0,number)
	*@author Diego Porras,16001742
	*/
	private void stringCase1(int number){
			tockens.pollLast();
			tockens.pollLast();
			tockens.add(""+number);
			endings.remove();
			print();
	}
	/**
	*Forma un string de la forma A(a-1,1) 
	*para  desplegar de forma correcta el caso base 2 de Ackerman
	*@param int de una llamada de tipo A(number,0)
	*@author Diego Porras,16001742
	*/
	private void stringCase2(int number){
			tockens.removeLast();
			tockens.removeLast();
			tockens.add("A("+(number-1));
			tockens.add(1+"");
			print();
	}
	/**
	*Forma un string de la forma A(a,b)
	*inicia la acumulacion de tockens para el formateo correcto delasalida
	*@param int a A(a,)
	*@param int a A(,b)
	*@author Diego Porras,16001742
	*/
	public void stringInitialCase(int a,int b){
		tockens.add("A("+a);
		tockens.add(b+"");
		endings.add(")");
		print();
	}
	/**
	*Forma un string de la forma A(a-1,A(a,b-1)) 
	*para  desplegar de forma correcta el caso base 3 de Ackerman
	*@param int a un operando de f:Ackerman en la forma A(a,b)
	*@param int b un operando de f:Ackerman en la forma A(a,b)
	*@author Diego Porras,16001742
	*/
	private void stringCase3(int a, int b){
			tockens.pollLast();
			tockens.pollLast();
			tockens.add("A("+(a-1));
			tockens.add("A("+a);
			tockens.add(""+(b-1));
			endings.add(")");
			print();
	}

	/**
	*Unifica las pilas tockens y endings eliminando caracteres innecesarios
	*para  desplegar de forma correcta el calculo de f:Ackermann
	*@author Diego Porras,16001742
	*/
	private void print(){
		display = new StringBuffer(tockens.toString().replace("[","").replace("]",""));
		display.append(endings.toString().replace("[","").replace("]","").replace(",","").replace(" ",""));
		System.out.println(display);
	}
}