package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import gui6.Screen;
import gui6.components.Button;
import gui6.components.TextArea;
import gui6.components.Visible;

public class AESScreen extends Screen implements MouseListener{
	private TextArea title;
	private Button toNotes;
	private Button toHistory;

	public AESScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
	public String AESencrypt(String text,String key){ // 128 bit key
		byte[] encrypted = null;

		// Create key and cipher
		Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
		Cipher cipher = null;
		try {
			cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// encrypt the text
		try {
			cipher.init(Cipher.ENCRYPT_MODE, aesKey);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			cipher.init(Cipher.ENCRYPT_MODE, aesKey);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			encrypted = cipher.doFinal(text.getBytes());
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new String(Base64.getEncoder().encodeToString(encrypted));

	}
	public String aesDecrypt(String input,String key){// 128 bit key
		String decrypted = null;
		Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
		Cipher cipher = null;
		
		try {
			cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			cipher.init(Cipher.DECRYPT_MODE, aesKey);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			decrypted = new String(cipher.doFinal(input.getBytes()));
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return decrypted;
	}
	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
