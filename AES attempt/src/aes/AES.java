package aes;

public class AES {
	private int[] key;
	private String message;
	
	public AES(int[] key) {
		this.key = key;
	}
	
	public String AESEncrpyt(String input ){
		this.message = input;
		int numOfRounds = 0;
		KeyExpansion();
		AddRoundKey();
		InitialRound();
		for(int i = 0; i < numOfRounds; i ++){
			SubBytes();
			ShiftRows();
			MixColumns();
			AddRoundKey();
		}
		//final round
		SubBytes();
		ShiftRows();
		AddRoundKey();
		return null;
	}

	private void SubBytes() {
		// TODO Auto-generated method stub
		
	}

	private void ShiftRows() {
		// TODO Auto-generated method stub
		
	}

	private void MixColumns() {
		// TODO Auto-generated method stub
		
	}

	private void InitialRound() {
		// TODO Auto-generated method stub
		
	}

	private void AddRoundKey() {
		// TODO Auto-generated method stub
		
	}

	private void KeyExpansion() {
		// TODO Auto-generated method stub
		
	}
}
