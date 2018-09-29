import java.util.Arrays;
import java.util.Scanner;

public class DEHamming {
	
	private byte[] geraArrayBits(byte c1, byte c2, byte c4, byte c8) {
		byte retorno[] = {c1, c2, c4, c8};
		return retorno;
	}
	
	private byte[] calculaBitsDeTeste(byte seq[]) {
		byte C1 = (byte) (seq[0] ^ seq[1] ^ seq[3] ^ seq[4] ^ seq[6]);
		byte C2 = (byte) (seq[0] ^ seq[2] ^ seq[3] ^ seq[5] ^ seq[6]);
		byte C4 = (byte) (seq[1] ^ seq[2] ^ seq[3] ^ seq[7]);
		byte C8 = (byte) (seq[4] ^ seq[5] ^ seq[6] ^ seq[7]);
		
		return geraArrayBits(C1, C2, C4, C8);
	}
	
	public byte[] geraBitsDeTeste(byte seq[]) {		
		return calculaBitsDeTeste(seq);
	}
	
	public String posicaoErro(byte sequencia[], byte sequencia2[]) {
		byte[] seq = this.geraBitsDeTeste(sequencia);
		byte[] seq2 = this.geraBitsDeTeste(sequencia2);
		String retorno = "";
		
		retorno += (byte) (seq[3] ^ seq2[3]);
		retorno += (byte) (seq[2] ^ seq2[2]);
		retorno += (byte) (seq[1] ^ seq2[1]);
		retorno += (byte) (seq[0] ^ seq2[0]);

		return retorno;
	}
	
	public void corrige(byte sequencia[], byte sequencia2[]) {
		String posicao = this.posicaoErro(sequencia, sequencia2);
		switch(posicao) {
			case "0011":
				inverter(sequencia, 0);
				break;
			case "0101":
				inverter(sequencia, 1);
				break;
			case "0110":
				inverter(sequencia, 2);
				break;
			case "0111":
				inverter(sequencia, 3);
				break;
			case "1001":
				inverter(sequencia, 4);
				break;
			case "1010":
				inverter(sequencia, 5);
				break;
			case "1011":
				inverter(sequencia, 6);
				break;
			case "1100":
				inverter(sequencia, 7);
				break;
		}
	}
	

	private void inverter(byte[] sequencia, int i) {
		if(sequencia[i] == 1)
			sequencia[i] = 0;
		else
			sequencia[i] = 1;
		
	}

	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		DEHamming hamming = new DEHamming();
		
		byte sequencia[] = {0,0,1,1,1,0,0,1};
		byte sequencia2[] = {0,0,1,1,1,0,0,1};
		
		hamming.corrige(sequencia, sequencia2);
		System.out.println(Arrays.toString(sequencia));
		
	}

}
