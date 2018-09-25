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
	
	public byte[] posicaoErro(byte sequencia[], byte sequencia2[]) {
		byte[] seq = this.geraBitsDeTeste(sequencia);
		byte[] seq2 = this.geraBitsDeTeste(sequencia2);

		byte p1 = (byte) (seq[0] ^ seq2[0]);
		byte p2 = (byte) (seq[1] ^ seq2[1]);
		byte p4 = (byte) (seq[2] ^ seq2[2]);
		byte p8 = (byte) (seq[3] ^ seq2[3]);
		
		byte[] posicaoB = {p8, p4, p2, p1};
		return posicaoB;
	}
	
	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		DEHamming hamming = new DEHamming();
		
		byte sequencia[] = {0,0,1,1,1,0,0,1};
		byte sequencia2[] = {0,0,0,1,1,0,0,1};
		
		System.out.println(Arrays.toString(hamming.posicaoErro(sequencia, sequencia2)));

	}

}
