import java.util.Scanner;

public class DEParidade {
	
	public int quantUm(byte seq[]) {
		int cont = 0;
		
		for (int i = 0; i < seq.length; i++) {
			if(seq[i] == 1)
				cont++;
		}
		return cont;
	}
	
	public boolean correto(byte seq[], boolean paridade) {
		boolean retorno = false;
		int quantUm = this.quantUm(seq);
		
		if((quantUm % 2) == 0 && paridade)
			retorno = true;
				
		if((quantUm % 2) != 0 && !paridade)
			retorno = true;
	
		return retorno;
	}

	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		DEParidade detectorDeErros = new DEParidade();
		
		byte sequencia[] = {1,0,0,0,0,1};
		
		System.out.println(detectorDeErros.correto(sequencia, true));
	}

}
