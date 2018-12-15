public class Ordenador {
	
	public static void main(String args[]) {
		String nomes[] = {"Steve","Maria","Joao","Pedro","Lucas","Irineu","Robert","Paulo","Joana","Igor"};
		System.out.println("Sem ordenar: "); 
		for(String nome:nomes) System.out.print(nome+" "); System.out.println();
		nomes = ordenar(nomes);
		System.out.println("Ordenado: "); 
		for(String nome:nomes) System.out.print(nome+" "); System.out.println();
		nomes = ordenar(nomes,1);
		System.out.println("Ordenado em reverso: "); 
		for(String nome:nomes) System.out.print(nome+" "); System.out.println();
	}
	
	public static String[] ordenar(String[] nonOrdered,int reverse) {
		String[] ordered =  new String[nonOrdered.length];
		int pos=0,del=0; String m="";
		while(pos<ordered.length) {
			m=""; 
			for(String i:nonOrdered)
				if(!i.equals("") && 
						((reverse==0 && i.compareTo(m)>0) || (reverse==1 && i.compareTo(m)<0))) m=i;
			for(int n=0;n<nonOrdered.length;n++)
				if(!nonOrdered[n].equals("") &&
						((reverse==0 && nonOrdered[n].compareTo(m)<=0) || 
						(reverse==1 && nonOrdered[n].compareTo(m)>=0)))
							{ m=nonOrdered[n]; del=n; }
			ordered[pos++]=m; nonOrdered[del]="";
		}
		return ordered;
	}
	public static String[] ordenar(String[] nonOrdered) { return ordenar(nonOrdered,0); }
}
