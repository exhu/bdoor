/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdoorProto;

/**
 * Little-endian int32, int32 string length, string chars, optional bin length,
 * bin data.
 * @author yur
 */
public class Packet {
	protected int id; // new for request, negative for reply
	protected int command;
	protected byte [] data; // binary payload
	
	private static int prevId = 0;
	
	protected static int nextId() {
		if (prevId == Integer.MAX_VALUE)
			prevId = 1;
		else
			++prevId;
		
		return prevId;
	}
}
