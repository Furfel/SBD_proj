package pg.ppabis.bazy1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/*
 * 2017 (c) Piotr Pabis 149528 Grupa 6B
 * */

public class Main {

	public static void main(String[] args) {
		if(args.length<1) {
			System.out.println("Usage: Main <COMMAND> [OPTIONS]");
		} else {
			if(args[0].equalsIgnoreCase("create")) {
				if(args.length>2){
					Tasma tasma = new Tasma(new File(args[1]));
					tasma.openAsOutput();
					int number = Integer.parseInt(args[2]);
					for(int i=0;i<number;++i) {
						tasma.writeNext(Rekord.losowy());
					}
					tasma.flush();
				} else {
					System.err.println("use create file.bin number");
				}
			} else if(args[0].equalsIgnoreCase("view")) {
				if(args.length>1) {
					Tasma tasma = new Tasma(new File(args[1]));
					tasma.openAsInput();
					Rekord r = tasma.readNext();
					while(r!=null) {
						System.out.println(r);
						r = tasma.readNext();
					}
				} else {System.err.println("use view file.bin");}
			}
		}
	}

}
